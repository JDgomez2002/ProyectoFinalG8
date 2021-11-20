//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Proyecto fase 3

/**
 * Clase Profesor.
 * 
 * @author Grupo 8
 * @version Profesor 1.1
 */
public class Profesor extends Usuario{
    private String titulo_universitario;
    private int lecciones_creadas;

    /**
     * Constructor
     * 
     * @author Grupo 8
     * @version Profesor 1.1
     */
    public Profesor(String nombre, String contra, String edad, String genero, String nivel, String ocupacion, String titulo){
        super(nombre, contra, edad, genero, nivel, ocupacion);
        this.titulo_universitario = titulo;
        this.lecciones_creadas = 16; //total de lecciones.
    }

    /**
     * metodo para crear una leccion por parte del profesor.
     * 
     * @author Grupo 8
     * @version crear_leccion 1.1
     */
    public Leccion crear_leccion(String titulo, String cita, String texto){
        Leccion leccion = new Leccion(this.lecciones_creadas, titulo, cita, texto);
        this.lecciones_creadas += 1;
        return leccion;
    }

    public String[] get_datos_persistencia_usuario(){
        String[] datos_persistencia = new String[7];
        datos_persistencia[0] = this.nombre;
        datos_persistencia[1] = this.contrasena;
        datos_persistencia[2] = this.edad;
        datos_persistencia[3] = this.genero;
        datos_persistencia[4] = this.nivel_educativo;
        datos_persistencia[5] = this.ocupacion;
        datos_persistencia[6] = this.titulo_universitario;
        return datos_persistencia;
    }
}
