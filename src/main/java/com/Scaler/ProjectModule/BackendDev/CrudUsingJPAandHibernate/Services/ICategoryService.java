package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(long id);
    String deleteCategory(long id);

    String deleteAllCategories();

    List<Category> getAllCategory();
    Category addCategory(Category category);

    Category updateCategory(Category  category, long id);




}
