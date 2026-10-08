package pck_consultorio;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public interface Actions {
    // Inicio de archivos
    static <T> void cargarLista(String nombre, ArrayList<T> lista){
        FileInputStream fin = null;
        ObjectInputStream entrada = null;

        try{
            ArrayList<T> aux = null;

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

                // Por si se presiona cancelar o cierra la ventana
                if (ent == null) {
                    JOptionPane.showMessageDialog(null, "Operacion cancelada", "Aviso", 2);
                    return num;
                }

                num = Integer.parseInt(ent);

                if (num < l || num > r) {
                    JOptionPane.showMessageDialog(null, "El " + minDato + " debe estar entre " + l + " y " + r, "Valor invalido", 2);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El " + minDato + " debe ser numerico", "Error de formato", 2);
            }

        } while (num < l || num > r);

        return num;
    }

    // Entrada de strings
    static String checkString(String aboutVar, String titleBox){
        String s;
        do{
            s = JOptionPane.showInputDialog(null,aboutVar,titleBox,3);
            s = s.trim();
            
            if(s.isBlank()) JOptionPane.showMessageDialog(null,"La entrada no debe estar vacia","Error de entrada",2);    
        }while(s.isBlank());
        
        return s;
    }
}
