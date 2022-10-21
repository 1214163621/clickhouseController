package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.HoldStorage;

public interface IHoldStorageService extends IService<HoldStorage> {
    Page<HoldStorage> searchAll();
}
