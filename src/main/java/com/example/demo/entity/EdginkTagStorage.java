package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("edgink_tag_storage")
@Data
public class EdginkTagStorage {
    @TableId(type = IdType.ASSIGN_ID ,value = "STORAGE_ID")
    private Long s_id;
    @TableField(value = "PLC_NAME")
    private String plc_name;
    @TableField(value = "TAG_NAME")
    private String tag_name;
    @TableField(value = "ITEM_VALUE")
    private String value;
    @TableField(value = "QUALITIES")
    private String qualities;
    @TableField(value = "GET_DATE")
    private Date date;
}
