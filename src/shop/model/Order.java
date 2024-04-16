package shop.model;

public class Order {
    private Long id;
    private Long userId;
    private Long productId;

    public Order(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String toList() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
