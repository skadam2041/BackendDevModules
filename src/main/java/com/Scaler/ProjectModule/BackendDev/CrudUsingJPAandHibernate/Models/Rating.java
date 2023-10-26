package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "jpa_rating")
public  class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double rate;
    private double count;
    @OneToOne(mappedBy = "rating")
    private Product product;
}
