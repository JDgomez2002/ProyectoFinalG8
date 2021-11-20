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
import java.time.*;

/**
 * Clase de Interfaz 
 * 
 * @author Grupo 8
 * @version Class Interfaz 0
 */
public class Interfaz{
    private Scanner sn = new Scanner(System.in);
    private Biblioteca biblioteca = new Biblioteca();
    private int opcion2 = 0;

    /**
     * Bienvenida al usuario.
     * 
     * @author Grupo 8
     * @version bienvenida 1.1
     */
    public void bienvenida(){
        System.out.println();
        System.out.println();
        System.out.println("------------ Tututor APP ------------");
        System.out.println();
        System.out.println("------------ BIENVENIDO ------------");
        System.out.println("- Hora de Entrada: "+LocalTime.now().getHour()+" horas con "+LocalTime.now().getMinute()+" minutos.");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Esta APP es Tututor, de estudiantes para estudiantes.");
        System.out.println("- En esta aplicacion podras prepararte para tu examen de admision de la universidad.");
        System.out.println("- Podras encontrar distintos temas, como Matematica, Fisica, Biologia, Computacion, Estadistica, y entre muchos mas!");
        System.out.println("- Podras acceder a muchas lecciones, y poder crear tu cuenta.");
        System.out.println("- Tu historial se mantendra para que puedas regresar a las lecciones que dejaste pendiente.");
        System.out.println("- Recuerda que el mayor logro, se obtiene con el mayor esfuerzo!");
        System.out.println("- Siempre sigue aprendiendo!!");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Muestra el menu principal y devuelve la opcion que desee elegir del menu.
     * 
     * @author Grupo 8
     * @version menuOpciones 1.1
     * @return int
     */
    public int menuOpciones(){
        boolean siguiente = true;
        int opcion = 0;
        while(siguiente){
            try{
                System.out.println();
                System.out.println("------------ MENU PRINCIPAL ------------");
                System.out.println();
                System.out.println("1. Mostras Biblioteca");
                System.out.println("2. Buscar Leccion");
                System.out.println("3. Simulador de examen de admision");
                System.out.println("4. Historial de Lecciones");
                System.out.println("5. Mi cuenta");
                System.out.println("6. Salir");
                System.out.println();
                System.out.println("- Recuerda que la informacion de tu cuenta");
                System.out.println(" y contrasena se guardaran automaticamente");
                System.out.println(" al cerrar el programa...");
                System.out.println();
                System.out.print("Digite su opcion aqui: ");
                sn = new Scanner(System.in);
                opcion = sn.nextInt();
                if((opcion>0) && (opcion<7)){
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    siguiente = false;
                }
                else{
                    System.out.println();
                    System.out.println("\t\tError: ingrese un numero del 1 al 6");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("\t\tError: ingrese un numero valido");
                System.out.println();
                sn.next();
            }
        }
        return opcion;
    }

    /**
     * Metodo encargado de administrar la biblioteca.
     * Utiliza el metodo indice_leccion_biblioteca y mostrar_leccion.
     * 
     * @author Grupo 8
     * @version biblioteca 1.1
     */
    public ArrayList<Leccion> biblioteca(){
        boolean continuar = true;
        String volver_al_menu = "";
        ArrayList<Leccion> lecciones_visitadas = new ArrayList<Leccion>();
        Leccion leccion_a_mostrar = null;
        while(continuar){
            int leccion = 0;
            leccion = indice_leccion_biblioteca();
            leccion_a_mostrar = this.biblioteca.obtener_leccion(leccion);
            mostrar_leccion(leccion_a_mostrar);
            lecciones_visitadas.add(leccion_a_mostrar);
            try{
                System.out.print("\t\tDesea seguir en la biblioteca? (Si/No): ");
                sn = new Scanner(System.in);
                volver_al_menu = sn.nextLine();
                System.out.println();
                if((volver_al_menu.equals("No"))||(volver_al_menu.equals("NO"))||(volver_al_menu.equals("no"))){
                    continuar = false;
                }
            }
            catch(Exception e){
                continuar = true;
            }
        }
        System.out.println();
        System.out.println("- Regresando al menu...");
        System.out.println();
        return lecciones_visitadas;
    }

    /**
     * Metodo encargado de mostrar la biblioteca y de retornar el indice de leccion que se desea acceder.
     * 
     * @author Grupo 8
     * @version indice_leccion_biblioteca 1.1
     * @return int
     */
    public int indice_leccion_biblioteca(){
        boolean siguiente = true;
        int opcion = 0;
        while(siguiente){
            try {
                System.out.println();
                System.out.println("------------ BIBLIOTECA ------------");
                System.out.println();
                System.out.println("--- MATEMATICA ---");
                System.out.println();
                for(int k = 0; k<4; k++){
                    System.out.println((k+1)+" "+this.biblioteca.get_lecciones().get(k).get_titulo());
                }
                System.out.println();
                System.out.println("--- FISICA ---");
                System.out.println();
                for(int i = 4; i<8; i++){
                    System.out.println((i+1)+" "+this.biblioteca.get_lecciones().get(i).get_titulo());
                }
                System.out.println();
                System.out.println("--- BIOLOGIA ---");
                System.out.println();
                for(int i = 8; i<11; i++){
                    System.out.println((i+1)+" "+this.biblioteca.get_lecciones().get(i).get_titulo());
                }
                System.out.println();
                System.out.println("--- COMUNICACION ---");
                System.out.println();
                for(int i = 11; i<14; i++){
                    System.out.println((i+1)+" "+this.biblioteca.get_lecciones().get(i).get_titulo());
                }
                System.out.println();
                System.out.println();
                System.out.print("Digite su opcion aqui: ");
                sn = new Scanner(System.in);
                opcion = sn.nextInt();
                if((opcion>0) && (opcion<15)){
                    opcion -= 1;
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    siguiente = false;
                } else{
                    System.out.println();
                    System.out.println("\t\tError: Su opcion debe de ser un indice de las lecciones de la biblioteca...");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("\t\tError: Su opcion debe de ser un indice de las lecciones de la biblioteca...");
                sn.next();
            }
        }
        return opcion;
    }

    /**
     * Metodo encargado de administrar la pestana busqueda.
     * Utiliza los metodos mostrar_pestana_buscar, solicitar_leccion_buscar y obtener_leccion_2.
     * 
     * @author Grupo 8
     * @version buscar_leccion 1.1
     */
    public ArrayList<Leccion> buscar_leccion(){
        boolean continuar = true;
        String volver_al_menu = "";
        ArrayList<Leccion> lecciones_buscadas = new ArrayList<Leccion>();
        Leccion leccion_a_mostrar = null;
        while(continuar){
            mostrar_pestana_buscar();
            String leccion_a_buscar = solicitar_leccion_a_buscar();
            leccion_a_mostrar = this.biblioteca.obtener_leccion(leccion_a_buscar);
            if(!(leccion_a_mostrar == null)){
                mostrar_leccion(leccion_a_mostrar);
                lecciones_buscadas.add(leccion_a_mostrar);
            }
            else{
                System.out.println();
                System.out.println("\t Lo sentimos...");
                System.out.println("\t Leccion no encontrada en la base de datos...");
                System.out.println();
            }
            try{
                System.out.print("\t\tDesea seguir buscando? (Si/No): ");
                sn = new Scanner(System.in);
                volver_al_menu = sn.nextLine();
                System.out.println();
                if((volver_al_menu.equals("No"))||(volver_al_menu.equals("NO"))||(volver_al_menu.equals("no"))){
                    continuar = false;
                }
            }
            catch(Exception e){
                continuar = true;
            }
        }
        System.out.println();
        System.out.println("- Regresando al menu...");
        System.out.println();
        return lecciones_buscadas;
    }

    /**
     * Muestra el encabezado de la pestana buscar.
     * 
     * @author Grupo 8
     * @version mostrar_pestana_buscar 1.1
     */
    public void mostrar_pestana_buscar(){
        System.out.println();
        System.out.println("------------------ BUSCAR LECCION ------------------");
        System.out.println();
        System.out.println("- En esta pestana podras buscar lecciones por medio de su titulo.");
        System.out.println("- Solo basta escribir el nombre de la leccion.");
        System.out.println("- Sin embargo, tambien puedes buscarlas por palabras claves!");
        System.out.println("- Algunas palabras clave pueden ser:");
        System.out.println("  Movimiento, Numeros, Derivadas, Ecuaciones, entre otras...");
        System.out.println("- Que el aprendizaje nunca termine!!!");
        
    }

    /**
     * Solicita un String de la leccion que desea buscar al usuario.
     * Si el texto es vacio o hay una excepcion, el metodo se mantiene solicitando el String al usuario.
     * 
     * @author Grupo 8
     * @version solicitar_leccion_a_buscar 1.1
     * @return String
     */
    public String solicitar_leccion_a_buscar(){
        boolean continuar = true;
        String leccion_buscada = "";
        while(continuar){
            try{
                System.out.println();
                System.out.print("\t- Digite el nombre o palabra clave de la leccion que desea buscar: ");
                sn = new Scanner(System.in);
                leccion_buscada = sn.nextLine();
                if(leccion_buscada.equals("")){
                    System.out.println();
                    System.out.println("\t\t- ERROR: digite un titulo de leccion valido.");
                }
                else{
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    leccion_buscada = leccion_buscada.toLowerCase();
                    continuar = false;
                }
            }
            catch(Exception e){
                System.out.println();
                System.out.println("\t\t- ERROR: digite un titulo de leccion o palabra clave valida.");
                sn.next();
            }
        }
        return leccion_buscada;   
    }

    /**
     * Metodo encargado de mostrar una leccion.
     * Se utiliza en la biblioteca y busqueda.
     * 
     * @author Grupo 8
     * @version mostrar_leccion 1.1
     * @param Leccion
     */
    public void mostrar_leccion(Leccion leccion_a_mostrar){
        String[] datos_leccion = leccion_a_mostrar.get_info_leccion();
        String[] texto_leccion = datos_leccion[2].split(":");
        System.out.println();
        System.out.println("-- LECCION --");
        System.out.println();
        System.out.print("Titulo: ");
        System.out.println(datos_leccion[0]);
        System.out.println();
        System.out.print("Referencia: ");
        System.out.println(datos_leccion[1]);
        System.out.println();
        for(int k = 0; k<texto_leccion.length; k++){
            System.out.println(texto_leccion[k]);
        }
        System.out.println();
    }

    /**
     * Despedida para el usuario.
     * 
     * @author Grupo 8
     * @version despedida 1.1
     */
    public void despedida(){
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Gracias por utilizar Tututor!!!");
        System.out.println("- Vuelve pronto!");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    /**
     * Mensaje informativo para el usuario.
     * 
     * @author Grupo 8
     * @version simulador_no_disponible 1.1
     */
    public int simuladores(){
        boolean cuestionario = true;
        while(cuestionario){
            try {
                System.out.println();
                System.out.println("------------ Simuladores ------------");
                System.out.println();
                System.out.println("1. Biologia");
                System.out.println("2. Matematica");
                System.out.println("3. Fisica");
                System.out.println("4. Lenguaje");
                System.out.println();
                System.out.print("Digite su opcion aqui: ");
                sn = new Scanner(System.in);
                opcion2 = sn.nextInt();
                if((opcion2>0) && (opcion2<5)){
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    cuestionario = false;
                }
                else{
                    System.out.println();
                    System.out.println("\t\tError: ingrese un numero del 1 al 4");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("\t\tError: ingrese un numero valido");
                System.out.println();
                sn.next();
            }
        }
        return opcion2;
    }

    

    /**
     * Mensaje informativo para el usuario.
     * 
     * @author Grupo 8
     * @version historial_no_disponible 1.1
     */
    public void historial_no_disponible(){
        System.out.println();
        System.out.println("\t\t- Lo sentimos, el historial de sus lecciones no esta disponible porque no ha iniciado sesion...");
        System.out.println("\t\t- Inicie sesion para tener acceso a su historial.");
        System.out.println();
        System.out.println("\t\t- Regresando al Menu...");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public String[] acceder_cuenta(){
        String[] info = new String[2];
        try{
            boolean continuar = true;
            while(continuar){
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("- Bienvenido a inicio de sesion...");
                System.out.println("- Danos tu nombre se usuario y contrasena para acceder a tu usuario.");
                System.out.print(" Digite su nombre de usuario: ");
                this.sn = new Scanner(System.in);
                String nombre = sn.nextLine();
                if(!(nombre.equals(""))){
                    System.out.print(" Digite su contrasena: ");
                    this.sn = new Scanner(System.in);
                    String contra = sn.nextLine();
                    if(!(contra.equals(""))){
                        info[0] = nombre;
                        info[1] = contra;
                        System.out.println("---------------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        continuar = false;
                    }
                    else{
                        System.out.println("\t- Error: digite un nombre o contrasena valida.");
                    }
                }
                else{
                    System.out.println("\t- Error: digite un nombre o contrasena valida.");
                }
            }
        }
        catch(Exception e){
            System.out.println("\t- Error: digite un nombre o contrasena valida.");
        }
        return info;
    }

    public String[] get_info_usuario(){
        String[] info = new String[7];
        try{
            boolean continuar = true;
            while(continuar){
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("- Bienvenido a crear un usuario...");
                System.out.println("- Danos tu nombre, contrasena y toda tu informacion necesaria.");
                System.out.print(" Digite su nombre de usuario: ");
                this.sn = new Scanner(System.in);
                String nombre = sn.nextLine();
                if(!(nombre.equals(""))){
                    System.out.print(" Digite su contrasena: ");
                    this.sn = new Scanner(System.in);
                    String contra = sn.nextLine();
                    if(!(contra.equals(""))){
                        System.out.print(" Digite su edad: ");
                        this.sn = new Scanner(System.in);
                        String edad = sn.nextLine();
                        if(!(edad.equals(""))){
                            System.out.print(" Digite su genero: ");
                            this.sn = new Scanner(System.in);
                            String gen = sn.nextLine();
                            if(!(gen.equals(""))){
                                System.out.print(" Digite su nivel educativo: ");
                                this.sn = new Scanner(System.in);
                                String nivel = sn.nextLine();
                                if(!(nivel.equals(""))){
                                    System.out.print(" Digite su ocupacion (estudiante, etc): ");
                                    this.sn = new Scanner(System.in);
                                    String ocup = sn.nextLine();
                                    if(!(ocup.equals(""))){
                                        System.out.print(" Digite su titulo universitario o carrera de estudio: ");
                                        this.sn = new Scanner(System.in);
                                        String titulo = sn.nextLine();
                                        if(!(titulo.equals(""))){
                                            info[0] = nombre;
                                            info[1] = contra;
                                            info[2] = edad;
                                            info[3] = gen;
                                            info[4] = nivel;
                                            info[5] = ocup;
                                            info[6] = titulo;
                                            System.out.println("\t\t- Datos obtenidos con exito!!");
                                            System.out.println("---------------------------------------------------------------------------------------------------------------------");
                                            System.out.println();
                                            continuar = false; 
                                        }
                                        else{
                                            System.out.println("\t- Error: digite una edad valida.");
                                        }
                                        
                                    }
                                    else{
                                        System.out.println("\t- Error: digite una edad valida.");
                                    }
                                    
                                }
                                else{
                                    System.out.println("\t- Error: digite una edad valida.");
                                }
                                
                            }
                            else{
                                System.out.println("\t- Error: digite una edad valida.");
                            }
                        }
                        else{
                            System.out.println("\t- Error: digite una edad valida.");
                        }
                    }
                    else{
                        System.out.println("\t- Error: digite un nombre o contrasena valida.");
                    }
                }
                else{
                    System.out.println("\t- Error: digite un nombre o contrasena valida.");
                }
            }
        }
        catch(Exception e){
            System.out.println("\t- Error: digite datos validos.");
        }
        return info;
    }

    public int estudiante_o_profesor(){
        int opcion = 0;
        try{
            boolean continuar = true;
            while(continuar){
                System.out.println("- Es estudiante o profesor?");
                System.out.println(" Los estudiantes pueden estudiar y realizar examenes.");
                System.out.println(" Los profesores pueden crear examenes para los estudiantes.");
                System.out.println("- Digite 1 para ser estudiante y 2 para ser profesor...");
                System.out.println();
                System.out.print("Digite su opcion aqui: ");
                sn = new Scanner(System.in);
                opcion = sn.nextInt();
                if((opcion>0) && (opcion<3)){
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    continuar = false;
                } 
                else{
                    System.out.println();
                    System.out.println("\t\tError: debe ser 1 o 2...");
                    System.out.println();
                }
            }
        }
        catch(Exception e){
            System.out.println("- Error: digite un numero valido.");
        }
        return opcion;
    }

    public void cuenta(){
        System.out.println("------ TU CUENTA ------");
        System.out.println("- En esta pestana podras acceder a tu cuenta o crear una nueva.");  
    }

    public void mostrar_info(Usuario user){
        String[] info = user.get_info_usuario();
        System.out.println("- INFORMACION DE USUARIO -");
        System.out.println("Nombre: "+info[0]);
        System.out.println("Edad: "+info[1]);
        System.out.println("Genero: "+info[2]);
        System.out.println("Nivel: "+info[3]);
        System.out.println("Ocupacion: "+info[4]);
    }

    public String[] solicitar_datos_acceder_cuenta(){
        String[] datos = new String[2];
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("---- Iniciar sesion ----");
        System.out.println("- Para ingresar sesion debe de escribir su nombre de usuario y contrasena");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print("- Ingrese su nombre de usuario: ");
        String nombre = solicitar_string();
        System.out.print("- Ingrese su contrasena: ");
        String contrasena = solicitar_string();
        datos[0] = nombre;
        datos[1] = contrasena;
        return datos;
    }

    public int acceder_o_crear_usuario(){
        System.out.println();
        System.out.println("--- No tienes una sesion iniciada ---");
        System.out.println("- Crea una cuenta o inicia sesion con una cuenta existente.");
        System.out.println();
        System.out.print("Digita 1 para crear una cuenta o 2 para iniciar sesion: ");
        int desicion = solicitar_int(1, 2);
        return desicion;
    }

    public String solicitar_string(){
        String txt = "";
            boolean continuar = true;
            while(continuar){
                try{
                    this.sn = new Scanner(System.in);
                    String texto = sn.nextLine();
                    if(texto.equals("")){
                        System.out.println("\t Error: debe de ingresar un texto valido.");
                        System.out.println();
                    }
                    else{
                        txt = texto;
                        System.out.println("---------------------------------------------------------------------------------------------------------------------");
                        continuar = false;                   
                    }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un texto valido.");
                    System.out.println();
                }
            }
        return txt;
    }

    public int solicitar_int(int inferior, int superior){
        inferior -= 1;
        superior += 1;
        int entero = 0;
            boolean continuar = true;
            while(continuar){
                try{
                    this.sn = new Scanner(System.in);
                    int numero = sn.nextInt();
                    if((numero>inferior)&&(numero<superior)){
                        entero = numero;
                        System.out.println("---------------------------------------------------------------------------------------------------------------------");
                        continuar = false; 
                    }
                    else{
                        System.out.println("\t Error: debe de ingresar un entero valido.");                  
                        System.out.println();
                    }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero valido.");
                    System.out.println();
                }
            }       
        return entero;
    }

    public void usuario_creado_exito(){
        System.out.println();
        System.out.println("\t\tSu usuario ha sido creado con exito...");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public void volvinedo_al_menu(){
        System.out.println();
        System.out.println("\t\tVolviendo al Menu...");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public void inicio_sesion(boolean inicio_o_no){
        if(inicio_o_no){
            System.out.println();
            System.out.println("\t\tEXITO! se ha iniciado su sesion...");
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("\t\tLo sentimos, nombre o contrasena incorrectas...");
            System.out.println();
        }
    }
    
    public boolean volver_al_menu(){
        boolean regresar_al_menu = false;
        System.out.println();
        System.out.print("- Desea volver al menu? (si/no): ");
        String regresar = solicitar_string();
        System.out.println();
        regresar = regresar.toLowerCase();
        if(regresar.equals("si")){
            regresar_al_menu = true;
        }
        return regresar_al_menu;
    }

    public int mostrar_menu_usuario(Usuarios users){
        System.out.println();
        System.out.println("--- MENU DE USUARIO ---");
        System.out.println("- Bienvenido al menu de usuario.");
        System.out.println("- Aqui puedes ver o modificar tus datos de usuario.");
        System.out.println("- Tambien puedes cerrar sesion si asi lo deseas.");
        System.out.println();
        String[] info = users.get_usuario_actual().get_info_usuario();
        System.out.println("-- Informacion de usuario --");
        for(int k = 0; k<info.length ;k++){
            switch (k) {
                case 0:
                    System.out.print("Nombre: ");
                    break;

                case 1:
                    System.out.print("Edad: ");
                    break;

                case 2:
                    System.out.print("Genero: ");
                    break;

                case 3:
                    System.out.print("Nivel Educativo: ");
                    break;

                case 4:
                    System.out.print("Ocupacion: ");
                    break;

                default:
                    break;
            }
            System.out.println(info[k]);
        }
        System.out.println();
        System.out.println(" 1. Modificar datos de usuario.");
        System.out.println(" 2. Cerrar sesion.");
        System.out.println(" 3. Volver al menu.");
        System.out.print("\tIngrese su desision aqui: ");
        int desicion = solicitar_int(1, 3);
        return desicion;
    }


    public void cerrar_sesion(){
        System.out.println();
        System.out.println("- Cerrrando sesion...");
        System.out.println();
    }

    public void modificar_datos_usuario(){
        System.out.println();
        System.out.println("--- Modificar datos de tu cuenta! ---");
        System.out.println("- Para comenzar, danos tus nuevos datos...");
        System.out.println();
    }

    public void historial(ArrayList<String> historial){
        
        System.out.println("--- HISTORIAL ---");
        for(int k = (historial.size()-1); k>=0 ;k--){
            System.out.println(historial.get(k));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        volvinedo_al_menu();
    }

    //---------------------------------------------------------------------------

    public int biologia(){
        if(opcion2 == 1){
            Preguntas[] preguntas = {
                new Preguntas("1. Las mitocondrias son orgánulos celulares cuya función principal es:\n", new Respuestas[] {
                    new Respuestas("La Fotosintesis", 'a', false),
                    new Respuestas("La respiracion celular", 'b', true),
                    new Respuestas("La mitosis", 'c', false),
                    new Respuestas("La sistesis de proteinas", 'd', false)
                }),
                new Preguntas("2. La cromatina es:\n", new Respuestas[] {
                    new Respuestas("El componente esencial del nucleolo", 'a', false),
                    new Respuestas("Cada una de las partes de un cromosoma", 'b', false),
                    new Respuestas("Fibras de ARN asociadas a proteínas", 'c', false),
                    new Respuestas("Fibras de ADN empaquetadas con histonas", 'd', true)
                }),
                new Preguntas("3. Tanto las células vegetales como las animales contienen:\n", new Respuestas[] {
                    new Respuestas("Ribosomas, paredes celulares y mitocondrias", 'a', false),
                    new Respuestas("Aparato de Golgi, paredes celulares y ribosomas", 'b', false),
                    new Respuestas("Aparato de Golgi, ribosomas y mitocondrias", 'c', true),
                    new Respuestas("Cloroplastos, membranas celulares y mitocondrias", 'd', false)
                }),
                new Preguntas("4. Una característica esencial de la respiración celular es que:\n", new Respuestas[] {
                    new Respuestas("Siempre requiere oxígeno", 'a', false),
                    new Respuestas("Genera 2 ATP por molécula de glucosa", 'b', false),
                    new Respuestas("Sus productos finales son inorgánicos", 'c', true),
                    new Respuestas("A y C son correctas", 'd', false)
                }),
                new Preguntas("5. El reino Fungi y el reino Animal tienen en común las siguientes características:\n", new Respuestas[] {
                    new Respuestas("Son eucariotas y autótrofos", 'a', false),
                    new Respuestas("Son eucariotas y heterótrofos", 'b', true),
                    new Respuestas("Son procariotas y autótrofos", 'c', false),
                    new Respuestas("Son procariotas y heterótrofos", 'd', false)
                }),

            };

            for (Preguntas p: preguntas) {
                p.preguntar();
            }
        }
        return opcion2;
    }

    public int matematica(){
        if(opcion2 == 2){
            Preguntas[] preguntas = {
                new Preguntas("1. Las mitocondrias son orgánulos celulares cuya función principal es:\n", new Respuestas[] {
                    new Respuestas("La Fotosintesis", 'a', false),
                    new Respuestas("La respiracion celular", 'b', true),
                    new Respuestas("La mitosis", 'c', false),
                    new Respuestas("La sistesis de proteinas", 'd', false)
                }),
                new Preguntas("2. La cromatina es:\n", new Respuestas[] {
                    new Respuestas("El componente esencial del nucleolo", 'a', false),
                    new Respuestas("Cada una de las partes de un cromosoma", 'b', false),
                    new Respuestas("Fibras de ARN asociadas a proteínas", 'c', false),
                    new Respuestas("Fibras de ADN empaquetadas con histonas", 'd', true)
                }),
                new Preguntas("3. Tanto las células vegetales como las animales contienen:\n", new Respuestas[] {
                    new Respuestas("Ribosomas, paredes celulares y mitocondrias", 'a', false),
                    new Respuestas("Aparato de Golgi, paredes celulares y ribosomas", 'b', false),
                    new Respuestas("Aparato de Golgi, ribosomas y mitocondrias", 'c', true),
                    new Respuestas("Cloroplastos, membranas celulares y mitocondrias", 'd', false)
                }),
                new Preguntas("4. Una característica esencial de la respiración celular es que:\n", new Respuestas[] {
                    new Respuestas("Siempre requiere oxígeno", 'a', false),
                    new Respuestas("Genera 2 ATP por molécula de glucosa", 'b', true),
                    new Respuestas("Sus productos finales son inorgánicos", 'c', true),
                    new Respuestas("A y C son correctas", 'd', true)
                }),
                new Preguntas("5. El reino Fungi y el reino Animal tienen en común las siguientes características:\n", new Respuestas[] {
                    new Respuestas("Son eucariotas y autótrofos", 'a', false),
                    new Respuestas("Son eucariotas y heterótrofos", 'b', true),
                    new Respuestas("Son procariotas y autótrofos", 'c', false),
                    new Respuestas("Son procariotas y heterótrofos", 'd', false)
                }),

            };

            for (Preguntas p: preguntas) {
                p.preguntar();
            }
        }
        return opcion2;
    }

    public int fisica(){
        if(opcion2 == 3){
            Preguntas[] preguntas = {
                new Preguntas("1. Las mitocondrias son orgánulos celulares cuya función principal es:\n", new Respuestas[] {
                    new Respuestas("La Fotosintesis", 'a', false),
                    new Respuestas("La respiracion celular", 'b', true),
                    new Respuestas("La mitosis", 'c', false),
                    new Respuestas("La sistesis de proteinas", 'd', false)
                }),
                new Preguntas("2. La cromatina es:\n", new Respuestas[] {
                    new Respuestas("El componente esencial del nucleolo", 'a', false),
                    new Respuestas("Cada una de las partes de un cromosoma", 'b', false),
                    new Respuestas("Fibras de ARN asociadas a proteínas", 'c', false),
                    new Respuestas("Fibras de ADN empaquetadas con histonas", 'd', true)
                }),
                new Preguntas("3. Tanto las células vegetales como las animales contienen:\n", new Respuestas[] {
                    new Respuestas("Ribosomas, paredes celulares y mitocondrias", 'a', false),
                    new Respuestas("Aparato de Golgi, paredes celulares y ribosomas", 'b', false),
                    new Respuestas("Aparato de Golgi, ribosomas y mitocondrias", 'c', true),
                    new Respuestas("Cloroplastos, membranas celulares y mitocondrias", 'd', false)
                }),
                new Preguntas("4. Una característica esencial de la respiración celular es que:\n", new Respuestas[] {
                    new Respuestas("Siempre requiere oxígeno", 'a', false),
                    new Respuestas("Genera 2 ATP por molécula de glucosa", 'b', true),
                    new Respuestas("Sus productos finales son inorgánicos", 'c', true),
                    new Respuestas("A y C son correctas", 'd', true)
                }),
                new Preguntas("5. El reino Fungi y el reino Animal tienen en común las siguientes características:\n", new Respuestas[] {
                    new Respuestas("Son eucariotas y autótrofos", 'a', false),
                    new Respuestas("Son eucariotas y heterótrofos", 'b', true),
                    new Respuestas("Son procariotas y autótrofos", 'c', false),
                    new Respuestas("Son procariotas y heterótrofos", 'd', false)
                }),

            };

            for (Preguntas p: preguntas) {
                p.preguntar();
            }
        }
        return opcion2;
    }

    public int lenguaje(){
        if(opcion2 == 4){
            Preguntas[] preguntas = {
                new Preguntas("1. Pedro le dice a Tadeo si quiere desayunar huevo, ¿quien es el receptor?\n", new Respuestas[] {
                    new Respuestas("Pedro", 'a', false),
                    new Respuestas("Los dos", 'b', false),
                    new Respuestas("Tadeo", 'c', true),
                    new Respuestas("El huevo", 'd', false)
                }),
                new Preguntas("2. Juana va con su madre y le dice que si puede apagar la television. ¿Cual es el canal?\n", new Respuestas[] {
                    new Respuestas("La television", 'a', false),
                    new Respuestas("La madre de Juana", 'b', false),
                    new Respuestas("Juana", 'c', false),
                    new Respuestas("La voz", 'd', true)
                }),
                new Preguntas("3. ¿Que tipo de palabra segun su acentuacion es <<Cargador>>\n", new Respuestas[] {
                    new Respuestas("Aguda", 'a', true),
                    new Respuestas("Grave", 'b', false),
                    new Respuestas("Esdrujula", 'c', false),
                    new Respuestas("Sobreesdrujula", 'd', false)
                }),
                new Preguntas("4. ¿Que tipo de palabra segun su acentuacion es <<Helado>>\n", new Respuestas[] {
                    new Respuestas("Aguda", 'a', false),
                    new Respuestas("Grave", 'b', true),
                    new Respuestas("Esdrujula", 'c', false),
                    new Respuestas("Sobreesdrujula", 'd', false)
                }),
                new Preguntas("5. ¿En que estan relacionadas las barreras fisicas?\n", new Respuestas[] {
                    new Respuestas("La psicologia", 'a', false),
                    new Respuestas("Loa muros", 'b', false),
                    new Respuestas("El entorno en el que emisor y receptor se encuentran", 'c', true),
                    new Respuestas("Ninguna de las anteriores", 'd', false)
                }),

            };

            for (Preguntas p: preguntas) {
                p.preguntar();
            }
        }
        return opcion2;
    }
}