package com.lhy.mybatis1.controller;

import com.lhy.mybatis1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class UserControllerTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void findOrderByUserId() {
        log.info(userMapper.findOrderByUserId(3).toString());
    }
}