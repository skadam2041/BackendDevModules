package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long productId);

    Product addNewProduct(Product product);


    Product updateProduct(Long productId, Product product);

    String deleteProduct(long productId);



}
