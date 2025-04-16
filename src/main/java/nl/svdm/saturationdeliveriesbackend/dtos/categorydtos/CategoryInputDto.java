package nl.svdm.saturationdeliveriesbackend.dtos.categorydtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryInputDto {
    @NotBlank(message = "name can not be empty")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
