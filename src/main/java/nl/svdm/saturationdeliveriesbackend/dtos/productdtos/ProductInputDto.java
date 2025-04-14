package nl.svdm.saturationdeliveriesbackend.dtos.productdtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import nl.svdm.saturationdeliveriesbackend.dtos.embeddtos.NutritionInputDto;

import java.util.List;

public class ProductInputDto {
    @NotBlank(message = "name can not be empty")
    public String name;

    @NotNull(message = "price can not be empty")
    @Digits(integer = 3, fraction = 2, message = "numerical value of price is out of bounds")
    public Double price;

    @NotNull(message = "stock can not be empty")
    @PositiveOrZero(message = "stock can not be negative")
    public Integer stock;

    @NotNull(message = "pending can not be empty")
    @PositiveOrZero(message = "pending can not be negative")
    public Integer pending;


    public List<String> labels;

    @NotNull(message = "the list of ingredients can not be empty;")
    @Size(min = 1, message = "the list of ingredients has to have atleast one ingredient")
    public List<String> ingredients;

    public List<String> warnings;

    @Valid
    public NutritionInputDto nutrition;
}
