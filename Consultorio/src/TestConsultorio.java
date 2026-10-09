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
        Actions.cargarLista("Pacientes.txt", pacientes);
        Actions.cargarLista("Consultas.txt", consultas);

        // Variables a utilizar
        String id, nombre, turno, especialidad, area, correo, direccion, telefono, enfermer, diagnostico;
        Fecha fechaNacimiento, fechaContratacion, fechaConsulta;
        int noConsulta, noPaciente, consultorio, aBorrar, cnfrm;

        // Funcionalidades
        String rexNumLet = "[a-zA-Z0-9]+";
        String rexLet = "[a-zA-Z\s]+";
        String rexNum = "[0-9]+";
        String rexCorreo = "[a-zA-Z0-9@.]+";
        String rexNumLetEsp = "[a-zA-Z0-9\s]+";
        
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
                        if (Actions.hayId(medicos, id) != -1) JOptionPane.showMessageDialog(null, "Ya existe el ID, ingrese otro", "Error al ingresar", 2);
                    } while (Actions.hayId(medicos, id) != -1);

                    nombre = Actions.checkString("Ingrese el nombre del medico: \n", "Alta de un medico familiar", rexLet);
                    direccion = Actions.checkString("Direccion: \n", "Alta de un medico familiar", rexNumLetEsp);
                    telefono = Actions.checkString("Telefono: \n", "Alta de un medico familiar", rexNum);

                    // Para la fecha actual se utilizara el 09 / 10 / 2026
                    fechaNacimiento = Actions.fNacimiento();
                    fechaContratacion = Actions.ingresoFecha("Alta de un medico", "Contratacion");

                    turno = Actions.checkString("Ingresa el turno", "Alta de un medico", rexLet);
                    consultorio = Actions.entradaNumerica(1, 7, "Ingresa el No. de consultorio", "Alta de un medico", "No. consultorio");

                    General grl = new General(id, nombre, direccion, telefono, fechaNacimiento, fechaContratacion, turno, consultorio);
                    medicos.add(grl);

                    break;
                }
                
                case 2: {
                    do { 
                        id = Actions.checkString("Ingrese el ID:\n", "Alta de un medico familiar", rexNumLet);
                        if (Actions.hayId(medicos, id) != -1) JOptionPane.showMessageDialog(null, "Ya existe el ID, ingrese otro", "Error al ingresar", 2);
                    } while (Actions.hayId(medicos, id) != -1);

                    nombre = Actions.checkString("Ingrese el nombre del medico: \n", "Alta de un medico familiar", rexLet);
                    direccion = Actions.checkString("Direccion: \n", "Alta de un medico familiar", rexNumLetEsp);
                    telefono = Actions.checkString("Telefono: \n", "Alta de un medico familiar", rexNum);

                    // Para la fecha actual se utilizara el 09 / 10 / 2026
                    fechaNacimiento = Actions.fNacimiento();
                    fechaContratacion = Actions.ingresoFecha("Contratacion", "Alta de un medico");

                    especialidad = Actions.checkString("Ingrese la especialidad", "Alta de un medico", rexLet);
                    area = Actions.checkString("Ingrese el area", "Alta de un medico", rexLet);
                    enfermer = Actions.checkString("Ingrese al enfermero(a)", "Alta de un medico", rexLet);
                    
                    Especialista esp = new Especialista(id, nombre, direccion, telefono, fechaNacimiento, fechaContratacion, especialidad, area, enfermer);
                    medicos.add(esp);

                    break;
                }
                
                case 3: {
                    do {
                        noPaciente = Actions.entradaNumerica(0,1000,"Ingrese numero del paciente", "Alta de un paciente", rexNum);
                        if (Actions.hayPaciente(pacientes, noPaciente) != -1)  JOptionPane.showMessageDialog(null, "Ya existe el numero de paciente, ingrese otro", "Error al ingresar", 2);
                    } while(Actions.hayPaciente(pacientes, noPaciente) != -1);
                    
                    nombre = Actions.checkString("Ingrese el nombre del paciente: \n", "Alta de un pacienter", rexLet);
                    direccion = Actions.checkString("Direccion: \n", "Alta de un paciente", rexNumLetEsp);
                    telefono = Actions.checkString("Telefono: \n", "Alta de un paciente", rexNum);

                    // Para la fecha actual se utilizara el 09 / 10 / 2026
                    fechaNacimiento = Actions.fNacimiento();
                    
                    correo = Actions.checkString("Correo: \n", "Alta de un paciente", rexCorreo);

                    Paciente pcnt = new Paciente (noPaciente,nombre,direccion,telefono,fechaNacimiento,correo);
                    pacientes.add(pcnt);

                    break;
                }
                
                case 4: {
                    //Comprobar que existan medicos
                    if (medicos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay medicos para asignar una consulta","Error de registro de consulta",2);
                        break;
                    }

                    //Comprobar que existan pacientes
                    if (pacientes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados","Error de registro de consulta",2);
                        break;
                    }

                    //No repetir numeros de consulta
                    do {
                        noConsulta = Actions.entradaNumerica(1, 1000,"Ingrese el número de la consulta","Alta de una consulta","número de consulta");
                        if (Actions.hayConsulta(consultas, noConsulta) != -1) JOptionPane.showMessageDialog(null, "Ese número de consulta ya existe.");
                    } while (Actions.hayConsulta(consultas, noConsulta) != -1);

                    //Verificar el id del medico
                    id = Actions.checkString("Ingrese el ID del médico","Alta de una consulta",rexNumLet);
                    if (Actions.hayId(medicos, id) == -1) {
                        JOptionPane.showMessageDialog(null, "No existe un médico con ese ID","Error de registro de consulta",2);
                        break;
                    }

                    //Verificar el numero de paciente
                    noPaciente = Actions.entradaNumerica(1, 1000,"Ingrese el número del paciente","Alta de una consulta","número de paciente");
                    if (Actions.hayPaciente(pacientes, noPaciente) == -1) {
                        JOptionPane.showMessageDialog(null, "No existe un paciente con ese número","Error de registro de consulta",2);
                        break;
                    }
                    
                    
                    //Validar fecha de consulta
                    fechaConsulta = Actions.ingresoFecha("Fecha de consulta: ", "consulta");
                    diagnostico = Actions.checkString("Diagnostico: ", "Alta de una consulta", rexLet);

                    Consulta cnslta = new Consulta (noConsulta,id,noPaciente,fechaConsulta,diagnostico);
                    consultas.add(cnslta);

                    break;
                }
                
                case 5: {
                    String arriba = """
                                    IdEmpleado      Nombre     Direccion     Telefono     F. Nacimiento   F. Contratacion     Turno     Consultorio   
                                    _______________________________________________________________________________________________________________
                                    
                                    """;
                    String lista = "";
                    int cnt = 0;

                    for (int i = 0; i < medicos.size(); i++){
                        Medico check = medicos.get(i);

                        if (check instanceof General){
                            lista += check.getDatosTab();
                            cnt++;
                        }
                    }

                    if (cnt != 0) JOptionPane.showMessageDialog(null, arriba + lista, "Lista de medicos familiares", 3);
                    else JOptionPane.showMessageDialog(null, "No hay medicos guardados", "Lista de medicos familiares", 3);
                    
                    break;
                }
                
                case 6: {
                    String arriba = """
                                    IdEmpleado      Nombre     Direccion     Telefono     F. Nacimiento   F. Contratacion     Especialidad     Area      Enfermera(o)
                        		    _________________________________________________________________________________________________________________________________

                                    """;
                    String lista = "";
                            
                            
                    int cnt = 0;

                    for (int i = 0; i < medicos.size(); i++){
                        Medico check = medicos.get(i);

                        if (check instanceof Especialista){
                            lista += check.getDatosTab();
                            cnt++;
                        }
                    }

                    if (cnt != 0) JOptionPane.showMessageDialog(null, arriba + lista, "Lista de medicos especialistas", 3);
                    else JOptionPane.showMessageDialog(null, "No hay medicos guardados", "Lista de medicos especialistas", 3);
                    
                    break;
                }
                
                case 7: {
                    String arriba = """
                                    No.Paciente      Nombre      Direccion      Telefono      F. Nacimiento      Correo 
                                    ____________________________________________________________________________________________________
                                    
                                    """;
                    String lista = "";

                    for (Paciente paciente : pacientes){
                         lista += paciente.getDatosTab();
                    }

                    //Comprobar que existen pacientes
                    if (!pacientes.isEmpty()) JOptionPane.showMessageDialog(null, arriba + lista, "Lista de pacientes", 1);
                    else JOptionPane.showMessageDialog(null, "No hay pacientes guardados", "Lista de ", 2);
                    
                    break;
                }
                
                case 8: {
                    String arriba = """
                                    No. Consulta      Id Empleado      No.Paciente      F. Consulta      Diagnostico   
                                    _____________________________________________________________________________________
                                    
                                    """;
                    String lista = "";

                    for (Consulta consulta : consultas){
                         lista += consulta.getDatosTab();
                    }

                    //Comprobar que existen consultas
                    if (!consultas.isEmpty()) JOptionPane.showMessageDialog(null, arriba + lista, "Lista de consultas", 1);
                    else JOptionPane.showMessageDialog(null, "No hay consultas registradas", "Lista de consultas", 2);
                    
                    break;
                }
                
                case 9: {
                    id = Actions.checkString("Ingrese el ID del medico a consultar", "Consultar un medico", rexNumLet);

                    int i = Actions.hayId(medicos, id);
                    if (i != -1){
                        if (medicos.get(i) instanceof General) JOptionPane.showMessageDialog(null, medicos.get(i).getDatos(), "Consultar un medico", 3);
                        else JOptionPane.showMessageDialog(null, "No hay un medico general registrado con ese ID", "Consultar un medico", 2);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No hay un medico general registrado con ese ID", "Consultar un medico", 2);
                    }

                    break;
                }
                
                case 10: {
                    id = Actions.checkString("Ingrese el ID del medico a consultar", "Consultar un medico", rexNumLet);

                    int i = Actions.hayId(medicos, id);
                    if (i != -1){
                        if (medicos.get(i) instanceof Especialista) JOptionPane.showMessageDialog(null, medicos.get(i).getDatos(), "Consultar un medico", 3);
                        else JOptionPane.showMessageDialog(null, "No hay un medico especialista registrado con ese ID", "Consultar un medico", 2);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No hay un medico especialista registrado con ese ID", "Consultar un medico", 2);
                    }

                    break;
                }
                
                case 11: {
                    if (pacientes.isEmpty()) { 
                        JOptionPane.showMessageDialog(null,"No hay pacientes registrados","Consultar paciente",2); 
                        break; 
                    }
                    noPaciente = Actions.entradaNumerica(0,1000,"Ingrese el numero del paciente: ","Consultar paciente","numero de paciente");
                    int i = Actions.hayPaciente(pacientes, noPaciente); 
                    if (i != -1) {  
                        JOptionPane.showMessageDialog(null,pacientes.get(i).getDatos(),"Detalle del paciente",1); 
                    } else { 
                        JOptionPane.showMessageDialog(null,"No existe un paciente con ese numero", "Paciente no encontrado", 2); 
                    }
                    break;
                }
            
                case 12: {
                    // Verificar que existan consultas registradas
                    if (consultas.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"No hay consultas registradas.","Consultar consulta",2);
                        break;
                    }
                
                    noConsulta = Actions.entradaNumerica(1, 1000,"Ingrese el numero de la consulta:","Consultar consulta","numero de consulta");
                    int i = Actions.hayConsulta(consultas, noConsulta);               
                    if (i != -1) {
                        Consulta consulta = consultas.get(i);
                
                        // Buscar medico y paciente relacionados con la consulta
                        int indiceMedico = Actions.hayId(medicos,consulta.getIdEmpleado());
                        int indicePaciente = Actions.hayPaciente(pacientes,consulta.getNoPaciente());
                
                        if (indiceMedico != -1 && indicePaciente != -1) {
                            Medico medico = medicos.get(indiceMedico);
                            Paciente paciente = pacientes.get(indicePaciente);
                
                            String tipoMedico;
                
                            if (medico instanceof Especialista) {
                                tipoMedico = "MÉDICO ESPECIALISTA";
                            } else {
                                tipoMedico = "MÉDICO FAMILIAR";
                            }
                
                            String detalle =
                                "DETALLE DE UNA CONSULTA\n" 
                                + "No. Consulta: " 
                                + consulta.getNoConsulta() 
                                + "\n\n" 
                                + tipoMedico + "\n" 
                                + medico.getDatos() + "\n\n" 
                                + "PACIENTE\n" 
                                + paciente.getDatos() + "\n\n" 
                                + "Fecha de consulta: "
                                + consulta.getFechaConsulta() + "\n"
                                + "Diagnóstico: "
                                + consulta.getDiagnostico();
                
                            JOptionPane.showMessageDialog(null,detalle,"Detalle de la consulta",1);
                
                        } else {
                            JOptionPane.showMessageDialog(null,"No se pudo mostrar el detalle porque no se encontró el médico o el paciente relacionado con la consulta","Error de integridad",0);
                        }
                
                    } else {
                        JOptionPane.showMessageDialog(null,"No existe una consulta con ese numero","Consulta no encontrada",0);
                    }
                
                    break;
                }
                
                case 13: {
                    if(medicos.isEmpty())
                        JOptionPane.showMessageDialog(null,"Aun no hay medicos dados de alta","Eliminar un medico familiar",1);
                    else{
                        id = Actions.checkString("Ingrese el ID:\n", "Eliminar un medico familiar", rexNumLet);
                        aBorrar = Actions.hayId(medicos, id, "general");
                        if(aBorrar == -2)
                            JOptionPane.showMessageDialog(null,"El ID ingresado no corresponde a un medico familiar","Eliminar un medico familiar",1);
                        else if(aBorrar == -1)
                            JOptionPane.showMessageDialog(null,"No existe un medico registrado con el ID ingresado","Eliminar un medico familiar",1);
                        else{
                            cnfrm = JOptionPane.showConfirmDialog(null, medicos.get(aBorrar).getDatos() + "\n\n¿Esta seguro de eliminar este medico?",
                                    "Eliminar un medico familiar",JOptionPane.YES_NO_OPTION,2);
                            if (cnfrm == JOptionPane.YES_OPTION){
                                ArrayList <Integer> auxList = Actions.listaConsultas(consultas, id);
                                for(int n : auxList) consultas.remove(n);
                                medicos.remove(aBorrar);
                                JOptionPane.showMessageDialog(null,"Medico eliminado con exito","Eliminar un medico familiar",1);
                            }
                        }
                    }

                    break;
                }
                
                case 14: {
                    if(medicos.isEmpty())
                        JOptionPane.showMessageDialog(null,"Aun no hay medicos dados de alta","Eliminar un medico especialista",1);
                    else{
                        id = Actions.checkString("Ingrese el ID:\n", "Eliminar un medico especialista", rexNumLet);
                        aBorrar = Actions.hayId(medicos, id, "especialista");
                        if(aBorrar == -2)
                            JOptionPane.showMessageDialog(null,"El ID ingresado no corresponde a un medico especialista","Eliminar un medico especialista",1);
                        else if(aBorrar == -1)
                            JOptionPane.showMessageDialog(null,"No existe un medico registrado con el ID ingresado","Eliminar un medico especialista",1);
                        else{
                            cnfrm = JOptionPane.showConfirmDialog(null, medicos.get(aBorrar).getDatos() + "\n\n¿Esta seguro de eliminar este medico?",
                                    "Eliminar un medico especialista",JOptionPane.YES_NO_OPTION,2);
                            if (cnfrm == JOptionPane.YES_OPTION){
                                ArrayList <Integer> auxList = Actions.listaConsultas(consultas, id);
                                for(int n : auxList) consultas.remove(n);
                                medicos.remove(aBorrar);
                                JOptionPane.showMessageDialog(null,"Medico eliminado con exito","Eliminar un medico familiar",1);
                            }
                        }
                    }

                    break;
                }
                
                case 15: {
                    if(pacientes.isEmpty())
                        JOptionPane.showMessageDialog(null,"Aun no hay pacientes dados de alta","Eliminar un paciente",1);
                    else{
                        noPaciente = Actions.entradaNumerica(0,1000,"Ingrese numero del paciente", "Eliminar un paciente", rexNumLet);
                        aBorrar = Actions.hayPaciente(pacientes, noPaciente);
                        if (aBorrar == -1)
                            JOptionPane.showMessageDialog(null,"No se encontro una paciente con el numero ingresado","Eliminar un paciente",1);
                        else{
                            cnfrm = JOptionPane.showConfirmDialog(null, pacientes.get(aBorrar).getDatos() + "\n\n¿Esta seguro de eliminar este paciente?",
                                    "Eliminar un paciente",JOptionPane.YES_NO_OPTION,2);
                            if (cnfrm == JOptionPane.YES_OPTION){
                                ArrayList <Integer> auxList = Actions.listaConsultas(consultas, noPaciente);
                                for(int n : auxList) consultas.remove(n);
                                pacientes.remove(aBorrar);
                                JOptionPane.showMessageDialog(null,"Paciente eliminado con exito","Eliminar un paciente",1);
                            }
                        }
                    }

                    break;
                }
                
                case 16: {
                    if(consultas.isEmpty())
                        JOptionPane.showMessageDialog(null,"Aun no existen consultas registradas","Eliminar una consulta",1);
                    else {
                        noConsulta = Actions.entradaNumerica(0,1000,"Ingrese numero de la Consulta", "Eliminar una Consulta", rexNum);
                        aBorrar = Actions.hayConsulta(consultas, noConsulta);
                        if (aBorrar == -1)
                            JOptionPane.showMessageDialog(null,"No se encontro una consulta con el numero ingresado","Eliminar una consulta",1);
                        else{
                            // Buscar medico y paciente relacionados con la consulta
                            int indiceMedico = Actions.hayId(medicos,consultas.get(aBorrar).getIdEmpleado());
                            int indicePaciente = Actions.hayPaciente(pacientes,consultas.get(aBorrar).getNoPaciente());
                
                            String tipoMedico;
                
                            if (medicos.get(indiceMedico) instanceof Especialista) {
                                tipoMedico = "MÉDICO ESPECIALISTA";
                            } else {
                                tipoMedico = "MÉDICO FAMILIAR";
                            }
                
                            String detalle =
                                "DETALLE DE UNA CONSULTA\n" 
                                + "No. Consulta: " 
                                + consultas.get(aBorrar).getNoConsulta() 
                                + "\n\n" 
                                + tipoMedico + "\n" 
                                + medicos.get(indiceMedico).getDatos() + "\n\n" 
                                + "PACIENTE\n" 
                                + pacientes.get(indicePaciente).getDatos() + "\n\n" 
                                + "Fecha de consulta: "
                                + consultas.get(aBorrar).getFechaConsulta() + "\n"
                                + "Diagnóstico: "
                                + consultas.get(aBorrar).getDiagnostico();
                                    
                            cnfrm = JOptionPane.showConfirmDialog(null,detalle + "\n\n¿Esta seguro de eliminar esta consulta?",
                                    "Eliminar una consulta",JOptionPane.YES_NO_OPTION,2);
                            if (cnfrm == JOptionPane.YES_OPTION){
                                consultas.remove(aBorrar);
                                JOptionPane.showMessageDialog(null,"Consulta eliminada con exito","Eliminar una consulta",1);
                            }
                        }
                    }
                    
                    break;
                }
                
                case 17: {
                    JOptionPane.showMessageDialog(null,copyright,"Copyright",1);
                    break;
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
