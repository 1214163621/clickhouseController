package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Ldeme;
import com.example.demo.service.IdemeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/ideme")
public class IdemeController {
    @Resource
    IdemeService idemeService;
    @GetMapping
//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
    public Result getlist(){
//        System.out.println("xxx");
        return Result.success(idemeService.searchAll());
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody Ldeme ldeme){
        System.out.println(ldeme);
        return Result.success(idemeService.create(ldeme));
    }
    @PostMapping("/update")
    public Result update(@RequestBody Ldeme ldeme){
        System.out.println(ldeme);
        return Result.success(idemeService.update(ldeme));
    }

//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
//    public void  timeScheduled(){
//        System.out.println("xxx");
//    }


}
