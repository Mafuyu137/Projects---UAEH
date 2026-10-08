import pck_consultorio.*;
import pck_fecha.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mafuyu implements Actions{
    public static void main(String[] args) {
        // Arreglos dinamicos
        ArrayList <Medico> medicos = new ArrayList <>();
        ArrayList <Consulta> consultas = new ArrayList <>();
        ArrayList <Paciente> pacientes = new ArrayList <>();
        
        // Lectura de los archivos
        Actions.cargarLista("Medicos.txt", medicos);
        Actions.cargarLista("Pacientes.txt", consultas);
        Actions.cargarLista("Consiltas.txt", pacientes);

        // Variables a utilizar
        int id;
        String nombre;
        Fecha fecha;
        
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
                           n1
                           Vazquez Vizuet Angel Alexis
                           """;
        
        do{
            do{
                opc = -1;
                try{
                    opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Menu",3));
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"La opcion debe ser numerica","Error de entrada",2);
                }
            }while(opc == -1);

            switch(opc){
                case 1 -> {
                    id = 0;
                    nombre = "Siuu";
                    fecha = new Fecha (1, 3, 2019);

                    id = id * id;
                    nombre += nombre;
                    if (fecha.fechaCorrecta()) id = id * id;
                }
                
                case 2 -> {
                    
                }
                
                case 3 -> {
                    
                }
                
                case 4 -> {
                    
                }
                
                case 5 -> {
                    
                }
                
                case 6 -> {
                    
                }
                
                case 7 -> {
                    
                }
                
                case 8 -> {
                    
                }
                
                case 9 -> {
                    
                }
                
                case 10 -> {
                    
                }
                
                case 11 -> {
                    
                }
                
                case 12 -> {
                    
                }
                
                case 13 -> {
                    
                }
                
                case 14 -> {
                    
                }
                
                case 15 -> {
                    
                }
                
                case 16 -> {
                    
                }
                
                case 17 -> {
                    JOptionPane.showMessageDialog(null,copyright,"Copyright",1);
                }
                
                default -> {
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
