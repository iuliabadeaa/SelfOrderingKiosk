package com.selforderingkiosk.selforderingkiosk.ejb;

import com.selforderingkiosk.selforderingkiosk.common.OrderDto;
import com.selforderingkiosk.selforderingkiosk.common.OrderedProductDto;
import entities.Order;

import java.util.ArrayList;
import java.util.List;

import entities.OrderedProduct;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.logging.Logger;

@Stateless
public class OrdersBean {
    private static final Logger LOG = Logger.getLogger(OrdersBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public List<OrderDto> findAllOrders(){
        LOG.info("findAllOrders");
        try {
            TypedQuery<Order> query = em.createQuery("select o from Order o", Order.class);
            List<Order> order = query.getResultList();
            return copyOrdersToDto(order);
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }


    public void createOrder(String type, Double total, String status){
        LOG.info("createOrder");
        try {
            Order order = new Order();
            order.setType(type);
            order.setTotal(total);
            order.setStatus(status);
            em.persist(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EJBException("Error creating order", e);
        }
    }


    private List<OrderDto> copyOrdersToDto(List<Order> list){
        List<OrderDto> dtos=new ArrayList<>();
        for(Order order : list){

            OrderDto odto=new OrderDto(order.getId(), order.getType(), order.getTotal(), order.getStatus());
            dtos.add(odto);
        }
        return dtos;
    }

}
