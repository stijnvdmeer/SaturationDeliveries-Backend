package nl.svdm.saturationdeliveriesbackend.models;

import jakarta.persistence.*;
import nl.svdm.saturationdeliveriesbackend.models.embeds.Location;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    private String username;
    private String email;
    private String age;
    private String gender;
    private String phonenumber;

    @Embedded
    private Location location;

    //TODO Finish User Model

}
