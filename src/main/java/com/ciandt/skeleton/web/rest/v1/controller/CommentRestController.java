package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.CommentBusiness;
import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.web.rest.v1.assembler.CommentAssembler;
import com.ciandt.skeleton.web.rest.v1.resource.CommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that specifies the {@link Comment} operations through HTTP REST.
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
public class CommentRestController extends RestControllerBase {

  private CommentBusiness commentBusiness;
  private CommentAssembler commentAssembler;

  @Autowired
  public CommentRestController(CommentBusiness commentBusiness, CommentAssembler commentAssembler) {
    this.commentBusiness = commentBusiness;
    this.commentAssembler = commentAssembler;
  }

  /**
   * Creates a {@link Comment}.
   * @return ResponseEntity {@link CommentResource}
   */
  @PostMapping(path = "/posts/{postId}/comments")
  public ResponseEntity create(@PathVariable Long postId, CommentResource resource) {
    Comment domain = this.commentAssembler.fromResource(resource);
    Comment comment = this.commentBusiness.create(postId, domain);
    return ResponseEntity.ok(this.commentAssembler.fromDomain(comment));
  }

  /**
   * Updates a {@link Comment}.
   * @return ResponseEntity {@link CommentResource}
   */
  @PutMapping(path = "/comments/{id}")
  public ResponseEntity update(@PathVariable Long id, CommentResource resource) {
    Comment domain = this.commentAssembler.fromResource(resource);
    Comment comment = this.commentBusiness.update(id, domain);
    return ResponseEntity.ok(this.commentAssembler.fromDomain(comment));
  }

  /**
   * Deletes a {@link Comment}.
   */
  @DeleteMapping(path = "/comments/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    commentBusiness.delete(id);
    return ResponseEntity.noContent().build();
  }

}
