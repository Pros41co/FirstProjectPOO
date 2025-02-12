import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.
import java.util.Scanner;

class Empresa {

    private String nombre;
    private String sector;
    private String correo;
    private Stand stand;
    private int id;

    public  Empresa (String nombre, String sector, String correo, int id){
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
        this.id = id;
    }

    // Getters
    public String getNombre()   {return nombre;}

    public String getSector()   {return sector;}

    public String getCorreo()   {return correo; }

    public int getId()  {return id; }

    public Stand getStand()    {return stand; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSector(String sector) { this.sector = sector; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setStand(Stand stand) { this.stand = stand; }


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

    // Getters
    public int getId()  { return id; }
    public String getUbicacion()    { return ubicacion; }
    public String getSize()     { return size; }
    public boolean isDisponible()   { return disponibilidad; }

    // Setters
    public void setUbicacion(String ubicacion)  { this.ubicacion = ubicacion; }
    public void setSize(String size)    { this.size = size; }
    public void setDisponibilidad(boolean disponibilidad)   { this.disponibilidad = disponibilidad; }

}

class Comentario {
    private String texto;
    private int calificacion;
    boolean info_visitante = false;

    public Comentario (String texto, int calificacion) {
        this.texto = texto;
        this.calificacion = calificacion;
    }

    // Getters
    public String getTexto()    { return texto; }
    public int getCalificacion()    { return calificacion; }

    // Setters
    public void setTexto(String texto)  { this.texto = texto; }
    public void setCalificacion(int calificacion)   { this.calificacion = calificacion; }
}

class Visitante {
    private String nombre;
    private String identificacion;
    private String correo;

    public Visitante(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
