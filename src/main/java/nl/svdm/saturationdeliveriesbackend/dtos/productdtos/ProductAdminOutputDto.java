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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
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

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public NutritionOutputDto getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionOutputDto nutrition) {
        this.nutrition = nutrition;
    }

    public CategoryOutputDto getCategory() {
        return category;
    }

    public void setCategory(CategoryOutputDto category) {
        this.category = category;
    }

    public SubCategoryOutputDto getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryOutputDto subCategory) {
        this.subCategory = subCategory;
    }
}
