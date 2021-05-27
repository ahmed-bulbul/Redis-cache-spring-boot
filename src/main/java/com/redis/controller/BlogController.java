package com.redis.controller;

import com.redis.model.Comment;
import com.redis.model.Post;
import com.redis.repository.CommentRepository;
import com.redis.repository.PostRepository;
import com.redis.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {


    @Autowired
    BlogService blogService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    //post data
    @PostMapping("/post")
    public ResponseEntity<?> getPost() throws InterruptedException {
        try{
            for(Post post : blogService.savePost()){
                postRepository.save(post);
            }
            return ResponseEntity.ok("Post save successfully");
        }catch(Exception e){

        }
        return ResponseEntity.ok("Post Not Saved");
    }

    //comment data
    @PostMapping("/comments")
    public ResponseEntity<?> getComment() throws InterruptedException {
        try{
            for(Comment comment : blogService.saveComment()){
                commentRepository.save(comment);
            }
            return ResponseEntity.ok("Comment save successfully");
        }catch(Exception e){
        }
        return ResponseEntity.ok("Comment Not Saved");
    }

    //get all post
    @GetMapping("/posts")
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(postRepository.findAll());
    }

    //get all comment
    @GetMapping("/comments")
    public ResponseEntity<?> getComments(){
        return ResponseEntity.ok(commentRepository.findAll());
    }


}

