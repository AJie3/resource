package com.example.helloword.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloword.mapper.UserMapper;
import com.example.helloword.pojo.User;
import com.example.helloword.utils.PageResult;
import com.example.helloword.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FileController fileController;

    /**
     * 查询所有用户，具有分页功能
     * @return Result
     */
    @RequestMapping(value = "/selectTbUserAllByPage",method = RequestMethod.GET)
    public IPage selectTbItemAllByPage(){
        Page<User> page = new Page<>(0, 2);
        IPage iPage = userMapper.selectTbUserAllByPage(page, null);
        return iPage;
    }

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList = userMapper.getUserList();
        if (userList != null && userList.size() != 0){
            return userList;
        }
        return userList;
    }

    /**
     * 根据ID查询用户
     * */
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id){
        User userById = userMapper.getUserById(id);
        return userById;
    }

    /**
     * 新增用户
     * */
    @PostMapping("/postUser")
    public Integer postUser(User user, MultipartFile photo, HttpServletRequest request){
        int userMaxId = userMapper.getUserMaxId();
        user.setId(userMaxId + 1);
        Integer integer = userMapper.insUser(user);
        System.out.println(user);
        return integer;
    }

    /**
     * 根据ID更新用户
     * */
    @PutMapping("/putUser")
    public Integer putUser(User user){
        Integer integer = userMapper.putUser(user);
        return integer;
    }

    /**
     * 根据ID删除用户
     * */
    @DeleteMapping("/delUserById/{id}")
    public Integer delUserById(@PathVariable int id){
        Integer integer = userMapper.delUserByids(id);
        return integer;
    }
}
