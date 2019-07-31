package com.ciandt.skeleton.web.rest.v1.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResource {
  private String login;
  private String name;
}
