package com.ciandt.skeleton.web.rest.v1.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResource {
  private Long code;
  private UserResource author;
  private String text;
  private Date publishedAt;
}
