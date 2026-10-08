package pck_consultorio;

import pck_fecha.Fecha;

public class General extends Medico {
    private static final long serialVersionUID = 1L;

    private String turno;
    private int consultorio;

    public General(){
        super();

        this.turno = null;
        this.consultorio = 0;
    }

    public General(String idEmpleado, String nombre, String direccion, String telefono, Fecha fechaNacimiento, Fecha fechaContratacion, String turno, int consultorio) {
        super(idEmpleado, nombre, direccion, telefono, fechaNacimiento, fechaContratacion);

        this.turno = turno;
        this.consultorio = consultorio;
    }

    public General(String idEmpleado, String nombre, String direccion, String telefono, int dn, int mn, int an, int dc, int mc, int ac, String turno, int consultorio) {
        super(idEmpleado, nombre, direccion, telefono, dn, mn, an, dc, mc, ac);

        this.turno = turno;
        this.consultorio = consultorio;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public String getTurno() {
        return turno;
    }

    public int getConsultorio() {
        return consultorio;
    }
}
