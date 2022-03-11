package com.example.examenfinalandroid.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.examenfinalandroid.model.Empleado;

import java.util.List;
@Dao
public interface EmpleadoDao {
    @Insert
    void insertEmpleado(Empleado empleado);

    @Query("select * from empleado")
    List<Empleado> getAllEmpleados();

    @Query("select * from empleado where id=:id")
    List<Empleado> selectById(Integer id);

    @Query("select * from empleado where departamento=:departamento")
    List<Empleado> selectByDepartamento(String departamento);

    @Query("delete from empleado where id = :id")
    void deleteEmpleadoById(Integer id);
    @Update
    void updateEmpleado(Empleado empleado);
}
