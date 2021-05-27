package com.redis.repository;
import com.redis.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Integer> {
}
