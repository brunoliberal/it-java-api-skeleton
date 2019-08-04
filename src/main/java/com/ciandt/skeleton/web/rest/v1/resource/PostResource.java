package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * This is the {@link Post}'s resource representation.
 * This class is responsible for expose the entity as a rest resource including
 * resource validations.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResource {
  private Long code;
  @NotNull
  private UserResource author;
  @NotEmpty
  @Min(value = 50)
  @Max(value = 400)
  private String text;
  private Date publishedAt;
}
