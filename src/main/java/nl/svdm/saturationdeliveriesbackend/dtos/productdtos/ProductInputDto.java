package nl.svdm.saturationdeliveriesbackend.dtos.productdtos;

import jakarta.validation.Valid;
import nl.svdm.saturationdeliveriesbackend.dtos.embeddtos.NutritionInputDto;

import java.util.List;

public class ProductInputDto {
    public String name;
    public Double price;
    public Integer stock;
    public Integer pending;
    public List<String> labels;
    public List<String> ingredients;
    public List<String> warnings;

    @Valid
    public NutritionInputDto nutrition;
}
