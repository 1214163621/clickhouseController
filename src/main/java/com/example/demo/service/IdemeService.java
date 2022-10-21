package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Ldeme;
import com.example.demo.mapper.IdemeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class IdemeService {
    @Resource
    IdemeMapper idemeMapper;
    public Page<Ldeme> searchAll(){
        LambdaQueryWrapper<Ldeme> wrapper = Wrappers.<Ldeme>lambdaQuery();
        return idemeMapper.selectPage(new Page<>(1, 10), wrapper);
    }
    public Integer create(Ldeme ldeme){
        LambdaQueryWrapper<Ldeme> wrapper = Wrappers.<Ldeme>lambdaQuery();
        return idemeMapper.insert(ldeme);
    }
    public Integer update(Ldeme ldeme){
        LambdaQueryWrapper<Ldeme> wrapper = Wrappers.<Ldeme>lambdaQuery();
        return idemeMapper.updateById(ldeme);
    }
}
