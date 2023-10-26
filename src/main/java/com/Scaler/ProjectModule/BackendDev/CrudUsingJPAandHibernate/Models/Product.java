package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "jpa_product")
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

}
