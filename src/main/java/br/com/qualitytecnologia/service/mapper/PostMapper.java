package br.com.qualitytecnologia.service.mapper;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.domain.*;
import br.com.qualitytecnologia.service.dto.PostDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Post} and its DTO {@link PostDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
@GeneratedByJHipster
public interface PostMapper extends EntityMapper<PostDTO, Post> {}
