package nl.svdm.saturationdeliveriesbackend.controllers;

import jakarta.validation.Valid;
import nl.svdm.saturationdeliveriesbackend.dtos.requestdtos.StringInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos.SubCategoryInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos.SubCategoryOutputDto;
import nl.svdm.saturationdeliveriesbackend.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(final SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping
    public ResponseEntity<?> createSubCategory(@Valid @RequestBody SubCategoryInputDto dto) {
        try {
            SubCategoryOutputDto outputDto = subCategoryService.createSubCategory(dto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + outputDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(outputDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<SubCategoryOutputDto>> getAllSubCategories() {
        return ResponseEntity.ok(subCategoryService.getAllSubCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryOutputDto> getSubCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(subCategoryService.getSubCategoryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SubCategoryOutputDto>> searchSubCategory(@RequestBody StringInputDto inputDto) {
        return ResponseEntity.ok(subCategoryService.searchSubCategoryByName(inputDto.name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryOutputDto> updateSubCategory(@PathVariable Long id, @Valid @RequestBody SubCategoryInputDto dto) {
        return ResponseEntity.ok(subCategoryService.updateSubCategory(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
        subCategoryService.deleteSubCategory(id);
        return ResponseEntity.noContent().build();
    }
}
