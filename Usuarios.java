//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//Sección 11
//Actividad: Proyecto Entrega 2
//Grupo 8
//José Daniel Gómez Cabrera 21429
//Linda Inés Jiménez Vides 21169
//Mario Antonio Guerra Morales 21008
//Estuardo José Francisco Ayala Argueta 21315

import java.util.*;
import java.io.*;

/**
 * Clase Usuarios.
 * 
 * @author Grupo 8
 * @version Usuarios Class 1.1
 */
public class Usuarios {
    private ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
    private Usuario usuario_actual = null;

    public Usuarios(){
        leer_usuarios();
    }

    private void leer_estudiantes(){
        try{
            String file = "persistenciaEstudiantes.txt";
            File myFile = new File(file);
            Scanner scan = new Scanner(myFile);
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                String[] info_usuario = linea.split(",");
                Usuario estudiante = new Estudiante(info_usuario[0], info_usuario[1], info_usuario[2], info_usuario[3], info_usuario[4], info_usuario[5], info_usuario[6]);
                this.lista_usuarios.add(estudiante);
            }
        }
        catch(Exception e){
            String s = "leer_estudiantes(): "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    private void leer_profesores(){
        try{
            String file = "persistenciaProfesores.txt";
            File myFile = new File(file);
            Scanner scan = new Scanner(myFile);
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                String[] info_profe = linea.split(",");
                Usuario profe = new Profesor(info_profe[0], info_profe[1], info_profe[2], info_profe[3], info_profe[4], info_profe[5], info_profe[6]);
                this.lista_usuarios.add(profe);
            }
        }
        catch(Exception e){
            String s = "leer_profesores(): "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    private void leer_usuarios(){
        leer_estudiantes();
        leer_profesores();
    }

    public boolean acceder_cuenta(String nombre, String contra){
        boolean usuario_accedido = false;
        if(!(this.lista_usuarios.isEmpty())){
            boolean continuar = true;
            int contador = 0;
            while((continuar)&&(contador<this.lista_usuarios.size())){
                if((nombre.equals(this.lista_usuarios.get(contador).get_nombre()))&&(contra.equals(this.lista_usuarios.get(contador).get_contra()))){
                    this.usuario_actual = lista_usuarios.get(contador);
                    usuario_accedido = true;
                    continuar = false;
                }
                else{
                    contador += 1;
                }
            }
        }
        return usuario_accedido;
    }

    public void crear_usuario(int tipo_usuario, String[] info_usuario){
        switch (tipo_usuario){
            case 1: //estudiante
                Estudiante estudiante = new Estudiante(info_usuario[0], info_usuario[1], info_usuario[2], info_usuario[3], info_usuario[4], info_usuario[5], info_usuario[6]);
                agregar_usuarios(estudiante);
                break;

            default://profesor
                Profesor profe = new Profesor(info_usuario[0], info_usuario[1], info_usuario[2], info_usuario[3], info_usuario[4], info_usuario[5], info_usuario[6]);
                agregar_usuarios(profe);
                break;
        }
    }

    /**
     * Constructor Usuarios.
     * 
     * @author Grupo 8
     * @version Usuarios 1.1
     */
    public void agregar_usuarios(Usuario usuario){
        this.lista_usuarios.add(usuario);
    }

    public ArrayList<String> get_historial_usuario_actual(){
        return this.usuario_actual.get_historial();
    }

    public Usuario get_usuario_actual() {
        return this.usuario_actual;
    }

    public void cerrar_sesion(){
        this.usuario_actual = null;
    }

    public void modificar_usuario(int tipo_usuario, String[] info_usuario){
        switch (tipo_usuario){
            case 1: //estudiante
                Estudiante estudiante = new Estudiante(info_usuario[0], info_usuario[1], info_usuario[2], info_usuario[3], info_usuario[4], info_usuario[5], info_usuario[6]);
                this.usuario_actual = estudiante;
                break;

            default://profesor
                Profesor profe = new Profesor(info_usuario[0], info_usuario[1], info_usuario[2], info_usuario[3], info_usuario[4], info_usuario[5], info_usuario[6]);
                this.usuario_actual = profe;
                break;
        }
    }

    public void guardar_datos_persistencia_usuarios(){
        String file = "persistenciaEstudiantes.txt";
        try{
        FileWriter lapiz = new FileWriter(file);
        for(int k = 0; k<(this.lista_usuarios.size()) ;k++){
            String[] datos_usuario = this.lista_usuarios.get(k).get_datos_persistencia_usuario();
            System.out.println(datos_usuario[0]);
            if(k==(this.lista_usuarios.size()-1)){
                String s = datos_usuario[0]+","+datos_usuario[1]+","+datos_usuario[2]+","+datos_usuario[3]+","+datos_usuario[4]+","+datos_usuario[5]+","+datos_usuario[6];
                lapiz.write(s);
            }
            else{
                String s = datos_usuario[0]+","+datos_usuario[1]+","+datos_usuario[2]+","+datos_usuario[3]+","+datos_usuario[4]+","+datos_usuario[5]+","+datos_usuario[6]+"\n";
                lapiz.write(s);
            }
        }
        lapiz.close();
        }
        catch(Exception e){
            String s = "guardar_datos_persistencia_usuarios(): "+e.getMessage();
            throw new RuntimeException(s);
        }
    }
}
