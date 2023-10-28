package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Services;


import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreClient.FakeStoreClient;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FSCategoryService implements ICategoryService {
    @Autowired
    private FakeStoreClient fakeStoreCategoryClient;

    @Override
    public List<String> getAllCategory() {
        List<String> categories = fakeStoreCategoryClient.getAllCategory();
        return  categories;
    }

    @Override
    public List<Product> getInCategory(String categoryName) {
        List<Product> products = fakeStoreCategoryClient.getInCategory(categoryName);

        return products;

    }
}
