//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Proyecto Entrega 3

/**
 * Clase Estudiante.
 * 
 * @author Grupo 8
 * @version Estudiante 1.1
 */
public class Estudiante extends Usuario{
    private String carrera;

    /**
     * Constructor
     * 
     * @author Grupo 8
     * @version Estudiante 1.1
     */
    public Estudiante(String nombre, String contra, String edad, String genero, String nivel, String ocupacion, String carrera){
        super(nombre, contra, edad, genero, nivel, ocupacion);
        this.carrera = carrera;
    }

    public String[] get_datos_persistencia_usuario(){
        String[] datos_persistencia = new String[7];
        datos_persistencia[0] = this.nombre;
        datos_persistencia[1] = this.contrasena;
        datos_persistencia[2] = this.edad;
        datos_persistencia[3] = this.genero;
        datos_persistencia[4] = this.nivel_educativo;
        datos_persistencia[5] = this.ocupacion;
        datos_persistencia[6] = this.carrera;
        return datos_persistencia;
    }
}
