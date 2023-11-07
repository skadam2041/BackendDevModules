package com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.DAO;

import com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    @Query(name = "Select  p.Title from Product p where id = :id")
//    String[] getProductTitleById(@Param("id") Long id);

//    @Query(name = "Select  p.Title from Product p where id = ?1")
//    String[] getProductTitleById( Long id);

}
