package com.ciandt.skeleton.web.rest.v1.assembler;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.resource.PostResource;
import com.vidolima.copypropertiesassembler.GenericAssembler;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for copying the matching data from domain to
 * resource. The only require is to the both classes have the same param names.
 * You can override any method to do a custom conversion (data enhance).
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@Component
public class PostAssembler extends GenericAssembler<Post, PostResource> {

  public PostAssembler() {
    super(Post.class, PostResource.class);
  }

}
