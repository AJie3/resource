package com.example.helloword.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloword.pojo.User;
import com.example.helloword.utils.PageResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户，具有分页功能
     * @param page
     */
    @Select("select * from user")
    IPage<User> selectTbUserAllByPage(IPage<?> page, Integer state);

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    public List<User> getUserList();

    /**
     * 根据ID查询用户
     * */
    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select max(id)as id from user")
    int getUserMaxId();

    /**
     * 新增用户
     * */
    @Insert("insert into user values(#{id},#{username},#{phone})")
    Integer insUser(User user);

    /**
     * 根据ID更新用户
     * */
    @Update("update user set username=#{username},phone=#{phone} where id=#{id}")
    Integer putUser(User user);

    /**
     * 根据ID删除用户
     * */
    @Delete("delete from user where id=#{id}")
    Integer delUserByids(int id);
}
