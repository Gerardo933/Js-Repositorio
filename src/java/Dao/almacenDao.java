/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Almacen;
import java.util.List;

/**
 *
 * @author trank
 */
public interface almacenDao {
   
   public void insertarAlmacen(Almacen almacen);
   public void modificarAlmacen(Almacen almacen);
   public void eliminarAlmacen(Almacen almacen);
   
   public List<Almacen> mostrarAlmacen();
}
