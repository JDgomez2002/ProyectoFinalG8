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

import java.util.ArrayList;

 /**
  * Clase de Usuario con las variables necesarias
  *
  *@author Grupo 8
  *@version Class Usuario 1.1
  */
public class Usuario {
    private String nombre;
    private String edad;
    private String genero;
    private String nivel_educativo;
    private String ocupacion;
    private String contrasena;
    private ArrayList<String> historial = new ArrayList<String>();

    /**
     * Constructor.
     * 
     * @author Grupo 8
     * @version Usuario 1.1
     */
    public Usuario(String nombre, String contra, String edad, String genero, String nivel, String ocupacion){
      this.contrasena = contra;
      this.nombre = nombre;
      this.edad = edad;
      this.genero = genero;
      this.nivel_educativo = nivel;
      this.ocupacion = ocupacion;
      String texto = "Sin Actividad";
      for(int k = 0; k<10 ;k++){
        this.historial.add(texto);
      }
    }

    /**
     * Metodo toString para la informacion del usuario.
     * 
     * @author Grupo 8
     * @version get_info_usuario 1.1
     * @return String[]
     */
    public String[] get_info_usuario(){
      String[] info = new String[5];
      info[0] = this.nombre;
      info[1] = this.edad;
      info[2] = this.genero;
      info[3] = this.nivel_educativo;
      info[4] = this.ocupacion;
      return info;
    }

    /**
     * getter del historial del usuario.
     * 
     * @author Grupo 8
     * @version get_info_usuario 1.1
     * @return String[]
     */
    public ArrayList<String> get_historial(){
      return this.historial;
    }

    /**
     * actualiza el historial con una nueva leccion.
     * retira la leccion mas antigua, de 10.
     * 
     * @author Grupo 8
     * @version actualizar_historial 1.1
     * @param Leccion
     */
    public void actualizar_historial(Leccion ultima_leccion){
      String titulo_ultima_leccion = ultima_leccion.get_titulo();
      this.historial.add(titulo_ultima_leccion);
      if((this.historial.size())>10){
        this.historial.remove(0);
      }
    }

    public String get_contra(){
      return this.contrasena;
    }

    public String get_nombre(){
      return this.nombre;
    }
}
