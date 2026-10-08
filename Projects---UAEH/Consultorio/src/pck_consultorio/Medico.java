package pck_consultorio;

import java.io.Serializable;
import pck_fecha.*;

public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String idEmpleado;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected Fecha fechaNacimiento;
    protected Fecha fechaContratacion;

    public Medico(){
        this.idEmpleado = null;
        this.nombre = null;
        this.direccion = null;
        this.telefono = null;
        this.fechaNacimiento = null;
        this.fechaContratacion = null;
    }

    public Medico(String idEmpleado, String nombre, String direccion, String telefono, Fecha fechaNacimiento, Fecha fechaContratacion) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
    }

    public Medico(String idEmpleado, String nombre, String direccion, String telefono, int dn, int mn, int an, int dc, int mc, int ac) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = new Fecha(dn, mn, an);
        this.fechaContratacion = new Fecha(dc, mc, ac);
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean setFechaNacimiento(int d, int m, int a) {
        Fecha f = new Fecha(d, m, a);

        if (f.fechaCorrecta()){
            this.fechaNacimiento = f;
            return true;
        }
        else{
            return false;
        }
    }

    public void setFechaContratacion(Fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public boolean setFechaContratacion(int d, int m, int a) {
        Fecha f = new Fecha(d, m, a);

        if (f.fechaCorrecta()){
            this.fechaContratacion = f;
            return true;
        }
        else{
            return false;
        }
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.getFecha();
    }

    public String getFechaContratacion() {
        return fechaContratacion.getFecha();
    }
}
