package gift.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    @Positive(message = "price must be positive")
    @Column(nullable = false)
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name must not be blank")
    @Size(max = 15, message = "name must be less than 15 characters")
    @Column(nullable = false, length = 15)
    private String name;

    @NotBlank(message = "image url must not be blank")
    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, int price, String imageUrl, Category category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Product(String name, int price, String imageUrl, Category category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void update(int price, String name, String imageUrl, Category category) {
        this.price = price;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public void updateId(Long id) {
        this.id = id;
    }
}
