/**
 * @author 333-333-333
 */

import java.util.Objects;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        /* El ejercicio plantea el requerimiento de almacenar 100 libros (Primera dimensión del arreglo).
         Cada libro tiene 3 datos (Segúnda dimensión): Nombre [0], Autor [1] y Editorial [2] */
         String[][] librero = new String[100][3];

         menuGeneral(librero);
    }

    public static void menuGeneral(String[][] librero) {
        boolean main = true;

        System.out.println("""
                ¿Qué deseas hacer?
                [1] Agregar libro \n[2] Buscar libro
                [3] Mostrar espacios usados \n[4] Mostrar espacios dispobibles
                [5] Mostrar la colección. \n[6] Salir""");
        switch (validarOpcion(1,6)) {
            case 1 -> agregarLibro(librero);
            case 2 -> buscarPorAutor(librero);
            case 3 -> mostrarTotalLibros(librero);
            case 4 -> mostrarTotalEspacios(librero);
            case 5 -> mostrarColeccion(librero);
            case 6 -> main = false;
            default -> System.out.println("No se reconoce la opción, inténtalo nuevamente.");
        }

        if (main) {
            menuGeneral(librero);
        }
    }

    public static void buscarPorAutor(String[][] librero) {
        if (totalLibros(librero) != 0) {
            int coincidencias = 0;
            System.out.println("¿Cuál es el autor que deseas buscar?");
            String autor = validarTexto();

            for (String[] espacio : librero) {
                if (hayLibro(espacio) && Objects.equals(espacio[1], autor)) {
                        coincidencias++;
                        imprimirLibro(espacio);
                }
            }

            System.out.println("Total de coincidencias: " + coincidencias);
        } else {
            System.out.println("No hay libros para buscar.");
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

    public static void mostrarColeccion(String[][] librero) {
        if (totalLibros(librero) != 0) {
            for (String[] espacio : librero) {
                System.out.println("Mostrando la colección: ");
                if (hayLibro(espacio)) {
                    imprimirLibro(espacio);
                }
            }
        } else {
            System.out.println("No hay colección.");
        }
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

    public static void imprimirLibro(String[] libro) {
        System.out.println("Nombre : " + libro[0] + ", Autor : " + libro[1] + ", Editorial: " + libro[2]);
    }

    public static String[] crearLibro() {
        String[] libro = new String[3]; // 3 Variables: Nombre, autor y editorial.

        System.out.println("¿Cuál es el nombre del libro?");
        libro[0] = validarTexto(); // Índice reservado para el nombre.
        System.out.println("¿Cuál es el autor del libro?");
        libro[1] = validarTexto(); // Índice reservado para el autor.
        System.out.println("¿Cuál es la editorial del libro?");
        libro[2] = validarTexto(); // Índice reservado para la editorial;

        return libro;
    }

    public static String validarTexto() {
        Scanner input = new Scanner(System.in);
        String texto = input.nextLine();
        return ((!Objects.equals(texto, "")) ? texto : validarTexto());
    }

    public static int validarOpcion(int cotaInferior, int cotaSuperior) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Seleccione una opción entre " + cotaInferior + " y " + cotaSuperior);
            int opcion = input.nextInt();

            if ((opcion >= cotaInferior) && (opcion <= cotaSuperior)){
                return opcion;
            } else {
                input.nextLine(); //Para evitar el error del Scanner, que no actualiza las variables insertadas.
                return validarOpcion(cotaInferior, cotaSuperior);
            }

        } catch (Exception e) {
            input.nextLine(); //Para evitar el error del Scanner, que no actualiza las variables insertadas.
            return validarOpcion(cotaInferior, cotaSuperior);
        }
    }

}
