package com.ciandt.skeleton.web.rest.v1.assembler;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.web.rest.v1.resource.CommentResource;
import com.vidolima.copypropertiesassembler.GenericAssembler;
import org.springframework.stereotype.Component;

@Component
public class CommentAssembler extends GenericAssembler<Comment, CommentResource> {

  public CommentAssembler() {
    super(Comment.class, CommentResource.class);
  }

}
