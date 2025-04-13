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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    public Set<ProductLabel> getLabels() {
        return labels;
    }

    public void setLabels(Set<ProductLabel> labels) {
        this.labels = labels;
    }
    public void addLabel(ProductLabel label) {
        this.labels.add(label);
    }

    public ProductNutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(ProductNutrition nutrition) {
        this.nutrition = nutrition;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public Set<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(Set<String> warnings) {
        this.warnings = warnings;
    }

    public void addWarning(String warning) {
        this.warnings.add(warning);
    }
}
