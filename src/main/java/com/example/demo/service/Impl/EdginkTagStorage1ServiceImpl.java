package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.EdginkTagStorage1;
import com.example.demo.mapper.EdginkTagStorage1Mapper;
import com.example.demo.service.IEdginkTagStorageService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class EdginkTagStorage1ServiceImpl extends ServiceImpl<EdginkTagStorage1Mapper, EdginkTagStorage1> implements IEdginkTagStorageService1 {
    @Resource
    EdginkTagStorage1Mapper edgink_tag_storage1Mapper;
    public Page<EdginkTagStorage1> searchAll(){
        LambdaQueryWrapper<EdginkTagStorage1> wrapper = Wrappers.<EdginkTagStorage1>lambdaQuery();
        return edgink_tag_storage1Mapper.selectPage(new Page<>(1, 3000), wrapper);
    }
}
