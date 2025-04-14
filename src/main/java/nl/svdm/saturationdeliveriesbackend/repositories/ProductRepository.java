package nl.svdm.saturationdeliveriesbackend.repositories;

import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.models.Product;
import nl.svdm.saturationdeliveriesbackend.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Name(String category);
    List<Product> findProductBySubCategory(SubCategory subcategory);
    List<Product> findProductByCategoryAndSubCategory(Category category, SubCategory subcategory);
    List<Product> findByNameContainingIgnoreCase(String name);
}
