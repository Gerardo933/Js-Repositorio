/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Empresa;
import Model.Entrada;
import java.util.List;

/**
 *
 * @author trank
 */
public interface entradaDao {
    public void insertarEntrada(Entrada entrada);
   public void modificarEntrada(Entrada entrada);
   public void eliminarEntrada(Entrada entrada);
   
   public List<Entrada> mostrarEntrada();
   public List<Empleado> mostrarEmpeados();
}
