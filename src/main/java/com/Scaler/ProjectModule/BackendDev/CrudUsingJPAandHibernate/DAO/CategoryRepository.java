package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DAO;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
