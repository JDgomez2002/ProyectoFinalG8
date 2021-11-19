import java.util.Scanner;

public class Preguntas {
    
    private String pregunta;
    private Respuestas[] respuestas;
    Scanner sn = new Scanner(System.in);
    char respuestaCorrecta = ' ';
    char letra;

    public Preguntas(String pregunta, Respuestas[] respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public void preguntar() {
        System.out.println(this.pregunta);
        for (Respuestas opcion: this.respuestas) {
            if (opcion.esCorrecta()) respuestaCorrecta = opcion.getLetra();
            System.out.print((opcion.getLetra()) + ") " + opcion.getRespuesta() + "\n");
        }
        System.out.println("\nDigite su respuesta: ");
        letra = sn.next().toLowerCase().charAt(0);
        if (letra == respuestaCorrecta)
            System.out.println("\nCorrecto\n");
        else
            System.out.println("\nIncorrecto, la respuesta correcta era " + respuestaCorrecta + "\n");
    }

}
