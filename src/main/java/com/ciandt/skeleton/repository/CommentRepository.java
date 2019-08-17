package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Comment}'s persistence layer.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
