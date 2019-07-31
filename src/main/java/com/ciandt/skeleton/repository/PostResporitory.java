package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Post}'s persistence layer.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface PostResporitory extends JpaRepository<Post, Long> {
}
