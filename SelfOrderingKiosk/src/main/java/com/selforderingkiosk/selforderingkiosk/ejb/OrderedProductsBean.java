package com.selforderingkiosk.selforderingkiosk.ejb;

import com.selforderingkiosk.selforderingkiosk.common.OrderedProductDto;
import entities.Order;
import entities.OrderedProduct;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.logging.Logger;

@Stateless
public class OrderedProductsBean {
    private static final Logger LOG = Logger.getLogger(OrderedProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<OrderedProductDto> findAllProducts() {
        LOG.info("findAllOrderedProducts");
        try {
            TypedQuery<OrderedProduct> query = entityManager.createQuery("select p from OrderedProduct p", OrderedProduct.class);
            List<OrderedProduct> orderedProducts = query.getResultList();
            return copyOrderedProductsToDto(orderedProducts);
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }


    public void createOrderedProducts(String name, Double price, Integer quantity, Order o) {
        LOG.info("createOrderedProducts");

        try {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setName(name);
            orderedProduct.setPrice(price);
            orderedProduct.setQuantity(quantity);
            orderedProduct.setOrder(o);
            entityManager.persist(orderedProduct);

        } catch (Exception e) {
            e.printStackTrace();
            throw new EJBException("Error creating ordered product", e);
        }
    }


    private List<OrderedProductDto> copyOrderedProductsToDto(List<OrderedProduct> list){
        List<OrderedProductDto> dtos=new ArrayList<>();
        for(OrderedProduct orderedProduct : list){
            Long orderId = (orderedProduct.getOrder() != null) ? orderedProduct.getOrder().getId() : null;

            OrderedProductDto pdto=new OrderedProductDto(orderedProduct.getId(),orderedProduct.getName(),orderedProduct.getPrice(), orderId, orderedProduct.getQuantity());
            dtos.add(pdto);
        }
        return dtos;
    }


}
