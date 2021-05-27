package com.redis.service;


import com.redis.model.Comment;
import com.redis.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BlogService {

    private static final Logger logger = LoggerFactory.getLogger(BlogService.class);

    private final RestTemplate restTemplate;

    public BlogService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //save post
    @Async("threadPoolTaskExecutor")
    public Post[]  savePost() throws InterruptedException {

        final String uri = "https://my-json-server.typicode.com/typicode/demo/posts";
        RestTemplate restTemplate = new RestTemplate();
        Post[] result  = restTemplate.getForObject(uri, Post[].class);
        System.out.println(result);
        return result;
    }

    //save comment
    @Async("threadPoolTaskExecutor")
    public Comment[]  saveComment() throws InterruptedException {

        final String uri = "https://my-json-server.typicode.com/typicode/demo/comments";
        RestTemplate restTemplate = new RestTemplate();
        Comment[] result  = restTemplate.getForObject(uri, Comment[].class);
        System.out.println(result);
        return result;
    }


}
