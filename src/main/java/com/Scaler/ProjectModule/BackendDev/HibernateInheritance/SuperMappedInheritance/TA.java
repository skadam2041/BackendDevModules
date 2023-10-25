package com.Scaler.ProjectModule.BackendDev.HibernateInheritance.SuperMappedInheritance;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_ta")
public class TA extends User {
    private double rating;
}