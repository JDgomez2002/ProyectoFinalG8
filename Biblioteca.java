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
import java.io.File;

/**
 * Clase de Biblioteca.
 * Almacena las lecciones en un ArrayList.
 * 
 * @author Grupo 8
 * @version Class Biblioteca 1.1
 */
public class Biblioteca{
    private ArrayList<Leccion> lecciones = new ArrayList<Leccion>();

    /**
     * Constructor de Biblioteca.
     * Lee todos los archivos de texto que contienen la informacion de las lecciones.
     * 
     * @author Grupo 8
     * @version Biblioteca 1.1
     */
    public Biblioteca(){
        ArrayList<String> info_separada = new ArrayList<String>();
        try{
            for(int k = 0; k<14; k++){
                String numero_leccion = k+"L.txt";
                File myFile = new File(numero_leccion);
                Scanner scan = new Scanner(myFile);

                while(scan.hasNextLine()){
                    String linea = scan.nextLine();
                    info_separada.add(linea);
                }
            
                Leccion leccion_n = new Leccion(k, info_separada.get(0), info_separada.get(1), info_separada.get(2));
                lecciones.add(leccion_n);
                info_separada.clear();

            }
        }
        catch(Exception e){
            String s = "Biblioteca: leer archivos: " + e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * Getter de las lecciones
     * 
     * @author Grupo 8
     * @version get_lecciones 1.1
     * @return Lecciones String
     */
    public ArrayList<Leccion> get_lecciones(){
        return this.lecciones;
    }

    /**
     * Metodo que devuelve la leccion por medio de su propiedad indice.
     * 
     * @author Grupo 8
     * @version obtener_leccion 1.1
     * @return Leccion
     * @param int
     */
    public Leccion obtener_leccion(int indice){
        boolean continuar = true;
        Leccion leccion_actual = null;
        int contador = 0;

        while(continuar&&(contador<this.lecciones.size())){
            if(indice == (this.lecciones.get(contador).get_indice())){
                leccion_actual = this.lecciones.get(contador);
                continuar = false;
            }
            else{
                contador += 1;
            }
        }
        return leccion_actual;
    }
    
    /**
     * Metodo que devuelve la leccion por medio de un String.
     * Utiliza el metodo contains para tambien poder buscar por palabras claves.
     * 
     * @author Grupo 8
     * @version obtener_leccion_2 1.1
     * @return Leccion
     * @param String
     */
    public Leccion obtener_leccion(String string_usuario){
        string_usuario = string_usuario.toLowerCase();
        boolean continuar = true;
        Leccion leccion_actual = null;
        int contador = 0;

        while(continuar&&(contador<this.lecciones.size())){
            String titulo_leccion = this.lecciones.get(contador).get_titulo();
            titulo_leccion = titulo_leccion.toLowerCase();
            if(titulo_leccion.contains(string_usuario)){
                leccion_actual = this.lecciones.get(contador);
                continuar = false;
            }
            else{
                contador += 1;
            }
        }
        return leccion_actual;
    }
}
