package nl.svdm.saturationdeliveriesbackend.mappers;

import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductInputDto;
import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.models.Product;
import nl.svdm.saturationdeliveriesbackend.models.SubCategory;
import nl.svdm.saturationdeliveriesbackend.models.embeds.ProductNutrition;
import nl.svdm.saturationdeliveriesbackend.models.enums.ProductLabel;
import nl.svdm.saturationdeliveriesbackend.repositories.CategoryRepository;
import nl.svdm.saturationdeliveriesbackend.repositories.SubCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public ProductMapper(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public Product toEntity(ProductInputDto dto) {
        Product product = new Product();
        product.setName(dto.name);
        product.setPrice(dto.price);
        product.setStock(dto.stock);
        product.setStock(dto.pending);

        Category category = categoryRepository.findById(dto.categoryId)
                .orElseThrow();
        product.setCategory(category);

        SubCategory subCategory = subCategoryRepository.findById(dto.subCategoryId)
                .orElseThrow();
        product.setSubCategory(subCategory);

        product.setIngredients(new HashSet<>(dto.ingredients));

        if(dto.warnings != null) {
            product.setWarnings(new HashSet<>(dto.warnings));
        }


        if(dto.labels != null) {
            Set<ProductLabel> LabelEnums = dto.labels.stream()
                    .map(label -> ProductLabel.valueOf(label.toUpperCase()))
                    .collect(Collectors.toSet());
            product.setLabels(LabelEnums);
        }

        ProductNutrition nutrition = new ProductNutrition();
        nutrition.setCalories(dto.nutrition.calories);
        nutrition.setFats(dto.nutrition.fats);
        nutrition.setCarbohydrates(dto.nutrition.carbohydrates);
        nutrition.setSugars(dto.nutrition.sugars);
        nutrition.setProteins(dto.nutrition.proteins);
        nutrition.setSalts(dto.nutrition.salts);
        product.setNutrition(nutrition);

        return product;
    }
}
