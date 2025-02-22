import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.
import java.util.Scanner;
import javax.swing.*;
import java.util.List;

class Empresa {

    private String nombre;
    private String sector;
    private String correo;
    private Stand stand;
    private int id;

    public  Empresa (String nombre, String sector, String correo, int id, Stand stand){
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
        this.id = id;
        this.stand = stand;
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
    private List<Comentario> comentarios = new ArrayList<>(); // Colección para almacenar datos de tipo string -> Comentarios.
    private String nombreEmpresa;

    public Stand (int id, String ubicacion, String size){

        this.ubicacion = ubicacion;
        this.size = size;
        this.id = id;
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

class Consultor {
    private List<Empresa> listEmpresa = new ArrayList<>();
    private List<Visitante> listVisitante = new ArrayList<>();
    private List<Stand> listStands = new ArrayList<>();

    public Consultor(){
        int idStand = 0;
        String[] ubicationFeria = {"Ala Oeste", "Ala Norte", "Ale Este"};
        String[] sizeStand = {"pequeño", "mediano", "grande"};

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++){
                    listStands.add(new Stand(idStand, ubicationFeria[i], sizeStand[j]));
                    idStand++;
                }
            }
        }
    }

    public void add_object(Empresa object){

        listEmpresa.add(object);
        System.out.println("Empresa " + object.getNombre() + " agregada");
        }

    public  void add_object(Visitante object){

        listVisitante.add(object);
        System.out.println("Visitante " + object.getNombre() + " agregado");
    }

    public void add_object(Stand object){

        listStands.add(object);
        System.out.println("Stand " + object.getId() + " agregado");

    }

    public void get_list(int identifier){
        switch (identifier){
            case 0:
                for (Empresa empresa: listEmpresa){
                    System.out.println("Empresa: " + empresa.getNombre() + "- Sector: " + empresa.getSector());
                }
                break;

            case 1:
                for (Visitante visitante: listVisitante){
                    System.out.println("Visitante: " + visitante.getNombre());
                }
                break;

            case 2:
                for (Stand stand: listStands){
                    if (stand.isDisponible()) {
                        System.out.println("Stand: [" + stand.getId() + "] con ubicación " + stand.getUbicacion() +
                                " y tamaño " + stand.getSize());
                    };
                }
                break;

            default:
                System.out.println("Identificador no válido.");
        }
    }

    public Stand getStand(int idStand){
        return listStands.get(idStand);
    }
}

class Menu {
    private  Scanner scanner;
    private Consultor consultor;
    private int id_empresas = 0;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.consultor = new Consultor();
    }

    public void mostrarMenu() {
        int option;

        System.out.println("Proyecto de Ferial Empresarial: ");

        do {
            System.out.println("Menu de la Feria Empresarial:\n" +
                    "[1] Registro de Empresa\n" +
                    "[2] Creación de Visitante\n" +
                    "[3] Ver Empresas\n" +
                    "[4] Ver Visitantes\n" +
                    "[5] Ver Estantes\n" +
                    "[6] Finalizar programa.\n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introduce el nombre de la empresa: \n");
                    String nombreEmpresa = scanner.next();
                    System.out.println("Introduce el nombre del sector al que pertenece la empresa: \n");
                    String sectorEmpresa = scanner.next();
                    System.out.println("Introduce el correo de la empresa: \n");
                    String correoEmpresa = scanner.next();

                    System.out.println("Elige un stand para tu empresa:");

                    Empresa empresa;

                    while (true) {
                        consultor.get_list(2);
                        int option_stand = scanner.nextInt();
                        Stand standChoose = consultor.getStand(option_stand);

                        if (standChoose.isDisponible()) {
                            empresa = new Empresa(nombreEmpresa, sectorEmpresa, correoEmpresa, id_empresas, standChoose);
                            break;
                        } else {
                            System.out.println("Elige un stand disponible \n");
                        }
                    }

                    id_empresas += 1;

                    consultor.add_object(empresa);
                    System.out.println("Empresa creada con éxito \n");
                    break;

                case 2:
                    String nombreVisitante = JOptionPane.showInputDialog(null, "Ingrese su nombre");
                    String idVisitante = JOptionPane.showInputDialog(null, "Ingrese su número de identificación");
                    String correoVisitante = JOptionPane.showInputDialog(null, "Ingrese su correo");

                    Visitante visitante = new Visitante(nombreVisitante, idVisitante, correoVisitante);
                    consultor.add_object(visitante);
                    break;
                case 3:
                    consultor.get_list(0);
                    break;

                case 4:
                    consultor.get_list(1);
                    break;
                case 5:
                    consultor.get_list(2);
                    break;
                case 6:
                    break;
            }
        }while (option != 6);
    }
}

public class Feria {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();

        System.out.println("Finalización del programa");
    }

}
