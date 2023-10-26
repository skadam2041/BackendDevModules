package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreClient;

import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;

import java.util.List;

public interface FakeStoreClient {
    public List<Product> getAllProducts();
    public Product getSingleProduct(Long productId);

    public Product addNewProduct(Product product);

    public Product updateProduct(Long productId, Product product);

    public Product deleteProduct(Long productId);

    public List<String> getAllCategory();

    public  List<Product>  getInCategory(String categoryName);
}
