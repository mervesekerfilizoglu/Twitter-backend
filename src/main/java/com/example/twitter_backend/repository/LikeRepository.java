package com.example.twitter_backend.repository;

import com.example.twitter_backend.model.Like;
import com.example.twitter_backend.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like, Long> {
    int countByTweet(Tweet tweet);

}