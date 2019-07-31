package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.PostBusiness;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.resource.PostResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller that specifies the {@link Post} operations trow HTTP rest.
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
public class PostRestController extends RestControllerBase {

  private PostBusiness postBusiness;

  @Autowired
  public PostRestController(PostBusiness postBusiness) {
    this.postBusiness = postBusiness;
  }

  /**
   * Creates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PostMapping(path = "/posts")
  public ResponseEntity create(PostResource resource) {
    return null;
  }

  /**
   * Gets a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @GetMapping(path = "/posts/{id}")
  public ResponseEntity get() {
    return null;
  }

  /**
   * Updates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PutMapping(path = "/posts/{id}")
  public ResponseEntity update(PostResource resource) {
    return null;
  }

  /**
   * Deletes a {@link Post}.
   */
  @DeleteMapping(path = "/posts/{id}")
  public ResponseEntity delete(PostResource resource) {
    return null;
  }

}
