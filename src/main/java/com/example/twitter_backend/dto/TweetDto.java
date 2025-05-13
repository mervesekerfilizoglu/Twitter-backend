package com.example.twitter_backend.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TweetDto {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private UserDto user;
    private int likeCount;
    private List<CommentDto> comments;
}