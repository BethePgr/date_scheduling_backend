package com.example.date_scheduling.user.api;

import com.example.date_scheduling.user.entity.UserEntity;
import com.example.date_scheduling.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserService service;

    @Test
    @DisplayName("잘 교환되나")
    void changeit(){
        //given
        UserEntity userEntity = new UserEntity("a25afb31-e7aa-4bbd-9f22-cf4143c5ae3c",
                "닉네임즈","nickname","c33@naver.com","a123123!@");
        //when
        UserEntity userEntity1 = service.changeServ(userEntity);
        //then
        System.out.println(userEntity1);
    }
}