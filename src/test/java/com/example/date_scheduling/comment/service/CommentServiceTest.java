package com.example.date_scheduling.comment.service;

import com.example.date_scheduling.comment.entity.CommentEntity;
import com.example.date_scheduling.comment.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentRepository repository;

    @Test
    @DisplayName("추가가 잘 되는가")
    void savetest(){
        //given
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setPostid("포아이디");
        commentEntity.setUserid("유저아이디");
        commentEntity.setContent("내용");
        //when
        boolean save = repository.save(commentEntity);
        //then
        Assertions.assertTrue(save);
    }
}