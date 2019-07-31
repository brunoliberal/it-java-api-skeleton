package com.ciandt.skeleton.web.rest.v1.assembler;

import com.ciandt.skeleton.core.domain.User;
import com.ciandt.skeleton.web.rest.v1.resource.UserResource;
import com.vidolima.copypropertiesassembler.GenericAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler  extends GenericAssembler<User, UserResource> {

  public UserAssembler() {
    super(User.class, UserResource.class);
  }

}
