package nl.svdm.saturationdeliveriesbackend.services;

import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductAdminOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductDetailOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.productdtos.ProductListOutputDto;
import nl.svdm.saturationdeliveriesbackend.mappers.GenericMapper;
import nl.svdm.saturationdeliveriesbackend.models.Category;
import nl.svdm.saturationdeliveriesbackend.models.Product;
import nl.svdm.saturationdeliveriesbackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepos;
    private GenericMapper genericMapper;

    @Autowired
    public ProductService(ProductRepository productRepos, GenericMapper genericMapper) {
        this.productRepos = productRepos;
        this.genericMapper = genericMapper;
    }

    public ProductDetailOutputDto getProductDetailById(Long id) {
        Product product = this.productRepos.findById(id)
                .orElseThrow();

        return genericMapper.singleToDto(product, ProductDetailOutputDto.class);
    }

    public ProductAdminOutputDto getProductAdminById(Long id) {
        Product product = this.productRepos.findById(id)
                .orElseThrow();

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
}
