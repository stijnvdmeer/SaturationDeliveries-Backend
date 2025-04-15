package nl.svdm.saturationdeliveriesbackend.services;

import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductAdminOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductDetailOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductListOutputDto;
import nl.svdm.saturationdeliveriesbackend.mappers.GenericMapper;
import nl.svdm.saturationdeliveriesbackend.mappers.ProductMapper;
import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.models.Product;
import nl.svdm.saturationdeliveriesbackend.models.SubCategory;
import nl.svdm.saturationdeliveriesbackend.models.embeds.ProductNutrition;
import nl.svdm.saturationdeliveriesbackend.models.enums.ProductLabel;
import nl.svdm.saturationdeliveriesbackend.repositories.CategoryRepository;
import nl.svdm.saturationdeliveriesbackend.repositories.ProductRepository;
import nl.svdm.saturationdeliveriesbackend.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepos;
    private final GenericMapper genericMapper;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepos, GenericMapper genericMapper, ProductMapper productMapper, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.productRepos = productRepos;
        this.genericMapper = genericMapper;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public ProductDetailOutputDto getProductDetailById(Long id) {
        Product product = this.productRepos.findById(id)
                .orElseThrow(); // TODO ResourceNotFoundException

        return genericMapper.singleToDto(product, ProductDetailOutputDto.class);
    }

    public ProductAdminOutputDto getProductAdminById(Long id) {
        Product product = this.productRepos.findById(id)
                .orElseThrow(); // TODO ResourceNotFoundException

        return genericMapper.singleToDto(product, ProductAdminOutputDto.class);
    }

    public List<ProductListOutputDto> getAllProducts() {
        List<Product> products = this.productRepos.findAll();

        return genericMapper.listToDto(products, ProductListOutputDto.class);
    }

    public List<ProductListOutputDto> getProductBy(String category, String subCategory, String name) {
        if(category != null && subCategory != null && name != null) {
            List<Product> products = this.productRepos.findByCategory_NameIgnoreCaseAndSubCategory_NameIgnoreCaseAndNameContainingIgnoreCase(category, subCategory, name);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else if(subCategory != null && category != null) {
            List<Product> products = this.productRepos.findBySubCategory_NameIgnoreCase(subCategory);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else if(subCategory != null && name != null) {
            List<Product> products = this.productRepos.findBySubCategory_NameIgnoreCaseAndNameContainingIgnoreCase(subCategory, name);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else if(category != null && name != null) {
            List<Product> products = this.productRepos.findByCategory_NameIgnoreCaseAndNameContainingIgnoreCase(category, name);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else if(category != null) {
            List<Product> products = this.productRepos.findByCategory_NameIgnoreCase(category);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else if(subCategory != null) {
            List<Product> products = this.productRepos.findBySubCategory_NameIgnoreCase(subCategory);
            return genericMapper.listToDto(products, ProductListOutputDto.class);
        } else if(name != null) {
            List<Product> products = this.productRepos.findByNameContainingIgnoreCase(name);
            return genericMapper.listToDto(products, ProductListOutputDto.class);

        } else {
            List<Product> products = this.productRepos.findAll();
            return genericMapper.listToDto(products, ProductListOutputDto.class);
        }
    }

    public ProductAdminOutputDto createProduct(ProductInputDto productInputDto) {
            Product product = productMapper.toEntity(productInputDto);

            this.productRepos.save(product);

            return genericMapper.singleToDto(product, ProductAdminOutputDto.class);
    }

    public ProductAdminOutputDto updateProduct(Long id, ProductInputDto dto) {
        Product product = productRepos.findById(id)
                .orElseThrow(); // TODO ResourceNotFoundException

        product.setName(dto.name);
        product.setPrice(dto.price);
        product.setStock(dto.stock);
        product.setPending(dto.pending != null ? dto.pending : product.getPending());
        product.setIngredients(new HashSet<>(dto.ingredients));
        product.setWarnings(dto.warnings != null ? new HashSet<>(dto.warnings) : product.getWarnings());

        if (dto.labels != null) {
            Set<ProductLabel> labels = dto.labels.stream()
                    .map(label -> ProductLabel.valueOf(label.toUpperCase()))
                    .collect(Collectors.toSet());
            product.setLabels(labels);
        } else {
            product.setLabels(product.getLabels());
        }

        Category category = categoryRepository.findById(dto.categoryId)
                .orElseThrow();
        product.setCategory(category);

        SubCategory subCategory = subCategoryRepository.findById(dto.subCategoryId)
                .orElseThrow();
        product.setSubCategory(subCategory);

        ProductNutrition nutrition = product.getNutrition();
        nutrition.setCalories(dto.nutrition.calories);
        nutrition.setFats(dto.nutrition.fats);
        nutrition.setCarbohydrates(dto.nutrition.carbohydrates);
        nutrition.setSugars(dto.nutrition.sugars);
        nutrition.setProteins(dto.nutrition.proteins);
        nutrition.setSalts(dto.nutrition.salts);
        product.setNutrition(nutrition);

        productRepos.save(product);
        return genericMapper.singleToDto(product, ProductAdminOutputDto.class);
    }

    public void deleteProduct(Long id) {
        if(!productRepos.existsById(id)) throw new RuntimeException("Product with id " + id + " does not exist"); // TODO ResourceNotFoundException
        productRepos.deleteById(id);
    }
}
