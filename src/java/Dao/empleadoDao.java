/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Empresa;
import java.util.List;

/**
 *
 * @author trank
 */
public interface empleadoDao {
    public void insertarEmpleado(Empleado empleado);
   
   public void modificarEmpleado(Empleado empleado);
   
   public void eliminarEmpleado(Empleado empleado);
   
   public List<Empleado> mostrarEmpleado();
   public List<Empresa> mostrarEmpresas();
}
