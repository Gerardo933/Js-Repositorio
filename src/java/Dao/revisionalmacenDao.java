/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Revisionalmacen;
import java.util.List;

/**
 *
 * @author trank
 */
public interface revisionalmacenDao {
   public void insertarRevisionalmacen(Revisionalmacen revisionalmacen);
   public void modificarRevisionalmacen(Revisionalmacen revisionalmacen);
   public void eliminarRevisionalmacen(Revisionalmacen revisionalmacen);
   
   public List<Revisionalmacen> mostrarRevisionalmacen(); 
     public List<Empleado> mostrarEmpeados();
}
