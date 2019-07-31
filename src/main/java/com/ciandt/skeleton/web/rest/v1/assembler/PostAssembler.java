package com.ciandt.skeleton.web.rest.v1.assembler;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.resource.PostResource;
import com.vidolima.copypropertiesassembler.GenericAssembler;
import org.springframework.stereotype.Component;

@Component
public class PostAssembler extends GenericAssembler<Post, PostResource> {

  public PostAssembler() {
    super(Post.class, PostResource.class);
  }

}
