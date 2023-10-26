package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DAO;

import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
