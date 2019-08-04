package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.PostBusiness;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.assembler.PostAssembler;
import com.ciandt.skeleton.web.rest.v1.resource.PostResource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that specifies the {@link Post} operations through HTTP REST.
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
public class PostRestController extends RestControllerBase {

  private PostBusiness postBusiness;
  private PostAssembler postAssembler;

  @Autowired
  public PostRestController(PostBusiness postBusiness, PostAssembler postAssembler) {
    this.postBusiness = postBusiness;
    this.postAssembler = postAssembler;
  }

  /**
   * Gets a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @GetMapping(path = "/posts/{id}")
  public ResponseEntity get(Long code) {
    Post post = this.postBusiness.findPostById(code);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Creates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PostMapping(path = "/posts")
  public ResponseEntity create(@Valid PostResource resource) {
    Post domain = this.postAssembler.fromResource(resource);
    Post post = this.postBusiness.create(domain);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Updates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PutMapping(path = "/posts/{id}")
  public ResponseEntity update(@Valid PostResource resource) {
    Post domain = this.postAssembler.fromResource(resource);
    Post post = this.postBusiness.update(domain);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Deletes a {@link Post}.
   */
  @DeleteMapping(path = "/posts/{id}")
  public void delete(@Valid PostResource resource) {
    Post post = this.postAssembler.fromResource(resource);
    this.postBusiness.delete(post);
  }

}
