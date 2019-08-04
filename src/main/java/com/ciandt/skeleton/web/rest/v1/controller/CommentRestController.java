package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.web.rest.v1.resource.CommentResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  /**
   * Creates a {@link Comment}.
   * @return ResponseEntity {@link CommentResource}
   */
  @PostMapping(path = "/comments")
  public ResponseEntity create(CommentResource resource) {
    return null;
  }

  /**
   * Gets a {@link Comment}.
   * @return ResponseEntity {@link CommentResource}
   */
  @GetMapping(path = "/comments/{id}")
  public ResponseEntity get() {
    return null;
  }

  /**
   * Updates a {@link Comment}.
   * @return ResponseEntity {@link CommentResource}
   */
  @PutMapping(path = "/comments/{id}")
  public ResponseEntity update(CommentResource resource) {
    return null;
  }

  /**
   * Deletes a {@link Comment}.
   */
  @DeleteMapping(path = "/comments/{id}")
  public ResponseEntity delete(CommentResource resource) {
    return null;
  }

}
