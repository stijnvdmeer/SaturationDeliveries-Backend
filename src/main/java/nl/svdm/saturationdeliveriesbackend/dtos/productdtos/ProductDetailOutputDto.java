package nl.svdm.saturationdeliveriesbackend.dtos.productdtos;

import nl.svdm.saturationdeliveriesbackend.dtos.embeddtos.NutritionOutputDto;

import java.util.List;

public class ProductDetailOutputDto {
    public String name;
    public Double price;
    public Integer stock;
    public List<String> labels;
    public List<String> ingredients;
    public NutritionOutputDto nutrition;
    public List<String> warnings;
}
