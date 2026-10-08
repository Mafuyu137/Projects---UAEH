package pck_consultorio;

import java.io.Serializable;
import pck_fecha.*;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    private int noConsulta;
    private String idEmpleado;
    private int noPaciente;
    private Fecha fechaConsulta;
    private String diagnostico;
    
    
    public Consulta() {
        this.noConsulta = 0;
        this.idEmpleado = null;
        this.noPaciente = 0;
        this.fechaConsulta = null;
        this.diagnostico = null;
    }

    public Consulta(int noConsulta, String idEmpleado, int noPaciente, Fecha fechaConsulta, String diagnostico) {
        this.noConsulta = noConsulta;
        this.idEmpleado = idEmpleado;
        this.noPaciente = noPaciente;
        this.fechaConsulta = fechaConsulta;
        this.diagnostico = diagnostico;
    }

    public Consulta(int noConsulta, String idEmpleado, int noPaciente, int d, int m, int a, String diagnostico) {
        this.noConsulta = noConsulta;
        this.idEmpleado = idEmpleado;
        this.noPaciente = noPaciente;
        this.fechaConsulta = new Fecha(d, m, a);
        this.diagnostico = diagnostico;
    }

    public void setNoConsulta(int noConsulta) {
        this.noConsulta = noConsulta;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNoPaciente(int noPaciente) {
        this.noPaciente = noPaciente;
    }

    public void setFechaConsulta(Fecha fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public boolean setFechaConsulta(int d, int m, int a) {
        Fecha f = new Fecha(d, m, a);

        if (f.fechaCorrecta()){
            this.fechaConsulta = f;
            return true;
        }
        else{
            return false;
        }
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getNoConsulta() {
        return noConsulta;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public int getNoPaciente() {
        return noPaciente;
    }

    public String getFechaConsulta() {
        return fechaConsulta.getFecha();
    }

    public String getDiagnostico() {
        return diagnostico;
    }
}
