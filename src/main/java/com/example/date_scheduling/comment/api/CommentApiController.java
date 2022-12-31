package com.example.date_scheduling.comment.api;

import com.example.date_scheduling.comment.dto.JustContent;
import com.example.date_scheduling.comment.dto.PostandCommentid;
import com.example.date_scheduling.comment.entity.CommentEntity;
import com.example.date_scheduling.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentApiController {

    private final CommentService service;

    @GetMapping
    public ResponseEntity<?> show(@RequestBody String postid){
        log.info("GET MAPPING - COMMENTENTITY {}",postid);
        return ResponseEntity.ok().body(service.showServ(postid));
    }

    @GetMapping("/comment")
    public ResponseEntity<?> showOne(@RequestBody String commentid){
        return ResponseEntity.ok().body(service.showOneServ(commentid));
    }

    @PostMapping
    public ResponseEntity<?> save(@AuthenticationPrincipal String username, @RequestBody JustContent content){
        try{
        CommentEntity commentEntity = new CommentEntity();

        //지금은 임의로 설정한것임.
        //commentEntity.setPostid("068ac7a8-16e1-4b7f-a271-65f3714e21a1");
        commentEntity.setUserid(username);
        commentEntity.setContent(content.getContent());
        return ResponseEntity.ok().body(service.saveServ(commentEntity));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> modify(@AuthenticationPrincipal String username, @RequestBody CommentEntity commentEntity){
        try{
            
            return ResponseEntity.ok().body(service.modifyServ(commentEntity));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@AuthenticationPrincipal String username,@RequestBody PostandCommentid postandCommentid){
        try{
            List<CommentEntity> commentEntities = service.deleteServ(postandCommentid.getPostid(), postandCommentid.getCommentid());
            return ResponseEntity.ok().body(commentEntities);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
