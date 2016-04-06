package com.example.model;

/**
 * Created by Juan Tenorio on 5/4/2016.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Club {
    @Id
    @GeneratedValue
    private Long id;

    private String descripcion;

    public Club(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    protected Club() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
