/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paciente;

/**
 *
 * @author HatusP
 */
public class BaseDatos {
    
    //Los objetos Paciente son serializados en esta lista de Pacientes y guardados en un archivo
    //Este modelo se puede extender a para guardar los datos de cualquier objeto dentro del programa
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static void guardarPacientes() throws FileNotFoundException {
        try {
            System.out.println("GUARDADO DE PACIENTES");
            FileOutputStream fos = new FileOutputStream("src/recursos/DatosPacientes");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaPacientes);
            oos.close();
            fos.close();

        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cargarPacientes() throws FileNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("src/recursos/DatosPacientes");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaPacientes = (ArrayList) ois.readObject();
            System.out.println("CARGADO DE PACIENTES EXITOSO");
           // System.out.println(listaPacientes);
        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}