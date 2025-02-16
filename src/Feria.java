import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.
import java.util.Scanner;
import javax.swing.*;

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

        // Almacen de empresas y visistantes
        ArrayList<Empresa> listEmpresa = new ArrayList<>();
        ArrayList<Visitante> listVisitante = new ArrayList<>();

        int id_empresas = 0;

        System.out.println("Proyecto de Ferial Empresarial: ");

        do {
            System.out.println("Menu de la Feria Empresarial:\n" +
                    "[1] Registro de Empresa\n" +
                    "[2] Creación de Visitante\n" +
                    "[3] Ver Empresas\n" +
                    "[4] Ver Visitantes\n" +
                    "[5] Ver Estantes\n" +
                    "[6] Finalizar programa.\n");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    String nombreEmpresa = JOptionPane.showInputDialog(null, "Ingrese el nombre de la empresa");
                    String sectorEmpresa = JOptionPane.showInputDialog(null, "Ingrese el sector al cual pertenece su empresa");
                    String correoEmpresa = JOptionPane.showInputDialog(null, "Ingrese el correo de su empresa");

                    Empresa empresa = new Empresa(nombreEmpresa, sectorEmpresa, correoEmpresa, id_empresas);
                    id_empresas += 1;

                    listEmpresa.add(empresa);

                    JOptionPane.showMessageDialog(null, "Empresa: " + empresa.getNombre() + " creada con éxito");
                    break;

                case 2:
                    String nombreVisitante = JOptionPane.showInputDialog(null, "Ingrese su nombre");
                    String idVisitante = JOptionPane.showInputDialog(null, "Ingrese su número de identificación");
                    String correoVisitante = JOptionPane.showInputDialog(null, "Ingrese su correo");

                    Visitante visitante = new Visitante(nombreVisitante, idVisitante, correoVisitante);
                    listVisitante.add(visitante);

                case 3:
                    for (int i = 0; i < listEmpresa.size(); i++){
                        System.out.println(i + " " + listEmpresa.get(i).getNombre());
                    }
                    break;

                case 6:
                    state_menu = false;
                    break;
            }

        }while (state_menu);

        System.out.println("Finalización del programa");


    }

}
