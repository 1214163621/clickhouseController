package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.HoldStorage;
import com.example.demo.mapper.HoldStorageMapper;
import com.example.demo.service.IHoldStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class HoldStorageServiceImpl extends ServiceImpl<HoldStorageMapper,HoldStorage> implements IHoldStorageService {
    @Resource
    HoldStorageMapper holdStorageMapper;
    public Page<HoldStorage> searchAll(){
        LambdaQueryWrapper<HoldStorage> wrapper = Wrappers.<HoldStorage>lambdaQuery();
        return holdStorageMapper.selectPage(new Page<>(1, 10), wrapper);
    }
}
