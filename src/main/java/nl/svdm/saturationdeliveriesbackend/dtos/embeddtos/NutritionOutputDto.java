package nl.svdm.saturationdeliveriesbackend.dtos.embeddtos;

public class NutritionOutputDto {
    public Double calories;
    public Double fats;
    public Double carbohydrates;
    public Double sugars;
    public Double proteins;
    public Double salts;

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getSugars() {
        return sugars;
    }

    public void setSugars(Double sugars) {
        this.sugars = sugars;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getSalts() {
        return salts;
    }

    public void setSalts(Double salts) {
        this.salts = salts;
    }
}
