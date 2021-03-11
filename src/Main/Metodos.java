package Main;

import Clases.Persona;
import Clases.Vacuna;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Metodos {
    ArrayList<Persona> listapersonas = new ArrayList<Persona>();
    ArrayList<Vacuna> listavacunas = new ArrayList<Vacuna>();
    private int edad, num_vac_inyect = 0, vac_quedan;
    private String riesgo;
    private String nombre, apellidos, dni;
    private int opcionmenu;


    public void menu() {
        try {
            opcionmenu = Integer.parseInt(JOptionPane.showInputDialog("VACUNACIÓN COVID-19 EN ESPAÑA:\n1) Añadir persona.\n2) Listado de personas.\n3) Buscar persona.\n4) Información vacunas.\n5) Realizar cambios.\n6) Salir."));
            switch (opcionmenu) {
                case 1:
                    engadir();
                    break;
                case 2:
                    Listado();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    informacion();
                    break;
                case 5:
                    cambiar();
                    break;
            }


        } catch (NumberFormatException ex) {
        }
    }


    public void engadir() {

        setNombre(JOptionPane.showInputDialog("Nombre: "));
        setApellidos(JOptionPane.showInputDialog("Apellidos: "));
        setDni(JOptionPane.showInputDialog("DNI: "));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Edad: ")));
        setRiesgo(JOptionPane.showInputDialog("¿Es persona de riesgo (s/n)?: "));
        Persona obx = new Persona(nombre, apellidos, dni, edad, riesgo);

        listapersonas.add(obx);

    }


    public void Listado() {

        System.out.println("**** PERSONAS EN LA LISTA ****");
        for (int i = 0; i < listapersonas.size(); i++) {
            System.out.println(listapersonas.get(i).toString());
        }
        if (listapersonas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
        }

    }


    public void buscar() {if(listapersonas.isEmpty()){System.out.println("**** RESULTADO DE LA BUSQUEDA ****");System.out.println("No hay personas en la lista.");}else{
        String option = JOptionPane.showInputDialog("Elija un criterio de busqueda: \n- Nombre\n- Apellidos\n- DNI");
        switch (option.toLowerCase()) {
            case "nombre":
                String nombre = JOptionPane.showInputDialog("Nombre: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getNombre().equalsIgnoreCase(nombre)){

                    System.out.println(listapersonas.get(i).toString());}
                    else{System.out.println("No hay personas en la lista con ese nombre.");}

                }
                break;

            case "apellidos":
                String apellidos = JOptionPane.showInputDialog("Apellidos: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");

                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getApellidos().equalsIgnoreCase(apellidos)) {


                    System.out.println(listapersonas.get(i).toString()); }else{System.out.println("No hay personas en la lista con ese nombre.");}

                }
                break;

            case "dni":
                String dni = JOptionPane.showInputDialog("DNI: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getDni().equalsIgnoreCase(dni)){

                    System.out.println(listapersonas.get(i).toString());}
               else{System.out.println("No hay personas en la lista con ese nombre.");}
                }
                break;

        }}
    }

    public void informacion() {
        Vacuna obx1 = new Vacuna("Pfizer", 2, 100000, 20000);
        Vacuna obx2 = new Vacuna("Moderna", 2, 100000, 10000);
        Vacuna obx3 = new Vacuna("AstraZeneca/Oxford", 2, 100000, 50000);
        listavacunas.add(obx1);
        listavacunas.add(obx2);
        listavacunas.add(obx3);


        System.out.println("**** VACUNAS DISPONIBLES EN ESPAÑA ****");
        for (int i = 0; i < listavacunas.size(); i++) {
            System.out.println(listavacunas.get(i).toString());
        }


    }

    public void cambiar() {
        String option = JOptionPane.showInputDialog("¿Qué quiere cambiar?\n- Personas\n- Vacunas");
        switch (option.toLowerCase()) {
            case "personas":
                String option1 = JOptionPane.showInputDialog("¿Qué quiere cambiar?\n- Personas\n- Vacunas"); break;
            case "vacunas":
                String option2 = JOptionPane.showInputDialog("¿Qué quiere cambiar?\n- Nombre\n- Número de dosis\n- Vacunas disponibles\n- Vacunas administradas"); break;


        }


    }


    public int getOpcionmenu() {
        return opcionmenu;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNum_vac_inyect(int num_vac_inyect) {
        this.num_vac_inyect = num_vac_inyect;
    }

    public void setVac_quedan(int vac_quedan) {
        this.vac_quedan = vac_quedan;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
