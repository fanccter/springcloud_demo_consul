package com.fanciter.data.db.mapper;

import com.fanciter.data.db.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

    List<User> selectByNameAndPwd(@Param("name")String name, @Param("password")String password);
}