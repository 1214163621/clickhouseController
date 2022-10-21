package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.service.Impl.EdginkTagStorage1ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/cc")
public class EdginkTagStorage1Controller {
    @Resource
    EdginkTagStorage1ServiceImpl edgink_tag_storage1Service;
    @GetMapping
//    @Scheduled(cron = "*/5 * * * * ?")//每个5秒执行一次任务(方法)
    public Result getlist(){
//        System.out.println("xxx");
        return Result.success(edgink_tag_storage1Service.searchAll());
    }
}
