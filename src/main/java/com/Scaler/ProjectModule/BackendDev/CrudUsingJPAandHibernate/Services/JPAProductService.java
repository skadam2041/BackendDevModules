package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAProductService implements IProductService {


    public JPAProductService() {

    }

    @Override
    public List<Product> getAllProducts()    {


        return  null;
    }

    @Override
    public Product getSingleProduct(long productId) {


        return null;
    }

    @Override
    public Product addNewProduct(ProductDTO productDTO) {
        return null;
    }



    @Override
    public Product updateProduct(Long productId, ProductDTO productDTO) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }

    @Override
    public List<String> getAllCategory() {
        return null;
    }

    @Override
    public List<Product> getInCategory(String categoryName) {
        return null;

    }





}
