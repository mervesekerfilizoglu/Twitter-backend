package com.example.twitter_backend.controller;

import com.example.twitter_backend.dto.TweetDto;
import com.example.twitter_backend.service.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public ResponseEntity<List<TweetDto>> getAllTweets() {
        return new ResponseEntity<>(tweetService.getAllTweets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TweetDto> createTweet(@RequestBody String content,
                                                @RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(tweetService.createTweet(content, token), HttpStatus.CREATED);
    }
}