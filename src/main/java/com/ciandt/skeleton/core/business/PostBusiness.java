package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Post}'s business layer.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Component
public class PostBusiness {

  private PostService postService;

  @Autowired
  public PostBusiness(PostService postService) {
    this.postService = postService;
  }

  public Post findPostById(Long code) {
    return this.postService.findById(code);
  }

  public Post create(Post post) {
    return null;
  }

  public Post update(Post post) {
    return null;
  }

  public void delete(Post post) {
  }

}
