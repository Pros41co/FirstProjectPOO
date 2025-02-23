import java.util.ArrayList; // Paquete con la clase Array para generar una colección de datos.
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;



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

    public String getNombre()   {return nombre;}

    public String getSector()   {return sector;}

    public String getCorreo()   {return correo; }

    public int getId()  {return id; }

    public Stand getStand()    {return stand; }

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
    private boolean conComentario = false;
    private List<Comentario> comentarios = new ArrayList<>(); // Colección para almacenar datos de tipo string -> Comentarios.
    private String nombreEmpresa = null;


    public Stand (int id, String ubicacion, String size){

        this.ubicacion = ubicacion;
        this.size = size;
        this.id = id;
    }

    public void addComentario(Comentario comentario){
        comentarios.add(comentario);
        conComentario = true;
    }

    public void consultarComentarios(){
        System.out.println("Consultando comentarios");
        for (Comentario comentario: comentarios){
            System.out.println("Comentario: " + comentario.getTexto());
            comentario.getTexto();
            System.out.println("Calificación: " + comentario.getCalificacion());
        }
    }

    public void consultarCalificacion(){
        if (conComentario){
            int calificacion = 0;
            int cantidadCalifacion = 0;
            for (Comentario comentario: comentarios){
                calificacion += comentario.getCalificacion();
                cantidadCalifacion ++;
            }
            System.out.println(calificacion/cantidadCalifacion);
        }
        else{
            System.out.println(0);
        }
    }

    public boolean isConComentario(){return conComentario;}

    // Getters
    public int getId()  { return id; }
    public String getUbicacion()    { return ubicacion; }
    public String getSize()     { return size; }
    public boolean isDisponible()   { return disponibilidad; }
    public String getEmpresa() {return nombreEmpresa;};

    // Setters
    public void setUbicacion(String ubicacion)  { this.ubicacion = ubicacion; }
    public void setSize(String size)    { this.size = size; }
    public void setDisponibilidad(boolean disponibilidad)   { this.disponibilidad = disponibilidad; }
    public void setNombreEmpresa(String nombreEmpresa){ this.nombreEmpresa = nombreEmpresa;};
}

class Comentario {
    private String texto;
    private int calificacion;

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
    private boolean empresaescrita = false;
    private boolean visitanteescrito = false;

    public Consultor(){
        int idStand = 0;
        String[] ubicationFeria = {"Ala Oeste", "Ala Norte", "Ala Este"};
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

    public void addObject(Empresa object){

        listEmpresa.add(object);
        System.out.println("Empresa " + object.getNombre() + " agregada");
        empresaescrita = true;
        }


    public  void addObject(Visitante object){

        listVisitante.add(object);
        System.out.println("Visitante " + object.getNombre() + " agregado");
        visitanteescrito = true;
    }

    public void addObject(Stand object){

        listStands.add(object);
        System.out.println("Stand " + object.getId() + " agregado");

    }

    public void showAllStand(){
        for (Stand stand: listStands){
                System.out.println("Stand: [" + stand.getId() + "] con ubicación " + stand.getUbicacion() +
                        " y tamaño " + stand.getSize());
                if (stand.isDisponible()){
                    System.out.println(ColoresConsola.GREEN + "[DISPONIBLE]" + ColoresConsola.RESET);
                }
                else{
                    System.out.println(ColoresConsola.RED + "[OCUPADO]" + ColoresConsola.RESET);
                }
                if (stand.isConComentario()){
                    System.out.println(ColoresConsola.YELLOW + "Calificación promedio" + ColoresConsola.RESET);
                    stand.consultarCalificacion();
                }
            System.out.println("-------------------------------------------------------------------\n");
        }
    }

    public void showListStand(boolean disponible){
        if (disponible){
            for (Stand stand: listStands){
                if (stand.isDisponible())
                    System.out.println("Stand: [" + stand.getId() + "] con ubicación " + stand.getUbicacion() +
                            " y tamaño " + stand.getSize());
            }
        }else {
            for (Stand stand : listStands) {
                if (!stand.isDisponible()) {
                    System.out.println("Stand: [" + stand.getId() + "] con ubicación " + stand.getUbicacion() +
                            " y tamaño " + stand.getSize());
                }
            }
        }
    }


    public void showListVisitante(){
        for (Visitante visitante: listVisitante){
            System.out.println("Visitante: " + visitante.getNombre() + " identificado con [" + visitante.getIdentificacion() + "]");
        }
    }

    public void showListEmpresa(){
        for (Empresa empresa: listEmpresa){
            System.out.println("Empresa: " + empresa.getNombre() + " - Sector: " + empresa.getSector() + " [ID: " + empresa.getId() + "]");
        }
    }

    public void eliminarVisitante(String identificacion){
        listVisitante.remove(getVisitante(identificacion));
    }

    public void eliminarEmpresa(int id){
        listEmpresa.remove(getEmpresa(id));
    }

    public void editarVisitante(Visitante visitante, String nombre){
        visitante.setNombre(nombre);
    }

    public Visitante getVisitante(String identificacion){
        for (Visitante visitante: listVisitante){
            if (visitante.getIdentificacion().equals(identificacion)){
                return visitante;
            }
        }
        return null;
    }

    public Empresa getEmpresa(int id){
        for (Empresa empresa: listEmpresa){
            if (empresa.getId() == id){
                return empresa;
            }
        }
        return null;
    }

    public Stand getStand(int idStand){
        return listStands.get(idStand);
    }

    public boolean getEmpresaEscrita(){return empresaescrita;}
    public boolean getVisitanteEscrito(){return visitanteescrito;}

}

class AdministratorMenu {
    private  Scanner scanner;
    protected Consultor consultor;
    private int id_empresas = 0;

    public AdministratorMenu(Consultor consult, Scanner scann) {
        this.scanner = scann;
        this.consultor = consult;
    }

    private void crearEmpresa() {
        System.out.println("Introduce el nombre de la empresa: \n");
        String nombreEmpresa = scanner.next();
        scanner.nextLine();
        System.out.println("Introduce el nombre del sector al que pertenece la empresa: \n");
        String sectorEmpresa = scanner.next();
        scanner.nextLine();
        System.out.println("Introduce el correo de la empresa: \n");
        String correoEmpresa = scanner.next();
        scanner.nextLine();

        System.out.println("Elige un stand para tu empresa:");

        Empresa empresa;

        while (true) {
            consultor.showListStand(true);
            int option_stand = scanner.nextInt();
            Stand standChoose = consultor.getStand(option_stand);

            if (standChoose.isDisponible()) {
                standChoose.setNombreEmpresa(nombreEmpresa);
                standChoose.setDisponibilidad(false);
                empresa = new Empresa(nombreEmpresa, sectorEmpresa, correoEmpresa, id_empresas, standChoose);
                break;
            } else {
                System.out.println("Elige un stand disponible \n");
            }
        }


        id_empresas += 1;

        consultor.addObject(empresa);
        System.out.println(ColoresConsola.GREEN +  "Empresa con id [" + empresa.getId() + "]" + " creada con éxito \n" + ColoresConsola.RESET);

    }

    protected Visitante crearVisitante() {
        System.out.println("Ingresa tu nombre: ");
        String nombreVisitante = scanner.next();
        System.out.println("Ingresa tu número de identificación: ");
        String idVisitante = scanner.next();
        System.out.println("Ingresa tu correo electrónico");
        String correoVisitante = scanner.next();
        Visitante visitante = new Visitante(nombreVisitante, idVisitante, correoVisitante);
        consultor.addObject(visitante);

        return visitante;
    }

    private void menuAdminEmpresa(){
        Empresa seleccionempresa = null;
        int option;
        do {
            System.out.println("Bienvenido al menú de Admministrador para Empresas. Selecciona una opción:\n");
            if (seleccionempresa != null){
                System.out.println(ColoresConsola.GREEN + "----- Empresa [" + seleccionempresa.getNombre() +" - " +
                        seleccionempresa.getId() + "] seleccionado -----" +  ColoresConsola.RESET);
            }else{
                System.out.println(ColoresConsola.RED + "----- Empresa [SIN SELECCIONAR] ----- " +  ColoresConsola.RESET);
            }
            System.out.println(ColoresConsola.CYAN + "[1]" + ColoresConsola.RESET + "Ver Todas las Empresas");
            System.out.println(ColoresConsola.CYAN + "[2]" + ColoresConsola.RESET + "Seleccionar Empresa para Modificar");
            if (seleccionempresa!= null){
                System.out.println(ColoresConsola.CYAN + "[3]" + ColoresConsola.RESET + "Eliminar una Empresa");
                System.out.println(ColoresConsola.CYAN + "[4]" + ColoresConsola.RESET + "Ver Correo de la Empresa");
                System.out.println(ColoresConsola.CYAN + "[5]" + ColoresConsola.RESET + "Deseleccionar Empresa");
                System.out.println(ColoresConsola.CYAN + "[6]" + ColoresConsola.RESET + "Consultar comentarios empresa");
            }
            System.out.println(ColoresConsola.CYAN + "[7]" + ColoresConsola.RESET + "Salir del menú de Empresas");

            try{
                option = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce una opción válida. [Número del 1 al 7]");
                option = 8;
            }


            switch (option){
                case 1:
                    consultor.showListEmpresa();
                    break;
                case 2:
                    int id;
                    System.out.println("Introduce el número de identificación de la Empresa");
                    id = scanner.nextInt();
                    seleccionempresa = consultor.getEmpresa(id);
                    if (seleccionempresa!=null){
                        System.out.println(ColoresConsola.GREEN +"Empresa [" + seleccionempresa.getNombre() + "] seleccionada exitosamente."
                                + ColoresConsola.RESET);
                    }
                    else{
                        System.out.println(ColoresConsola.RED + "Empresa no encontrada" + ColoresConsola.RESET);
                    }
                    break;
                case 3:
                    if (seleccionempresa != null){
                        String optionSeleccion;
                        System.out.println("¿Seguro desea eliminar esta empresa [S/N]?");
                        optionSeleccion = scanner.next();
                        if (optionSeleccion.equals("S")){
                            seleccionempresa.getStand().setDisponibilidad(true);
                            seleccionempresa.getStand().setNombreEmpresa(null);
                            consultor.eliminarEmpresa(seleccionempresa.getId());

                            seleccionempresa = null;
                            System.out.println("Empresa eliminada con éxito");
                        }else{
                            System.out.println("No hay una Empresa seleccionada");
                        }
                    }
                    break;
                case 4:
                    if (seleccionempresa != null){
                        System.out.println("Correo de la Empresa: " + seleccionempresa.getCorreo());
                    }
                    else{
                        System.out.println("No hay una Empresa seleccionada");
                    }
                    break;
                case 5:
                    System.out.println("Deseleccionando a la Emprea:" + seleccionempresa.getNombre());
                    seleccionempresa = null;
                    break;
                case 6:
                    if (seleccionempresa != null){
                        seleccionempresa.getStand().consultarComentarios();
                    }
                    else{
                        System.out.println("No hay una Empresa seleccionada");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida. (Sólo número del 1 al 6");
                    break;
            }
        }while (option!=7);
    }

    private void menuAdminVisitante(){
        Visitante seleccionvisitante = null;
        int option;
        do {
            System.out.println("Bienvenido al menú de Admministrador para visitantes. Selecciona una opción:\n");
            if (seleccionvisitante != null){
                System.out.println(ColoresConsola.GREEN + "----- Visitante [" + seleccionvisitante.getIdentificacion() +" - " +
                      seleccionvisitante.getNombre() + "] seleccionado -----" +  ColoresConsola.RESET);
            }else{
                System.out.println(ColoresConsola.RED + "----- Visitante [SIN SELECCIONAR] ----- " +  ColoresConsola.RESET);
            }
            System.out.println(ColoresConsola.CYAN + "[1]" + ColoresConsola.RESET + "Ver Todos los Visitantes");
            System.out.println(ColoresConsola.CYAN + "[2]" + ColoresConsola.RESET + "Seleccionar Visitante para Modificar");
            System.out.println(ColoresConsola.CYAN + "[3]" + ColoresConsola.RESET + "Eliminar un visitante");
            System.out.println(ColoresConsola.CYAN + "[4]" + ColoresConsola.RESET + "Ver Correo del Visitante");
            System.out.println(ColoresConsola.CYAN + "[5]" + ColoresConsola.RESET + "Editar Visitante");
            System.out.println(ColoresConsola.CYAN + "[6]" + ColoresConsola.RESET + "Deseleccionar visitante");
            System.out.println(ColoresConsola.CYAN + "[7]" + ColoresConsola.RESET + "Salir del menú de visitante");


            try{
                option = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Ingresa un número solamente.");
                scanner.nextLine();
                option = 7;
            }


            switch (option){
                case 1:
                    consultor.showListVisitante();
                    break;
                case 2:
                    String identificacion;
                    System.out.println("Introduce el número de identificación del visitante para seleccionarlo");
                    identificacion = scanner.next();
                    seleccionvisitante = consultor.getVisitante(identificacion);
                    if (seleccionvisitante!=null){
                        System.out.println(ColoresConsola.GREEN +"Visitante [" + seleccionvisitante.getNombre() + "] seleccionado exitosamente."
                        + ColoresConsola.RESET);
                    }
                    else{
                        System.out.println(ColoresConsola.RED + "Visitante no encontrado" + ColoresConsola.RESET);
                    }
                    break;
                case 3:
                    if (seleccionvisitante != null){
                        String optionSeleccion;
                        System.out.println("¿Seguro desea eliminar a este visitante [S/N]?");
                        optionSeleccion = scanner.next();
                        if (optionSeleccion.equals("S")){
                            consultor.eliminarVisitante(seleccionvisitante.getIdentificacion());
                            seleccionvisitante = null;
                            System.out.println("Usuario eliminado con éxito");
                        }else{
                            System.out.println("No hay un visitante seleccionado");
                        }
                    }
                    break;
                case 4:
                    if (seleccionvisitante != null){
                        System.out.println("Correo del visitante: " + seleccionvisitante.getCorreo());
                    }
                    else{
                        System.out.println("No hay un visitante seleccionado");
                    }
                    break;
                case 5:
                    if (seleccionvisitante!=null){
                        String nombre;
                        System.out.println("Coloca el nuevo nombre del visitante");
                        nombre = scanner.nextLine();
                        consultor.editarVisitante(seleccionvisitante, nombre);
                        System.out.println(ColoresConsola.GREEN + "Nombre del visitante cambiado con éxito" + ColoresConsola.RESET);
                    }
                case 6:
                    System.out.println("Deseleccionando al visitante:" + seleccionvisitante.getNombre());
                    seleccionvisitante = null;
                    break;
                default:
                    System.out.println("Ingresa una opción válida. (Número del 1 al 5)");
                    break;
            }
        }while (option!=7);
    }

    public void mostrarMenu() {
        int option;
        System.out.println(ColoresConsola.CYAN + "Proyecto de Feria Empresarial: \n " + ColoresConsola.RESET);

        do {
            System.out.println("Menu de la Feria Empresarial:\n" +
                    "[1] Registro de Empresa\n" +
                    "[2] Creación de Visitante\n" +
                    "[3] Menú de Empresas\n" +
                    "[4] Menú de Visitantes\n" +
                    "[5] Ver Estantes\n" +
                    "[6] Salir del menú de Administrador.\n");
            try{
                option = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Ingresa sólo un número válido [1-6]");
                scanner.nextLine();
                option = 7;
            }


            switch (option) {
                case 1:
                    crearEmpresa();
                    break;

                case 2:
                    crearVisitante();
                    break;
                case 3:
                    menuAdminEmpresa();
                    break;

                case 4:
                    menuAdminVisitante();
                    break;
                case 5:
                    consultor.showAllStand();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Ingresa una opción válida. (Sólo número del 1 al 6)");
                    break;
            }
        }while (option != 6);
    }
}

class UserMenu extends AdministratorMenu    {
    private Stand standActive = null;
    private Consultor consultor;
    private Scanner scanner;
    private Visitante visitante = null;

    public UserMenu(Consultor consultor, Scanner scanner){
        super(consultor, scanner);
        this.consultor = consultor;
        this.scanner = scanner;

    }

    private void escribirComentario(){
        System.out.println("Deja un comentario al Stand: " + ColoresConsola.PURPLE + standActive.getId() + ColoresConsola.RESET);
        String texto = scanner.nextLine();
        System.out.println("Deja una calificación entre 1 y 5:");
        int calificacion = 0;
        do {
            try{
                calificacion = scanner.nextInt();
                if (calificacion < 1 || calificacion > 5){
                    System.out.println("Coloca una calificación en el rango indicado");
                }else{
                    break;
                }
            }catch (Exception e){
                System.out.println("Coloca un número válido.");
                scanner.nextLine();
            }
        }while (true);



        Comentario comentario = new Comentario(texto, calificacion);
        standActive.addComentario(comentario);
        System.out.println(ColoresConsola.GREEN + "Agregado comentario al STAND [" + standActive.getId() + "] exitosamente" + ColoresConsola.RESET);
    }



    public void mostrarMenuUser(){

        int option;

        do{
            if(visitante != null){
                System.out.println(ColoresConsola.GREEN + "-----[" + visitante.getNombre() + "] logeado -----" + ColoresConsola.RESET);
            }
            else{
                System.out.println(ColoresConsola.RED + " -----[VISITANTE NO LOGEADO]-----" + ColoresConsola.RESET);
            }
            if (standActive != null){
                System.out.println(ColoresConsola.PURPLE + "Visitando el STAND [" + standActive.getId() + "]" + ColoresConsola.RESET);
            }

            System.out.println("Bienvenido al menú de usuario. Elige una opción:\n");
            System.out.println("[1] Registrarse");
            System.out.println("[2] Logearse");
            if (visitante!= null){
                System.out.println("[3] Visitar Stands");
            }
            if (standActive != null){
                System.out.println("[4] Dejar comentario en el stand activo [" + standActive.getId() + "]");
                System.out.println("[5] Ver comentarios del Stand activo");
            }
            System.out.println("[6] Salir del menú de usuario");

            try {
                option = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Ingresa sólo un número válido [1-5]");
                scanner.nextLine();
                option = 7;
            }


            switch (option){
                case 1:
                    visitante = crearVisitante();
                    break;
                case 2:
                    int intentos = 3;
                    if (consultor.getVisitanteEscrito()){
                        String identificacion;
                        do {
                            System.out.println("Coloca tu número de identificación:");
                            identificacion = scanner.next();
                            Visitante loginVisitante = consultor.getVisitante(identificacion);
                            if (loginVisitante != null){
                                visitante = loginVisitante;
                                System.out.println("Visitante: " + loginVisitante.getNombre() + "logeado.");
                            }else{
                                System.out.println("Visitante no encontrado.");
                                intentos --;
                            }
                        }while (visitante == null || intentos == 0);
                    }else{
                        System.out.println("No hay visitantes en este momento registrados.");
                    }
                    if (intentos == 0) {
                        System.out.println("Límite de intentos excedido.");
                    }
                    break;
                case 3:
                    if (consultor.getEmpresaEscrita()){
                        System.out.println("Selecciona el Stand que deseas visitar");
                        consultor.showListStand(false);
                        int standchoose = scanner.nextInt();
                        standActive = consultor.getStand(standchoose);
                        if (standActive.isDisponible()){
                            standActive = null;
                            System.out.println("Stand no disponible. Actualmente este Stand no cuenta con ninguna empresa");
                        }else{
                            System.out.println(ColoresConsola.GREEN + "Visitando el STAND [" + standActive.getId() + "]" + ColoresConsola.RESET);
                        }
                        scanner.nextLine();

                    }else{
                        System.out.println("Aún no hay Stands con empresas asignadas para visitar.");
                    }
                    break;
                case 4:
                    if (standActive != null){
                        escribirComentario();
                    }
                    else{
                        System.out.println("No se está visitando un Stand"  );
                    }

                    break;
                case 5:
                    if (standActive != null){
                        standActive.consultarComentarios();
                    }else{
                        System.out.println("No hay un stand seleccionado");
                    }
                    break;
                case 6:
                    if (visitante !=null){
                        visitante = null;
                    }
                    if (standActive != null){
                        standActive = null;
                    }
                    System.out.println("Saliendo del menú de usuario.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (option !=6);
    }
}


class ColoresConsola {
    public static final String RESET = "\u001B[0m";  // Resetear color
    public static final String RED = "\u001B[31m";   // Rojo
    public static final String GREEN = "\u001B[32m"; // Verde
    public static final String YELLOW = "\u001B[33m";// Amarillo
    public static final String BLUE = "\u001B[34m";  // Azul
    public static final String PURPLE = "\u001B[35m";// Morado
    public static final String CYAN = "\u001B[36m";  // Cian
}

public class Feria {
    public static void main(String[] args) {
        Consultor consultorMain = new Consultor();
        Scanner scanner = new Scanner(System.in);
        AdministratorMenu adminMenu = new AdministratorMenu(consultorMain, scanner);
        UserMenu userMenu = new UserMenu(consultorMain, scanner);

        int option;

        do {
            System.out.println(ColoresConsola.CYAN + "Proyecto de Feria Empresarial: \n " + ColoresConsola.RESET);

            System.out.println("Elige una opción");
            System.out.println(ColoresConsola.CYAN + "[1]" + ColoresConsola.RESET + "Panel de Usuario");
            System.out.println(ColoresConsola.CYAN + "[2]" + ColoresConsola.RESET + "Panel de administrador");
            System.out.println(ColoresConsola.CYAN + "[3]" + ColoresConsola.RESET + "Salir del programa");

            try{
                option = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Elige una opción válida. (Número del 1 al 3)");
                scanner.nextLine();
                option = 4;
            }

            switch (option){
                case 1:
                    userMenu.mostrarMenuUser();
                    break;
                case 2:
                    adminMenu.mostrarMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Selecciona una opción válida");
                    break;
            }
        }while (option != 3);

        System.out.println("Finalización del programa");
    }
}
