// Desarrolladores:
// Eric Rene Avila Galindo
// Quintanar Medina Marco Eduardo
// Vazquez Vizuet Angel Alexis

package pck_consultorio;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pck_fecha.*;

public interface Actions {
    // Inicio de archivos
    static <T> void cargarLista(String nombre, ArrayList<T> lista){
        FileInputStream fin = null;
        ObjectInputStream entrada = null;

        try{
            ArrayList<T> aux;

            fin = new FileInputStream(nombre);
            
            entrada = new ObjectInputStream(fin);
            aux = (ArrayList<T>)entrada.readObject();

            lista.addAll(aux);

        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error de clase\n" + e.getMessage());
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se encontro el archivo\n" + e.getMessage());
        }catch(EOFException e){
            JOptionPane.showMessageDialog(null,"Lectura completada\n");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error de E/S\n" + e.getMessage());
        }finally{
            try{
                if(fin != null){
                    fin.close();
                }
                if (entrada != null){
                    entrada.close();
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Error al cerrar archivo.\n" + e.getMessage());
            }
        }
    }

    // Salida de archivos
    static <T> void guardarLista(String nombre, ArrayList<T> lista){
        FileOutputStream fout = null;
        ObjectOutputStream salida = null;

        try{
            fout = new FileOutputStream(nombre);
            
            salida = new ObjectOutputStream(fout);
            salida.writeObject(lista);

        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se encontro el archivo...\n" + e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error de E/S.\n" + e.getMessage());
        }finally{
            try{
                if(fout != null){
                    fout.close();
                }
                if (salida != null){
                    salida.close();
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Error al cerrar archivo.\n" + e.getMessage());
            }
        }
    }

    // Entrada numerica por intervalo
    static int entradaNumerica(int l, int r, String dato, String titulo, String minDato) {
        int num;

        do {
            num = l - 1; 

            try {
                String ent = JOptionPane.showInputDialog(null, dato, titulo, 3);
                num = Integer.parseInt(ent);

                if (num < l || num > r) {
                    JOptionPane.showMessageDialog(null, "El(la) " + minDato + " debe estar entre " + l + " y " + r, "Valor invalido", 2);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El(la) " + minDato + " debe ser numerico", "Error de formato", 2);
            }

        } while (num < l || num > r);

        return num;
    }

    // Entrada de strings
    static String checkString(String aboutVar, String titleBox, String rex) {
        String s;

        do {
            s = JOptionPane.showInputDialog(null, aboutVar, titleBox, 3);
            s = s.trim();

            if (s.isBlank()) {
                JOptionPane.showMessageDialog(null,"La entrada no debe estar vacía","Error de entrada",2);
            } 
            else if (!s.matches(rex)) {
                JOptionPane.showMessageDialog(null,"La entrada tiene valores invalidos","Error de entrada",2);
            }

        } while (s.isBlank() || !s.matches(rex));

        return s;
    }

    // checar si esta id medico
    static int hayId(ArrayList<Medico> lista, String id) {
        for (int i = 0; i < lista.size(); i++) {
            Medico check = lista.get(i);

            if (check.getIdEmpleado().equals(id)) return i;
        }
        return -1;
    }

    // No esta el id para medico
    static int hayId (ArrayList<Medico> lista, String id, String tipoM){
        for (int i = 0; i < lista.size(); i++){
            Medico check = lista.get(i);
            // Devuelve -2 si el medico buscado no coincide con el tipo de medico a buscar
            if (check instanceof General){
                if (check.getIdEmpleado().equals(id) && tipoM.equals("general")) return i;
                else if (check.getIdEmpleado().equals(id) && tipoM.equals("especialista")) return -2;
            }
            else if (check instanceof Especialista){
                if (check.getIdEmpleado().equals(id) && tipoM.equals("especialista")) return i;
                else if (check.getIdEmpleado().equals(id) && tipoM.equals("general")) return -2;
            }
        }
        return -1;
    }

     // checar si esta paciente
    static int hayPaciente (ArrayList<Paciente> lista, int id){
        for (int i = 0; i < lista.size(); i++){
            Paciente check = lista.get(i);

            if (check.getNoPaciente() == id) return i;
        }
        return -1;
    }

    // checar si hay consulta
    static int hayConsulta (ArrayList<Consulta> lista, int id){
        for (int i = 0; i < lista.size(); i++){
            Consulta check = lista.get(i);

            if (check.getNoConsulta() == id) return i;
        }
        return -1;
    }

    // Comprobar si un medico tiene consultas asociadas
    static boolean tieneConsultasMedico(ArrayList<Consulta> consultas, String idEmpleado) {
        for (Consulta consulta : consultas) {
            if (consulta.getIdEmpleado().equals(idEmpleado)) {
                return true;
            }
        }
    
        return false;
    }

    // Comprobar si un paciente tiene consultas asociadas
    static boolean tieneConsultasPaciente(ArrayList<Consulta> consultas, int noPaciente) {
        for (Consulta consulta : consultas) {
            if (consulta.getNoPaciente() == noPaciente) {
                return true;
            }
        }
    
        return false;
    }

    // Validar todas las referencias de las consultas
    static boolean validarIntegridad(ArrayList<Medico> medicos,ArrayList<Paciente> pacientes,ArrayList<Consulta> consultas) {
        for (Consulta consulta : consultas) {
    
            if (hayId(medicos, consulta.getIdEmpleado()) == -1) {
                JOptionPane.showMessageDialog(null,"La consulta " + consulta.getNoConsulta() + " referencia a un medico inexistente");
                return false;
            }
    
            if (hayPaciente(pacientes, consulta.getNoPaciente()) == -1) {
                JOptionPane.showMessageDialog(null, "La consulta " + consulta.getNoConsulta() + " referencia a un paciente inexistente");
                return false;
            }
        }
    
        return true;
    }

    // Ingreso de una fecha valida
    static Fecha ingresoFecha(String titulo, String minDato){
        Fecha fecha;
        Fecha hoy = new Fecha(9, 10, 2026);
        
        do { 
            int d, m, a;

            d = entradaNumerica(1, 31, "Ingrese el dia de: " + minDato, titulo, minDato);
            m = entradaNumerica(1, 12, "Ingrese el mes de: " + minDato, titulo, minDato);
            a = entradaNumerica(1900, 2026, "Ingrese el anio de: " + minDato, titulo, minDato);

            fecha = new Fecha(d, m, a);

            if (!fecha.fechaCorrecta()) JOptionPane.showMessageDialog(null, "La fecha no existe", "Error", 2);
            else if (!fecha.esAnteriorOIgual(hoy)) JOptionPane.showMessageDialog(null, "La fecha no puede ser despues del 9 / 10 / 2026", "Error", 2);
            
        } while (!fecha.fechaCorrecta() || !fecha.esAnteriorOIgual(hoy));

        return fecha;
    }

    // Validar edades
    static Fecha fNacimiento (int p){
        int edad = 0;
        Fecha fechaNacimiento;
        do { 
            Fecha hoy = new Fecha(9, 10, 2026);
            fechaNacimiento = Actions.ingresoFecha("Alta de un medico familiar", "Nacimiento");
            
            edad = fechaNacimiento.calcularEdad(hoy);

            if (p == 1){
                if (edad < 29) JOptionPane.showMessageDialog(null, "El medico debe ser mayor de 28 anios", "Alta de un medico", 2);
                if (edad > 50) JOptionPane.showMessageDialog(null, "El medico debe ser menor de 50 anios", "Alta de un medico", 2);
            }
            else{
                if (edad < 0) JOptionPane.showMessageDialog(null, "El paciente debe de haber nacido", "Alta de un paciente", 2);
                if (edad > 115) JOptionPane.showMessageDialog(null, "El paciente debe tener una vida razonable (menos a 115 anios)", "Alta de un paciente", 2);
            
            }

        } while ((p == 1 && (edad < 29 || edad > 50)) || (p == 2 && (edad < 0 || edad > 115)));

        return fechaNacimiento;
    }

    // Arreglo para la eliminacion de las consultas de un medico
    static ArrayList <Integer> listaConsultas(ArrayList <Consulta> lista, String id){
        ArrayList <Integer> c = new ArrayList <>();
        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getIdEmpleado().equals(id)) c.add(i);
        }
        
        return c;
    }
    
    // Arreglo para la eliminacion de las consultas de un paciente
    static ArrayList <Integer> listaConsultas(ArrayList <Consulta> lista, int id){
        ArrayList <Integer> c = new ArrayList <>();
        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getNoPaciente() == id) c.add(i);
        }
        
        return c;
    }

}
