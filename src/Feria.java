import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.
import java.util.Scanner;

class Empresa {

    private String nombre;
    private String sector;
    private String correo;
    private int id;
    private Stand stand;

    public  Empresa (String nombre, String sector, String correo, int id){
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
        this.id = id;
    }
}

class Stand {
    private int id;
    private String ubicacion;
    private String size;
    private boolean disponibilidad = true;
    private ArrayList<Comentario> comentarios = new ArrayList<>(); // Colección para almacenar datos de tipo string -> Comentarios.

    public Stand (int id, String ubicacion, String size){

        this.ubicacion = ubicacion;
        this.size = size;
    }

}

class Comentario {
    private String texto;
    private int calificacion;

    public Comentario (String texto, int calificacion) {
        this.texto = texto;
        this.calificacion = calificacion;
    }
}

public class Feria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean state_menu = true; // Variable que permite la repetición del menú.

        System.out.println("Proyecto de Ferial Empresarial: ");

        do {
            System.out.println("Menu de la Feria Empresarial:\n" +
                    "[1] Registro de Visitante\n" +
                    "[2] Creación de Empresa\n" +
                    "[3] Ver Empresas\n" +
                    "[4] Ver Visitantes\n" +
                    "[5] Ver Estantes\n" +
                    "[6] Finalizar programa.\n");

            int option = scanner.nextInt();

            if (option == 6){

                state_menu = false;

            }

        }while (state_menu);

        System.out.println("Finalización del programa");


    }

}
