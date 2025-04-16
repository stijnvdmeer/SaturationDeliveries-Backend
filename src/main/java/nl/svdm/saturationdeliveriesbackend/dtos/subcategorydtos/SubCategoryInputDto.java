package nl.svdm.saturationdeliveriesbackend.dtos.subcategorydtos;

import jakarta.validation.constraints.NotBlank;

public class SubCategoryInputDto {
    @NotBlank(message = "name can not be empty")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



