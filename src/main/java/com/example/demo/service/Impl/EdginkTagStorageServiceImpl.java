package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.EdginkTagStorage;
import com.example.demo.mapper.EdginkTagStorageMapper;
import com.example.demo.service.IEdginkTagStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class EdginkTagStorageServiceImpl extends ServiceImpl<EdginkTagStorageMapper, EdginkTagStorage> implements IEdginkTagStorageService {
    @Resource
    EdginkTagStorageMapper edgink_tag_storageMapper;
    public Page<EdginkTagStorage> searchAll(){
        LambdaQueryWrapper<EdginkTagStorage> wrapper = Wrappers.<EdginkTagStorage>lambdaQuery();
        wrapper.ge(EdginkTagStorage::getS_id, 10492).le(EdginkTagStorage::getS_id, 10496);
        return edgink_tag_storageMapper.selectPage(new Page<>(1, 5), wrapper);
    }
}
