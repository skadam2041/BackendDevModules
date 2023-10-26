package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long productId);

    Product addNewProduct(ProductDTO productDTO);


    Product updateProduct(Long productId, ProductDTO productDTO);

    Product deleteProduct(Long productId);

    public List<String> getAllCategory();

    public  List<Product>  getInCategory(String categoryName);

}
