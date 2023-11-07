package com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.DAO;

import com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
