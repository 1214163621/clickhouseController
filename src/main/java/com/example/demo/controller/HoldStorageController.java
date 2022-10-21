package com.example.demo.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Connect;
import com.example.demo.common.Result;
import com.example.demo.entity.HoldStorage;
import com.example.demo.mapper.HoldStorageMapper;
import com.example.demo.service.IEdginkTagStorageService;
import com.example.demo.service.IEdginkTagStorageService1;
import com.example.demo.service.IHoldStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/hold")
public class HoldStorageController {
    @Resource
    IHoldStorageService iHoldStorageService;
    @Resource
    HoldStorageMapper holdStorageMapper;
    @Resource
    IEdginkTagStorageService iEdginkTagStorageService;
    @Resource
    IEdginkTagStorageService1 iEdginkTagStorageService1;
    Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @GetMapping("/getall")
//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
    public Result getlist() {
//        System.out.println("xxx");
        return Result.success(iHoldStorageService.searchAll());
    }

    @PostMapping("/update")
//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
    public Result update(@RequestBody HoldStorage holdStorage) {
        return Result.success(holdStorageMapper.update("20", "2021-09-16 09:28:57", "Good", "60T", "工作温度"));
    }

    @PostMapping("/delete")
//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
    public Result delete(@RequestBody HoldStorage holdStorage) {
//        System.out.println("xxx");
        System.out.println(holdStorageMapper.delete("60T", "砂B"));
        return Result.success(holdStorageMapper.delete("60T", "工作温度"));
    }

    @Scheduled(cron = "*/5 * * * * ?")
//    @Transactional
    public boolean saveBatch() {
//        从数据源处获得 webservice
        JSONArray jsonArray = Connect.request("127.0.0.1:9970/edg/getall").getJSONObject("data").getJSONArray("records");
//        原数据
        List<HoldStorage> slist = jsonArray.toJavaList(HoldStorage.class);
        slist.get(0).setValue("32");
        slist.get(1).setPlc_name("test");
        slist.get(1).setTag_name("Ttest");
        slist.get(2).setPlc_name("A");
//       slist.get(2).setTag_name("Ttest");
//       暂存数据
        List<HoldStorage> hlist = iHoldStorageService.list();
//       需要更新数据
        List nlist = new ArrayList();
        for (HoldStorage holdStorage : slist) {
            String splcname = holdStorage.getPlc_name();
            String stagname = holdStorage.getTag_name();
            String svalue = holdStorage.getValue();
            LambdaQueryWrapper<HoldStorage> wrapper = Wrappers.<HoldStorage>lambdaQuery();
            wrapper.eq(HoldStorage::getPlc_name, splcname).eq(HoldStorage::getTag_name, stagname).eq(HoldStorage::getValue, svalue);
            Integer count = iHoldStorageService.listObjs(wrapper).size();
            if (count > 0) {
//                在中间表中查询到 plc_name tag_name value 均相等
            } else if (count == 0) {
//                查询不到相等的数据
                LambdaQueryWrapper<HoldStorage> _wrapper = Wrappers.<HoldStorage>lambdaQuery();
                _wrapper.eq(HoldStorage::getPlc_name, splcname).eq(HoldStorage::getTag_name, stagname);
                System.out.println(splcname + stagname + svalue);
                Integer _count = iHoldStorageService.listObjs(_wrapper).size();
                if (_count == 0) {
//                    不存在同设备同断电的数据,插入中间表新的点
                    iHoldStorageService.save(holdStorage);
                } else if (_count == 1) {
                    //存在plc_name和 tag_name 相等的数据 需要更新value
                    try {
                        holdStorageMapper.delete(splcname, stagname);
                        iHoldStorageService.save(holdStorage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error(e.getMessage());
                    }
                } else {
                    log.error("中间表数据冗余" + holdStorage);
                }
//                iHoldStorageService.saveOrUpdate(holdStorage,_wrapper);
                long id = snowflake.nextId();
                holdStorage.setS_id(id);
                nlist.add(holdStorage);
            } else {
                log.error("设备出现重复" + holdStorage);
            }
//            System.out.println(holdStorage);
//            System.out.println(hlist.contains(holdStorage));
        }
        System.out.println(nlist);
        try {
            iEdginkTagStorageService1.saveBatch(nlist);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

//       return holdStorageService.saveBatch(jsonArray.toJavaList(HoldStorage.class));
        return true;
    }
}
