package nl.svdm.saturationdeliveriesbackend.dtos;

import java.util.List;

public class ProductDetailOutputDto {
    public String name;
    public Double price;
    public Integer stock;
    public List<String> labels;
    public List<String> ingredients;
    public ProductNutritionDto nutrition;
    public List<String> warnings;
}
