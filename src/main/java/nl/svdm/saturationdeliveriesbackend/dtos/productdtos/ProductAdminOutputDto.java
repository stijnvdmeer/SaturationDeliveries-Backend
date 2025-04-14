package nl.svdm.saturationdeliveriesbackend.dtos.productdtos;

import nl.svdm.saturationdeliveriesbackend.dtos.categorydtos.CategoryOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.embeddtos.NutritionOutputDto;
import nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos.SubCategoryOutputDto;

import java.util.List;

public class ProductAdminOutputDto {
    public Long id;
    public String name;
    public Double price;
    public Integer stock;
    public Integer pending;
    public List<String> labels;
    public List<String> ingredients;
    public List<String> warnings;
    public NutritionOutputDto nutrition;
    public CategoryOutputDto category;
    public SubCategoryOutputDto subCategory;

}
