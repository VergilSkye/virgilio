package br.com.qualitytecnologia.repository;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.domain.Post;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Post entity.
 */
@SuppressWarnings("unused")
@Repository
@GeneratedByJHipster
public interface PostRepository extends JpaRepository<Post, Long> {}
