package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.repository.CommentRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public Comment findById(Long code) {
    return this.commentRepository.getOne(code);
  }

  @Transactional
  public Comment create(Comment comment) {
    return this.commentRepository.save(comment);
  }

  @Transactional
  public Comment update(Comment comment) {
    return this.commentRepository.save(comment);
  }

  @Transactional
  public void delete(Comment comment) {
    this.commentRepository.delete(comment);
  }

}