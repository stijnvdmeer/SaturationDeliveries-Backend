package nl.svdm.saturationdeliveriesbackend.controllers;

import jakarta.validation.Valid;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductAdminOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductDetailOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductInputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductListOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.requestdtos.SearchInputDto;
import nl.svdm.saturationdeliveriesbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailOutputDto> getProductDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductDetailById(id));
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<ProductAdminOutputDto> getProductAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductAdminById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductListOutputDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductListOutputDto>> getProductBy(@RequestBody SearchInputDto dto) {
        return ResponseEntity.ok(productService.getProductBy(dto.category, dto.subcategory, dto.name));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductInputDto dto) {
        try {
            ProductAdminOutputDto outputDto = productService.createProduct(dto);
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + outputDto.getId()).toUriString());

                return ResponseEntity.created(uri).body(outputDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductInputDto dto, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

