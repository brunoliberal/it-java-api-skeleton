package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Comment}'s business layer.
 * The business layer is responsible for handling business logic such as:
 * ensure business flow, validations, throw business exceptions, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Component
public class CommentBusiness {

  private CommentService commentService;

  @Autowired
  public CommentBusiness(CommentService commentService) {
    this.commentService = commentService;
  }

  /**
   * Finds a {@link Comment} by a given {@link Post}.
   * @param post
   * @return comment
   */
  public Comment findByPost(final Post post) {
    return this.commentService.findByPost(post);
  }

  // TODO: find by post

  /**
   * Creates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment create(Comment comment) {
    return this.commentService.create(comment);
  }

  /**
   * Updates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment update(Comment comment) {
    return this.commentService.update(comment);
  }

  /**
   * Deletes a {@link Comment}.
   * @param comment
   */
  @Transactional
  public void delete(Comment comment) {
    this.commentService.delete(comment);
  }


}
