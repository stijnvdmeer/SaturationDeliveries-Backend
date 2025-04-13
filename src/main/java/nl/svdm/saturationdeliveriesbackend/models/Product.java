package nl.svdm.saturationdeliveriesbackend.models;

import jakarta.persistence.*;
import nl.svdm.saturationdeliveriesbackend.models.embeds.ProductNutrition;
import nl.svdm.saturationdeliveriesbackend.models.enums.ProductLabel;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    private String name;
    private Double price;
    private Integer stock;
    private Integer pending;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<ProductLabel> labels;

    @Embedded
    private ProductNutrition nutrition;

    @ElementCollection
    @CollectionTable(name = "product_ingredients", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "ingredient")
    private Set<String> ingredients;

    @ElementCollection
    @CollectionTable(name = "product_warnings", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "warning")
    private Set<String> warnings;

    public Product() {}
}
