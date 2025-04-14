package nl.svdm.saturationdeliveriesbackend.repositories;

import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.models.Product;
import nl.svdm.saturationdeliveriesbackend.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_NameIgnoreCase(String category);
    List<Product> findBySubCategory_NameIgnoreCase(String subcategory);
    List<Product> findByCategory_NameIgnoreCaseAndSubCategory_NameIgnoreCase(String category, String subcategory);
    List<Product> findByNameContainingIgnoreCase(String name);
}
