package shop.model;

public class Product {
    private Long id;
    private Long ownerId;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {
    }

    public Product(Long ownerId, String name, Double price) {
        this.ownerId = ownerId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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
}
