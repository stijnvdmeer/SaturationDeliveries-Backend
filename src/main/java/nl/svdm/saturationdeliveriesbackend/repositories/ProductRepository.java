package nl.svdm.saturationdeliveriesbackend.repositories;

import nl.svdm.saturationdeliveriesbackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findBySubcategory(String subcategory);
    List<Product> findByCategoryAndSubcategory(String category, String subcategory);
    List<Product> findByNameContainingIgnoreCase(String name);
}
