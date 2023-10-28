package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Services;

import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;

import java.util.List;

public interface ICategoryService {


    public List<String> getAllCategory();

    public  List<Product>  getInCategory(String categoryName);
}
