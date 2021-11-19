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

/**
 * Clase de Leccion 
 * 
 * @author Grupo 8
 * @version Class Leccion 1.1
 */
public class Leccion {
    private int indice;
    private String titulo;
    private String cita;
    private String texto;
    private int frecuencia_visita;

    /**
     * Constructor de Leccion con propiedades
     * 
     * @author Grupo 8
     * @version Leccion 1.1
     * @param Propiedades de clase Leccion
     */
    public Leccion(int indice, String titulo, String cita, String texto){
        this.indice = indice;
        this.titulo = titulo;
        this.texto = texto;
        this.cita = cita;
    }

    /**
     * getter de la información de la cuál está conformada la lección deseada
     * 
     * @author Grupo 8
     * @version get_info_leccion 1.1
     * @return String
     */
    public String[] get_info_leccion(){
        String[] info_leccion = new String[3];
        info_leccion[0] = this.titulo;
        info_leccion[1] = this.cita;
        info_leccion[2] = this.texto;
        return info_leccion;
    }

        /**
     * getter de indice de la leccion
     * 
     * @author Grupo 8
     * @version get_indice 1.1
     * @return int
     */
    public int get_indice(){
        return this.indice;
    }

    /**
     * getter de titulo de la leccion
     * 
     * @author Grupo 8
     * @version get_titulo 1.1
     * @return String
     */
    public String get_titulo(){
        return this.titulo;
    }

        /**
     * Método para actualizar la frecuencia de visitas cada vez que se visite la leccion correspondiente
     * 
     * @author Grupo 8
     * @version set_Frecuenciavisitas 1.1
     */
    public void set_Frecuenciavisitas(){
        this.frecuencia_visita += 1;
    }

    /**
     * getter de frecuencia de visita a la leccion
     * 
     * @author Grupo 8
     * @version get_frecuencia 1.1
     * @return int
     */
    public int get_frecuencia(){
        return this.frecuencia_visita;
    }
}
