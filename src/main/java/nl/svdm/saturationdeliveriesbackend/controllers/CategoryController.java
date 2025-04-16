package nl.svdm.saturationdeliveriesbackend.controllers;

import jakarta.validation.Valid;
import nl.svdm.saturationdeliveriesbackend.dtos.categorydtos.CategoryInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.categorydtos.CategoryOutputDto;
import nl.svdm.saturationdeliveriesbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryInputDto dto) {
        try {
            CategoryOutputDto outputDto = categoryService.createCategory(dto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + outputDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(outputDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoryOutputDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOutputDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}
