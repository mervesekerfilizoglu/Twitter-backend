package com.example.twitter_backend.repository;

import com.example.twitter_backend.model.Comment;
import com.example.twitter_backend.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTweetOrderByCreatedAtDesc(Tweet tweet);
}