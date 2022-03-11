package com.example.examenfinalandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "empleado")
public class Empleado {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String image;
    private String departamento;
    private String lugarTrabajo;

    public Empleado(String name, String image, String departamento, String lugarTrabajo) {
        this.name = name;
        this.image = image;
        this.departamento = departamento;
        this.lugarTrabajo = lugarTrabajo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }
}
