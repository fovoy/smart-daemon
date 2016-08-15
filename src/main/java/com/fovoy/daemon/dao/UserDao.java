package com.fovoy.daemon.dao;

import com.fovoy.daemon.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record")User record);

    int insertSelective(@Param("record") User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserName(@Param("userName")String userName);

    int updateByPrimaryKeySelective(@Param("record")User record);

    int updateByPrimaryKey(@Param("record")User record);
}