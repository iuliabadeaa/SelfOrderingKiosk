package com.selforderingkiosk.selforderingkiosk.ejb;

import com.selforderingkiosk.selforderingkiosk.common.DiscountDto;
import com.selforderingkiosk.selforderingkiosk.common.ProductDto;
import entities.Discount;
import entities.Product;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class DiscountsBean {
    public static final Logger LOG= Logger.getLogger(DiscountsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<DiscountDto> findAllDiscounts(){
        LOG.info("Finding all discounts");
        try{
            TypedQuery<Discount> query = entityManager.createQuery("SELECT d FROM Discount d", Discount.class);
            List<Discount> discounts = query.getResultList();
            return copyDiscountsToDto(discounts);
        }catch (Exception e){
            throw new EJBException(e);
        }
    }


    private List<DiscountDto> copyDiscountsToDto(List<Discount> list){
        List<DiscountDto> discountDtos=new ArrayList<>();
        for(Discount discount : list){
            DiscountDto d=new DiscountDto(discount.getId(), discount.getCode());
            discountDtos.add(d);
        }
        return discountDtos;
    }

}
