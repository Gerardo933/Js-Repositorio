/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Producto;
import Model.Proveedor;
import java.util.List;

/**
 *
 * @author trank
 */
public interface productoDao {
    public void insertarProducto(Producto producto);
   
   public void modificarProducto(Producto producto);
   
   public void eliminarProducto(Producto producto);
   
   public List<Producto> mostrarProducto();
   public List<Proveedor> mostrarProveedores();
}
