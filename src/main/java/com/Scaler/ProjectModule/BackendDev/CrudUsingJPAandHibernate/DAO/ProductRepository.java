package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DAO;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
