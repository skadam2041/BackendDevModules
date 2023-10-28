package com.Scaler.ProjectModule.BackendDev.DAOTest;


import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DAO.ProductRepository;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Category;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Rating;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveProductAndCategoryAndRating() {
        Product product = new Product();
        product.setId(200l);
        product.setTitle("Samsung Galaxy S10");
        product.setPrice(50000);
        product.setImage("www.abc.com");
        product.setDescription("Samsung mobile phone");
        Rating rating = new Rating();
        rating.setId(200l);
        rating.setCount(5);
        rating.setRate(4.5);
        product.setRating(rating);
        Category category = new Category();
        category.setId(200l);
        category.setName("SmartPhone");
        product.setCategory(category);

        productRepository.save(product);

        Optional<Product> productOptional = productRepository.findById(200l);
        Product dbProduct = productOptional.get();

        System.out.println(dbProduct.getTitle());
        System.out.println(dbProduct.getCategory().getName());
        System.out.println(dbProduct.getRating().getRate());
        System.out.println("debug");





    }

}
