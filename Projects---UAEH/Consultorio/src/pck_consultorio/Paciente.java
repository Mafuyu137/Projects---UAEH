package pck_consultorio;

import java.io.Serializable;
import pck_fecha.*;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    private int noPaciente;
    private String nombre;
    private String direccion;
    private String telefono;
    private Fecha fechaNacimiento;
    private String correo;

    Paciente(){
        this.noPaciente = 0;
        this.nombre = null;
        this.direccion = null;
        this.telefono = null;
        this.fechaNacimiento = null;
        this.correo = null;
    }

    public Paciente(int noPaciente, String nombre, String direccion, String telefono, Fecha fechaNacimiento, String correo) {
        this.noPaciente = noPaciente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    public Paciente(int noPaciente, String nombre, String direccion, String telefono, int d, int m, int a, String correo) {
        this.noPaciente = noPaciente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = new Fecha(d, m, a);
        this.correo = correo;
    }

    public void setNoPaciente(int noPaciente) {
        this.noPaciente = noPaciente;
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
            this.fechaNacimiento = new Fecha(d, m, a);
            return true;
        }
        else{
            return false;
        }
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNoPaciente() {
        return noPaciente;
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

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

}
