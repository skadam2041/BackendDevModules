package com.Scaler.ProjectModule.BackendDev.HibernateInheritance.TablePerClassInheritance;


import com.Scaler.ProjectModule.BackendDev.HibernateInheritance.SuperMappedInheritance.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String company;
}