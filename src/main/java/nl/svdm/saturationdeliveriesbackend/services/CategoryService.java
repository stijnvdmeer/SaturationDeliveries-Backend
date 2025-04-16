package nl.svdm.saturationdeliveriesbackend.services;

import nl.svdm.saturationdeliveriesbackend.dtos.categorydtos.CategoryInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.categorydtos.CategoryOutputDto;
import nl.svdm.saturationdeliveriesbackend.mappers.GenericMapper;
import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final GenericMapper genericMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, GenericMapper genericMapper) {
        this.categoryRepository = categoryRepository;
        this.genericMapper = genericMapper;
    }

    public CategoryOutputDto createCategory(CategoryInputDto categoryInputDto) {
        Category category = genericMapper.singleToEntity(categoryInputDto, Category.class);

        categoryRepository.save(category);

        return genericMapper.singleToDto(category, CategoryOutputDto.class);
    }

    public List<CategoryOutputDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return genericMapper.listToDto(categories, CategoryOutputDto.class);
    }

    public CategoryOutputDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(); // TODO ResourceNotFoundException

        return genericMapper.singleToDto(category, CategoryOutputDto.class);
     }
}
