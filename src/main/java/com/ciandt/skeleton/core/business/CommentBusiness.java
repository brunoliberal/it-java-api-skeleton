package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.service.CommentService;
import com.ciandt.skeleton.service.PostService;
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
  private PostBusiness postBusiness;

  @Autowired
  public CommentBusiness(CommentService commentService, PostBusiness postBusiness) {
    this.commentService = commentService;
    this.postBusiness = postBusiness;
  }

  /**
   * Creates a {@link Comment}.
   * @param postId
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment create(Long postId, Comment comment) {
    this.postBusiness.checkExist(postId);
    return this.commentService.create(comment);
  }

  /**
   * Updates a {@link Comment}.
   * @param code
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment update(Long code, Comment comment) {
    Comment tobeUpdated = this.commentService.findById(code);
    tobeUpdated.applyUpdate(comment);
    return this.commentService.update(tobeUpdated);
  }

  /**
   * Deletes a {@link Comment}.
   * @param code
   */
  @Transactional
  public void delete(Long code) {
    this.commentService.delete(code);
  }

}
