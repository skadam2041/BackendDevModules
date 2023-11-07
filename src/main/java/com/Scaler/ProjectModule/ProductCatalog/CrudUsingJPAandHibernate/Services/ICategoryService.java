package com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Models.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(long id);
    String deleteCategory(long id);

    String deleteAllCategories();

    List<Category> getAllCategory();
    Category addCategory(Category category);

    Category updateCategory(Category  category, long id);




}
