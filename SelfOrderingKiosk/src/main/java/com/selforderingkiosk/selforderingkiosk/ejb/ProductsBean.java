package com.selforderingkiosk.selforderingkiosk.ejb;

import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.logging.Logger;

@Stateless
public class ProductsBean {
    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<ProductDto> findAllProducts() {
        LOG.info("findAllProducts");
        try {
            TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
            List<Product> products = query.getResultList();
            return copyProductsToDto(products);
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }

    private List<ProductDto> copyProductsToDto(List<Product> list){
        List<ProductDto> dtos=new ArrayList<>();
        for(Product product : list){
            Long o_id = 0L;
            if (product.getOrder() != null) {
                o_id = product.getOrder().getId();
            }
            ProductDto p=new ProductDto(product.getId(),product.getName(),product.getDescription(),product.getPrice(),o_id);
            dtos.add(p);
        }
        return dtos;
    }


}
