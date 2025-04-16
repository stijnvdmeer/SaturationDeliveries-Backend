package nl.svdm.saturationdeliveriesbackend.services;

import nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos.SubCategoryInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos.SubCategoryOutputDto;
import nl.svdm.saturationdeliveriesbackend.mappers.GenericMapper;
import nl.svdm.saturationdeliveriesbackend.models.SubCategory;
import nl.svdm.saturationdeliveriesbackend.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final GenericMapper genericMapper;

    @Autowired
    public SubCategoryService(SubCategoryRepository subCategoryRepository, GenericMapper genericMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.genericMapper = genericMapper;
    }

    public SubCategoryOutputDto createSubCategory(SubCategoryInputDto subCategoryInputDto) {
        SubCategory subCategory = genericMapper.singleToEntity(subCategoryInputDto, SubCategory.class);

        subCategoryRepository.save(subCategory);

        return genericMapper.singleToDto(subCategory, SubCategoryOutputDto.class);
    }

    public List<SubCategoryOutputDto> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();

        return genericMapper.listToDto(subCategories, SubCategoryOutputDto.class);
    }

    public SubCategoryOutputDto getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(); // TODO ResourceNotFoundException

        return genericMapper.singleToDto(subCategory, SubCategoryOutputDto.class);
    }

    public List<SubCategoryOutputDto> searchSubCategoryByName(String name) {
        List<SubCategory> categories = subCategoryRepository.findByNameContainingIgnoreCase(name);
        return genericMapper.listToDto(categories, SubCategoryOutputDto.class);
    }

    public SubCategoryOutputDto updateSubCategory(SubCategoryInputDto subCategoryInputDto, Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(); //TODO ResourceNotFoundException

        subCategory.setName(subCategoryInputDto.getName());

        subCategoryRepository.save(subCategory);

        return genericMapper.singleToDto(subCategory, SubCategoryOutputDto.class);
    }

    public void deleteSubCategory(Long id) {
        if(!subCategoryRepository.existsById(id)) throw new RuntimeException(""); //TODO ResourceNotFoundException
        subCategoryRepository.deleteById(id);
    }
}
