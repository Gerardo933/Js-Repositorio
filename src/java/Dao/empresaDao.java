/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empresa;
import java.util.List;

/**
 *
 * @author trank
 */
public interface empresaDao {
    public void insertarEmpresa(Empresa empresa);
   
   public void modificarDEmpresa(Empresa empresa);
   
   public void eliminarEmpresa(Empresa empresa);
   
   public List<Empresa> mostrarEmpresa();
}
