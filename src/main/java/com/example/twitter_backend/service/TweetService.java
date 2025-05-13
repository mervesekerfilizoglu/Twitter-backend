package com.example.twitter_backend.service;

import com.example.twitter_backend.dto.TweetDto;
import com.example.twitter_backend.dto.UserDto;
import com.example.twitter_backend.exception.TweetNotFoundException;
import com.example.twitter_backend.model.Tweet;
import com.example.twitter_backend.model.User;
import com.example.twitter_backend.repository.TweetRepository;
import com.example.twitter_backend.repository.UserRepository;
import com.example.twitter_backend.security.JWTGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    private final JWTGenerator jwtGenerator;
    private final LikeService likeService;
    private final CommentService commentService;

    public TweetService(TweetRepository tweetRepository,
                        UserRepository userRepository,
                        JWTGenerator jwtGenerator,
                        LikeService likeService,
                        CommentService commentService) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
        this.jwtGenerator = jwtGenerator;
        this.likeService = likeService;
        this.commentService = commentService;
    }

    public List<TweetDto> getAllTweets() {
        return tweetRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public TweetDto createTweet(String content, String token) {
        String username = jwtGenerator.getUsernameFromJWT(token.substring(7));
        User user = userRepository.findByUsername(username).orElseThrow();

        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweet.setUser(user);

        return convertToDto(tweetRepository.save(tweet));
    }

    private TweetDto convertToDto(Tweet tweet) {
        TweetDto dto = new TweetDto();
        dto.setId(tweet.getId());
        dto.setContent(tweet.getContent());
        dto.setCreatedAt(tweet.getCreatedAt());

        UserDto userDto = new UserDto();
        userDto.setId(tweet.getUser().getId());
        userDto.setName(tweet.getUser().getName());
        userDto.setUsername(tweet.getUser().getUsername());
        userDto.setEmail(tweet.getUser().getEmail());
        dto.setUser(userDto);

        dto.setLikeCount(likeService.getLikeCount(tweet));
        dto.setComments(commentService.getCommentsForTweet(tweet));

        return dto;
    }

    public Tweet findTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new TweetNotFoundException("Tweet not found with id: " + tweetId));
    }
}