package Model;
// Generated 7/12/2020 11:16:12 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Revisionalmacen generated by hbm2java
 */
public class Revisionalmacen  implements java.io.Serializable {


     private Integer idRevision;
     private Empleado empleado;
     private Date hora;
     private String observacion;

    public Revisionalmacen() {
        empleado = new Empleado();
    }

    public Revisionalmacen(Empleado empleado, Date hora, String observacion) {
       this.empleado = empleado;
       this.hora = hora;
       this.observacion = observacion;
    }
   
    public Integer getIdRevision() {
        return this.idRevision;
    }
    
    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }




}

