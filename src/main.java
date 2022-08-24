/**
 * @author 333-333-333
 */
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
    }

    public static void mostrarColeccion(String[][] librero) {
        System.out.println("Mostrando la colección: ");
        for (String[] espacio : librero) {
            if (hayLibro(espacio)) {
                imprimirLibro(espacio);
            }
        }
    }




    public static String[][] agregarLibro(String[][] librero) {
        if (totalEspacios(librero)!=0) {
            for (int i = 0; i < librero.length; i++) {
                if (!hayLibro(librero[i])) {
                    librero[i] = crearLibro();
                    break;
                }
            }
        } else {
            System.out.println("Librero lleno, no se puede agregar otro libro.");
        }
        return librero;
    }

    public static void mostrarTotalEspacios(String[][] librero) {
        System.out.println("Hay un total de " + totalEspacios(librero) + " espacios disponibles en el librero.");
    }

    public static int totalEspacios(String[][] librero) {
        int totalEspacios = 0;
        for (String[] espacio : librero) {
            if (!hayLibro(espacio)) {
                totalEspacios++;
            }
        }
        return totalEspacios;
    }

    public static void mostrarTotalLibros(String[][] librero) {
        System.out.println("Hay un total de " + totalLibros(librero) + " libros.");
    }

    public static int totalLibros(String[][] librero) {
        int totalLibros = 0;
        for (String[] espacio : librero) {
            if (hayLibro(espacio)) {
                totalLibros++;
            }
        }
        return totalLibros;
    }

    public static boolean hayLibro(String[] espacio){
        return (espacio[0] != null);
    }

    public static void imprimirLibrero(String[][] librero) {
        for (String[] libro : librero) {
            imprimirLibro(libro);
        }
    }

    public static void imprimirLibro(String[] libro) {
        System.out.println("Nombre : " + libro[0] + ", Autor : " + libro[1] + ", Editorial: " + libro[2]);
    }

    public static String[] crearLibro() {
        String[] libro = new String[3];

        System.out.println("¿Cuál es el nombre del libro?");
        libro[0] = validarTexto(); // Índice reservado para el nombre.

        System.out.println("¿Cuál es el autor del libro?");
        libro[1] = validarTexto(); // Índice reservado para el autor.

        System.out.println("¿Cuál es la editorial del libro?");
        libro[2] = validarTexto(); // Índice reservado para la editorial;

        return libro;
    }

    public static String[][] crearLibrero() {
        return new String[100][3];
    }

    public static String validarTexto() {
        Scanner input = new Scanner(System.in);
        String texto = input.nextLine();
        return ((texto != "") ? texto : validarTexto());
    }

    public static int validarOpcion(int cotaInferior, int cotaSuperior) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Seleccione una opción entre " + cotaInferior + " y " + cotaSuperior);
            int opcion = input.nextInt();
            if ((opcion >= cotaInferior) && (opcion <= cotaSuperior)){
                return opcion;
            } else {
                input.nextLine();
                return validarOpcion(cotaInferior,cotaSuperior);
            }
        } catch (Exception e) {
            input.nextLine();
            return validarOpcion(cotaInferior, cotaSuperior);
        }
    }
    
}
