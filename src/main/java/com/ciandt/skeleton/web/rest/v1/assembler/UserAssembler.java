package com.ciandt.skeleton.web.rest.v1.assembler;

import com.ciandt.skeleton.core.domain.User;
import com.ciandt.skeleton.web.rest.v1.resource.UserResource;
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
public class UserAssembler  extends GenericAssembler<User, UserResource> {

  public UserAssembler() {
    super(User.class, UserResource.class);
  }

}
