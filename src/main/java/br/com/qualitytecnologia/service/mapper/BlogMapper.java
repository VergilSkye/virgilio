package br.com.qualitytecnologia.service.mapper;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.domain.*;
import br.com.qualitytecnologia.service.dto.BlogDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Blog} and its DTO {@link BlogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
@GeneratedByJHipster
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {}
