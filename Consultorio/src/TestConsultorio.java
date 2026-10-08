import java.util.ArrayList;
import javax.swing.JOptionPane;
import pck_consultorio.*;
import pck_fecha.*;

public class TestConsultorio implements Actions{
    public static void main(String[] args) {
        // Arreglos dinamicos
        ArrayList <Medico> medicos = new ArrayList <>();
        ArrayList <Consulta> consultas = new ArrayList <>();
        ArrayList <Paciente> pacientes = new ArrayList <>();
        
        // Lectura de los archivos
        Actions.cargarLista("Medicos.txt", medicos);
        Actions.cargarLista("Pacientes.txt", consultas);
        Actions.cargarLista("Consultas.txt", pacientes);

        // Variables a utilizar
        String id, nombre, turno, especialidad, area, correo, direccion, telefono, enfermer, diagnostico;
        Fecha fechaNacimiento, fechaContratacion;
        int d, m, a, noConsulta, noPaciente, consultorio;

        // Funcionalidades
        String rexNumLet = "[a-zA-Z0-9]+";
        String rexLet = "[a-zA-Z]+";
        String rexNum = "[0-9]+";
        
        // Programa Principal
        int opc;
        String menu = """
                      ------- CONSULTORIO MEDICO -------
                      
                      1) Alta de un médico familiar
                      2) Alta de un médico especialista
                      3) Alta de un paciente
                      4) Alta de una consulta
                      5) Listar médicos familiares
                      6) Listar médicos especialistas
                      7) Listar pacientes
                      8) Listar consultas
                      9) Ver detalle de un médico familiar
                      10) Ver detalle de un médico especialista
                      11) Ver detalle de un paciente
                      12) Ver detalle de una consulta
                      13) Eliminar un médico familiar
                      14) Eliminar un médico especialista
                      15) Eliminar un paciente
                      16) Eliminar una consulta
                      17) Salir
                      
                      Ingrese una opcion: """;
        String copyright = """
                           Todos los derechos reservados
                           
                           Desarrolladores:
                           Eric Rene Avila Galindo
                           Quintanar Medina Marco Eduardo
                           Vazquez Vizuet Angel Alexis
                           """;
        
        do{
            opc = Actions.entradaNumerica(1, 17, menu, "Consultorio Medico", "opcion");

            switch(opc){
                case 1: {
                    do { 
                        id = Actions.checkString("Ingrese el ID:\n", "Alta de un medico familiar", rexNumLet);
                        if (Actions.hayId(medicos, id)) JOptionPane.showMessageDialog(null, "Ya existe el ID, ingrese otro", "Error al ingresar", 2);
                    } while (Actions.hayId(medicos, id));

                    nombre = Actions.checkString("Ingrese el nombre del medico: \n", "Alta de un medico familiar", rexLet);
                    direccion = Actions.checkString("Direccion: \n", "Alta de un medico familiar", rexNumLet);
                    telefono = Actions.checkString("Telefono: \n", "Alta de un medico familiar", rexNum);

                    // Para la fecha actual se utilizara el 09 / 10 / 2026
                    fechaNacimiento = Actions.fNacimiento();
                    fechaContratacion = Actions.ingresoFecha("Contratacion", "Alta de un medico");

                    turno = Actions.checkString("Ingresa el turno", "Alata de un medico", "turno");
                    consultorio = Actions.entradaNumerica(1, 7, "Ingresa el No. de consultorio", "ALta de un medico", "No. consultorio");

                    General grl = new General(id, nombre, direccion, telefono, fechaNacimiento, fechaContratacion, turno, consultorio);
                    medicos.add(grl);
                }
                
                case 2: {
                    do { 
                        id = Actions.checkString("Ingrese el ID:\n", "Alta de un medico familiar", rexNumLet);
                        if (Actions.hayId(medicos, id)) JOptionPane.showMessageDialog(null, "Ya existe el ID, ingrese otro", "Error al ingresar", 2);
                    } while (Actions.hayId(medicos, id));

                    nombre = Actions.checkString("Ingrese el nombre del medico: \n", "Alta de un medico familiar", rexLet);
                    direccion = Actions.checkString("Direccion: \n", "Alta de un medico familiar", rexNumLet);
                    telefono = Actions.checkString("Telefono: \n", "Alta de un medico familiar", rexNum);

                    // Para la fecha actual se utilizara el 09 / 10 / 2026
                    fechaNacimiento = Actions.fNacimiento();
                    fechaContratacion = Actions.ingresoFecha("Contratacion", "Alta de un medico");

                    especialidad = Actions.checkString("Ingrese la especialidad", "Alta de un medico", "especialidad");
                    area = Actions.checkString("Ingrese el area", "Alta de un medico", rexLet);
                    enfermer = Actions.checkString("Ingrese al enfermero(a)", "Alta de un medico", rexLet);
                    
                    Especialista esp = new Especialista(id, nombre, direccion, telefono, fechaNacimiento, fechaContratacion, especialidad, area, enfermer);
                    medicos.add(esp);
                }
                
                case 3: {
                    do {
                        noPaciente = Actions.checkString("Ingrese numero del paciente", "Alta de un paciente", rexNumLet);
                        if (Actions.hayPaciente(pacientes, noPaciente))  JOptionPane.showMessageDialog(null, "Ya existe el numero de paciente, ingrese otro", "Error al ingresar", 2);
                    } while(Actions.hayPaciente(pacientes, noPacientes));
                }
                
                case 4: {
                    
                }
                
                case 5: {
                    
                }
                
                case 6: {
                    
                }
                
                case 7: {
                    
                }
                
                case 8: {
                    
                }
                
                case 9: {
                    
                }
                
                case 10: {
                    
                }
                
                case 11: {
                    
                }
                
                case 12: {
                    
                }
                
                case 13: {
                    
                }
                
                case 14: {
                    
                }
                
                case 15: {
                    
                }
                
                case 16: {
                    
                }
                
                case 17: {
                    JOptionPane.showMessageDialog(null,copyright,"Copyright",1);
                }
                
                default: {
                    JOptionPane.showMessageDialog(null,"Verifique las opciones del menu","Error de entrada",2);
                }
            }
        }while(opc != 17);
        
        
        // Escritura de los archivos
        Actions.guardarLista("Medicos.txt", medicos);
        Actions.guardarLista("Pacientes.txt", pacientes);
        Actions.guardarLista("Consultas.txt", consultas);
        
    }
    // hello probando uwu
}
