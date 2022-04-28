/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Proveedor;
import java.util.List;

/**
 *
 * @author trank
 */
public interface proveedorDao {
    public void insertarProveedor(Proveedor proveedor);
   
   public void modificarProveedor(Proveedor proveedor);
   
   public void eliminarProveedor(Proveedor proveedor);
   
   public List<Proveedor> mostrarProveedor();
}
