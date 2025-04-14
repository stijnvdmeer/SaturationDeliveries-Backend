package nl.svdm.saturationdeliveriesbackend.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericMapper {

    private final ModelMapper mapper;

    @Autowired
    public GenericMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <D, T> D singleToDto(T entity, Class<D> dto) {
        return mapper.map(entity, dto);
    }

    public <D, T> T singleToEntity(D dto, Class<T> entity) {
        return mapper.map(dto, entity);
    }

    public <D, T> List<D> listToDto(List<T> entities, Class<D> dto) {
        return entities.stream()
                .map(entity -> mapper.map(entity, dto))
                .collect(Collectors.toList());
    }

    public <D, T> List<T> listToEntity(List<D> dtos, Class<T> entity) {
        return dtos.stream()
                .map(dto -> mapper.map(dto, entity))
                .collect(Collectors.toList());
    }


}
