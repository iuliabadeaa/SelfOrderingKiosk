package com.selforderingkiosk.selforderingkiosk.ejb;

import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import entities.Product;

import java.util.ArrayList;
import java.util.Collection;
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
            TypedQuery<Product> query = entityManager.createQuery("select pr from Product pr", Product.class);
            List<Product> products = query.getResultList();
            return copyProductsToDto(products);
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }

    private List<ProductDto> copyProductsToDto(List<Product> list){
        List<ProductDto> productsDtos=new ArrayList<>();
        for(Product product : list){
            ProductDto p=new ProductDto(product.getId(),product.getName(),product.getDescription(),product.getPrice(), product.getCategory(), product.getImage());
            productsDtos.add(p);
        }
        return productsDtos;
    }

    public void deleteProductsById(Collection<Long> productIds) {
        LOG.info("deleteProductsById");
        for(Long productId : productIds){
            Product product = entityManager.find(Product.class, productId);
            entityManager.remove(product);
        }
    }


}
