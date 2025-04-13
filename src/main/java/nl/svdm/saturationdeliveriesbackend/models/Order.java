package nl.svdm.saturationdeliveriesbackend.models;

import jakarta.persistence.*;
import nl.svdm.saturationdeliveriesbackend.models.embeds.Location;
import nl.svdm.saturationdeliveriesbackend.models.enums.OrderStatus;

import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @ManyToOne
    private User user;

    private Date created;
    private Date deliveryDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Embedded
    private Location location;

}
