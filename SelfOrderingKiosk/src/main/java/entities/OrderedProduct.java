
package entities;

import jakarta.persistence.*;

@Entity
@Table(name="ordered_product")
public class OrderedProduct {
    @GeneratedValue
    @Id
    private Long id;

    String name;
    Double price;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    Order order;

    public OrderedProduct() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
