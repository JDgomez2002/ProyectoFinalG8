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
    public Estudiante(String contra, String nombre, String edad, String genero, String nivel, String ocupacion, String carrera){
        super(contra, nombre, edad, genero, nivel, ocupacion);
        this.carrera = carrera;
    }
}
