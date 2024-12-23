package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @GeneratedValue
    @Id
    private Long id;
    private String type;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderedProduct> products=new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrderedProducts(List<OrderedProduct> products) {
        this.products = products;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }


}
