package nl.svdm.saturationdeliveriesbackend.dtos.embeddtos;

import jakarta.validation.constraints.Digits;

public class NutritionInputDto {
    @Digits(integer = 4, fraction = 2, message = "Numerical value of calories is out of bounds")
    public Double calories;

    @Digits(integer = 4, fraction = 2, message = "Numerical value of fats is out of bounds")
    public Double fats;

    @Digits(integer = 4, fraction = 2, message = "Numerical value of carbohydrates is out of bounds")
    public Double carbohydrates;

    @Digits(integer = 4, fraction = 2, message = "Numerical value of sugars is out of bounds")
    public Double sugars;

    @Digits(integer = 4, fraction = 2, message = "Numerical value of proteins is out of bounds")
    public Double proteins;

    @Digits(integer = 4, fraction = 2, message = "Numerical value of salts is out of bounds")
    public Double salts;
}
