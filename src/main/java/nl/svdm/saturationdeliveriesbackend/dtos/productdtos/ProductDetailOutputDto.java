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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public NutritionOutputDto getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionOutputDto nutrition) {
        this.nutrition = nutrition;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }
}
