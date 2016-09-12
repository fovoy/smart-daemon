package com.fovoy.daemon.dao;

import com.fovoy.daemon.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record")UserInfo record);

    int insertSelective(@Param("record") UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    UserInfo selectByUserName(@Param("userName")String userName);

    int updateByPrimaryKeySelective(@Param("record")UserInfo record);

    int updateByPrimaryKey(@Param("record")UserInfo record);

    UserInfo authUser(@Param("userId") String userId, @Param("password") String password);
}