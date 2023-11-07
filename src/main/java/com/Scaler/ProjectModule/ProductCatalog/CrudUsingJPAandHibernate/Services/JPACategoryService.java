package com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Services;


import com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.DAO.CategoryRepository;
import com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JPACategoryService implements ICategoryService {

    CategoryRepository categoryRepository;
    public JPACategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category getCategoryById(long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category addCategory(Category category) {
        Category dbCategory = categoryRepository.save(category);
        return dbCategory;
    }
    @Override
    public String deleteCategory(long id) {
        categoryRepository.deleteById(id);
        return "Category Deleted";
    }

    @Override
    public String deleteAllCategories() {
        this.categoryRepository.deleteAll();
        return "All Categories Deleted";
    }

    @Override
    public Category updateCategory(Category  category, long id) {
        categoryRepository.deleteById(id);
        Category dbCategory = categoryRepository.save(category);
        return dbCategory;
    }

}
