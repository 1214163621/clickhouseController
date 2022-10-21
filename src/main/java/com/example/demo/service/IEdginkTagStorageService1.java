package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.EdginkTagStorage1;
import com.example.demo.entity.HoldStorage;

public interface IEdginkTagStorageService1 extends IService<EdginkTagStorage1> {
    Page<EdginkTagStorage1> searchAll();
}
