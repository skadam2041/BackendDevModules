package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "jap_category")
public class Category  extends BaseModel {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
    private List<Product> productList;
}
