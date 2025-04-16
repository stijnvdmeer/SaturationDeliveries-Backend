package nl.svdm.saturationdeliveriesbackend.repositories;

import nl.svdm.saturationdeliveriesbackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainingIgnoreCase(String name);
}
