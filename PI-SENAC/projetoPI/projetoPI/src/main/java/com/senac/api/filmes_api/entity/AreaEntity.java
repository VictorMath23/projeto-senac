
package com.senac.api.filmes_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "area")
public class AreaEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String area; 
    
    public AreaEntity() {
        // Construtor sem argumentos
    }

    public AreaEntity(long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

  

    
}
