package nl.svdm.saturationdeliveriesbackend.dtos.categorydtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryInputDto {
    @NotBlank(message = "name can not be empty")
    public String name;
}
