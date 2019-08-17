package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * {@link Comment}'s persistence layer.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  /**
   * Finds all {@link Comment}s by a given {@link Post}.
   * @param post
   * @return comments
   */
  Collection<Comment> findByPost(Post post);

}
