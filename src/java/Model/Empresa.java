package Model;
// Generated 7/12/2020 11:16:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private Integer idEmp;
     private String nombre;
     private String direccion;
     private String responsable;
     private Long telefono;
     private Set<Empleado> empleados = new HashSet<Empleado>(0);

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String responsable, Long telefono, Set<Empleado> empleados) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.responsable = responsable;
       this.telefono = telefono;
       this.empleados = empleados;
    }
   
    public Integer getIdEmp() {
        return this.idEmp;
    }
    
    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getResponsable() {
        return this.responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public Long getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


