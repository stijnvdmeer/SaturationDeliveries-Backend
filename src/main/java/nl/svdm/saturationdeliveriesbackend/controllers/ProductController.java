package nl.svdm.saturationdeliveriesbackend.controllers;

import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductAdminOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductDetailOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductListOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.requestdtos.SearchInputDto;
import nl.svdm.saturationdeliveriesbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
