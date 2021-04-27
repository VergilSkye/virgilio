package br.com.qualitytecnologia.service.mapper;

import br.com.qualitytecnologia.GeneratedByJHipster;
import br.com.qualitytecnologia.domain.*;
import br.com.qualitytecnologia.service.dto.TagDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Tag} and its DTO {@link TagDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
@GeneratedByJHipster
public interface TagMapper extends EntityMapper<TagDTO, Tag> {}
