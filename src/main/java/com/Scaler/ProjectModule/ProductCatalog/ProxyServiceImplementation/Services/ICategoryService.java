package com.Scaler.ProjectModule.ProductCatalog.ProxyServiceImplementation.Services;

import com.Scaler.ProjectModule.ProductCatalog.ProxyServiceImplementation.Models.Product;

import java.util.List;

public interface ICategoryService {


    public List<String> getAllCategory();

    public  List<Product>  getInCategory(String categoryName);
}
