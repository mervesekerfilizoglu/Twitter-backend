package com.example.twitter_backend.service;

import com.example.twitter_backend.model.Like;
import com.example.twitter_backend.model.Tweet;
import com.example.twitter_backend.model.User;
import com.example.twitter_backend.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public int getLikeCount(Tweet tweet) {
        return likeRepository.countByTweet(tweet);
    }
}