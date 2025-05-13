package com.example.twitter_backend.service;

import com.example.twitter_backend.dto.CommentDto;
import com.example.twitter_backend.model.Comment;
import com.example.twitter_backend.model.Tweet;
import com.example.twitter_backend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getCommentsForTweet(Tweet tweet) {
        return commentRepository.findByTweetOrderByCreatedAtDesc(tweet)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CommentDto convertToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setTweetId(comment.getTweet().getId());
        return dto;
    }
}