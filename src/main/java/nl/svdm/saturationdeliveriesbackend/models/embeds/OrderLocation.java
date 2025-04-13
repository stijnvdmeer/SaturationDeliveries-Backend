package nl.svdm.saturationdeliveriesbackend.models.embeds;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderLocation {
    private String country;
    private String province;
    private String city;
    private String street;
    private String streetNumber;
    private String zipCode;
}
