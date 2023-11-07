package com.Scaler.ProjectModule.ProductCatalog.HibernateInheritance.TablePerClassInheritance;


import com.Scaler.ProjectModule.ProductCatalog.HibernateInheritance.SuperMappedInheritance.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String company;
}