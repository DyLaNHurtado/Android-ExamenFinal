package com.example.examenfinalandroid;


import com.example.examenfinalandroid.model.Empleado;

public class Intercambio {

    private static Intercambio intercambio;
    private  Intercambio(){}

    public static Intercambio getInstance(){
        if(intercambio == null)
            intercambio = new Intercambio();
        return intercambio;
    }

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
