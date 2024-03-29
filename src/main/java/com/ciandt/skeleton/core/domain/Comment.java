package com.ciandt.skeleton.core.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

/**
 * This class represents an {@link User}'s comment in a {@link Post}.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "COMM_CD_COMMENT")
  private Long code;

  @ManyToOne
  @JoinColumn(name = "USER_TX_LOGIN", referencedColumnName = "USER_TX_LOGIN", nullable = false)
  private User author;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "COMM_DT_CREATE")
  private Date publishedAt;

  @Column(name = "COMM_TX_TEXT")
  private String text;

  @PrePersist
  public void prePersist() {
    this.publishedAt = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    this.publishedAt = new Date();
  }

  /**
   * Updates the current Comment with the new values.
   * @param comment
   */
  public void applyUpdate(final Comment comment) {
    this.text = comment.getText();
  }

}