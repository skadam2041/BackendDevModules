package com.Scaler.ProjectModule.ProductCatalog.CrudUsingJPAandHibernate.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
//    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}