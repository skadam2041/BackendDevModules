package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreClient;

import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;

import java.util.List;

public interface FakeStoreClient {
    public List<Product> getAllProducts();
    public Product getSingleProduct(Long productId);

    public Product addNewProduct(ProductDTO productDTO);

    public Product updateProduct(Long productId, ProductDTO productDTO);

    public Product deleteProduct(Long productId);

    public List<String> getAllCategory();

    public  List<Product>  getInCategory(String categoryName);
}
