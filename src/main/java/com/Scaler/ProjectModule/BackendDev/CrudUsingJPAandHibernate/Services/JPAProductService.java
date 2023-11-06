package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DAO.ProductRepository;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    public JPAProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public JPAProductService() {

    }

    @Override
    public List<Product> getAllProducts()    {
        List<Product> products = this.productRepository.findAll();
        return products;
    }

    @Override
    public Product getSingleProduct(long productId) {
        Product product = this.productRepository.findById(productId).get();
        return product;
    }

    @Override
    public Product addNewProduct(Product product) {
        Product savedProduct = this.productRepository.save(product);
        return savedProduct;
    }



    @Override
    public Product updateProduct(Long productId, Product product) {
        this.productRepository.deleteById(productId);
        Product savedProduct = this.productRepository.save(product);
        return savedProduct;

    }

    @Override
    public String deleteProduct(long productId) {
        this.productRepository.deleteById(productId);

        return "Product Deleted Successfully";
    }







}
