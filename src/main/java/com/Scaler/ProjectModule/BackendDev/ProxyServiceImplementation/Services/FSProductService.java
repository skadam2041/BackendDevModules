package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Services;

import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreClient.FakeStoreClient;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FSProductService implements IProductService {

    FakeStoreClient fakeStoreProductClient;

    public FSProductService(FakeStoreClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public List<Product> getAllProducts()    {
        List<Product> products = fakeStoreProductClient.getAllProducts();
        //save in DB
        //convert to productDTO

        return  products;
    }

    @Override
    public Product getSingleProduct(long productId) {

        Product product = fakeStoreProductClient.getSingleProduct(productId);
        //save in DB

        return product;
    }

    @Override
    public Product addNewProduct(ProductDTO productDTO) {
        Product dbproduct = fakeStoreProductClient.addNewProduct(productDTO);
        //save in DB
        return  dbproduct;
    }



    @Override
    public Product updateProduct(Long productId, ProductDTO productDTO) {
        Product dbproduct = fakeStoreProductClient.updateProduct(productId, productDTO);
        return dbproduct;
    }

    @Override
    public Product deleteProduct(Long productId) {
        Product dbproduct = fakeStoreProductClient.deleteProduct(productId);
        return dbproduct;
    }

    @Override
    public List<String> getAllCategory() {
        List<String> categories = fakeStoreProductClient.getAllCategory();
        return  categories;
    }

    @Override
    public List<Product> getInCategory(String categoryName) {
        List<Product> products = fakeStoreProductClient.getInCategory(categoryName);

        return products;

    }





}
