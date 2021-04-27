package br.com.qualitytecnologia.repository;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.domain.Blog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Blog entity.
 */
@SuppressWarnings("unused")
@Repository
@GeneratedByJHipster
public interface BlogRepository extends JpaRepository<Blog, Long> {}
