package com.ciandt.skeleton.core.domain;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

/**
 * This class represents a post made by an {@link User} in the blog.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "POST_CD_POST")
  private Long code;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(unique = true)
  private User author;

  @Column(name = "POST_TX_POST")
  private String text;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "POST_DT_CREATE")
  private Date publishedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private Collection<Comment> comments;

}
