package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the {@link Comment}'s service layer.
 * The service layer is responsible for handling infrastructure code such as:
 * repository, cache, ftp, queue, sms, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Service
public class CommentService {

  private CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  /**
   * Finds a {@link Comment} by id (code).
   * @param code
   * @return comment
   */
  public Comment findById(Long code) {
    return this.commentRepository.getOne(code);
  }

  /**
   * Creates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment create(Comment comment) {
    return this.commentRepository.save(comment);
  }

  /**
   * Updates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment update(Comment comment) {
    return this.commentRepository.save(comment);
  }

  /**
   * Deletes a {@link Comment}.
   * @param comment
   */
  @Transactional
  public void delete(Comment comment) {
    this.commentRepository.delete(comment);
  }

}