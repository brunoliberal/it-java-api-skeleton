package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.PostResporitory;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostResporitory postResporitory;

  @Autowired
  public PostService(PostResporitory postResporitory) {
    this.postResporitory = postResporitory;
  }

  public Post findById(Long code) {
    return this.postResporitory.getOne(code);
  }

  @Transactional
  public Post create(Post post) {
    return this.postResporitory.save(post);
  }

  @Transactional
  public Post update(Post post) {
    return this.postResporitory.save(post);
  }

  @Transactional
  public void delete(Post post) {
    this.postResporitory.delete(post);
  }

}
