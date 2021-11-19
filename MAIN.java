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
 * Clase MAIN 
 * Funciona como el controlador General del programa.
 * 
 * @author Grupo 8
 * @version Class MAIN 1.1
 */
public class MAIN {

    /**
     * Metodo Main
     * 
     * @author Grupo 8
     * @version main 1.1
     */
    public static void main(String[] args) {
        try{
            Controlador programa = new Controlador();
            programa.Tututor();
        }
        catch(Exception e){
            String s = "- Lo sentimos... Ha ocurrido un error: "+e.getMessage();
            System.out.println(s);
        }
    }
}
