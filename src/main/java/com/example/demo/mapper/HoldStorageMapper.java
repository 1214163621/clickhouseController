package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.HoldStorage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HoldStorageMapper extends BaseMapper<HoldStorage> {
    @Update("ALTER TABLE test.hold_storage UPDATE ITEM_VALUE=#{value}, GET_DATE = #{date}, QUALITIES = #{qualities} WHERE PLC_NAME = #{pname} AND TAG_NAME = #{tname}")
    public int update(@Param("value") String value, @Param("date") String date, @Param("qualities") String qualities, @Param("pname") String pname, @Param("tname") String tname);
    @Delete("ALTER TABLE test.hold_storage DELETE WHERE PLC_NAME=#{pname} AND TAG_NAME = #{tname};")
    public int delete(@Param("pname") String pname,@Param("tname") String tname);
//    List<User> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<User> userWrapper);
}
