/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Producto;
import Model.Proveedor;
import Model.Recibeproducto;
import java.util.List;

/**
 *
 * @author trank
 */
public interface recibeproductoDao {
    public void insertarRecibeproducto(Recibeproducto recibeproducto);
   public void modificarRecibeprducto(Recibeproducto recibeproducto);
   public void eliminarRecibeproducto(Recibeproducto recibeproducto);
   
   public List<Recibeproducto> mostrarRecibeproducto();
   public List<Proveedor> mostrarProveedores();
   public List<Producto> mostrarProductos(Recibeproducto recibeproducto);
}
