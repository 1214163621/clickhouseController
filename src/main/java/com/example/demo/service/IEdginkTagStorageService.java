package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.EdginkTagStorage;

public interface IEdginkTagStorageService extends IService<EdginkTagStorage> {
    Page<EdginkTagStorage> searchAll();
}
