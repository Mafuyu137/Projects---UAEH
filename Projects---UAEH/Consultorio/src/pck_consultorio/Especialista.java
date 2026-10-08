package pck_consultorio;

import pck_fecha.Fecha;

public class Especialista extends Medico{
    private static final long serialVersionUID = 1L;

    private String especialidad;
    private String area;
    private String enfermera_o;

    Especialista(){
        super();

        this.especialidad = null;
        this.area = null;
        this.enfermera_o = null;
    }

    public Especialista(String idEmpleado, String nombre, String direccion, String telefono, Fecha fechaNacimiento, Fecha fechaContratacion, String especialidad, String area, String enfermera_o) {
        super(idEmpleado, nombre, direccion, telefono, fechaNacimiento, fechaContratacion);

        this.especialidad = especialidad;
        this.area = area;
        this.enfermera_o = enfermera_o;
    }

    public Especialista(String idEmpleado, String nombre, String direccion, String telefono, int dn, int mn, int an, int dc, int mc, int ac, String especialidad, String area, String enfermera_o) {
        super(idEmpleado, nombre, direccion, telefono, dn, mn, an, dc, mc, ac);
        
        this.especialidad = especialidad;
        this.area = area;
        this.enfermera_o = enfermera_o;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setEnfermera_o(String enfermera_o) {
        this.enfermera_o = enfermera_o;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getArea() {
        return area;
    }

    public String getEnfermera_o() {
        return enfermera_o;
    }
    
}
