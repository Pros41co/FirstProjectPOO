import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.

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

        boolean state_menu = true;

        System.out.println("Proyecto de Ferial Empresarial: ");



    }

}
