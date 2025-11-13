package Practica5;
import java.util.Scanner;
import java.util.InputMismatchException;

import Practica5.PE05_Comandes_Restaurant;

public class PE05_Comandes_Restaurant {
    
    //Variables globals
    Scanner e = new Scanner(System.in);
    String comanda = "";
    String nomClient = "";
    double totalSenseIVA = 0.0;
    final double iva= 0.10;

     public static void main(String[] args) {
        PE05_Comandes_Restaurant p = new PE05_Comandes_Restaurant();
        p.inici();
    }
    public void inici() {
        int opcio = 0;
        do {
            try {
                System.out.println("\n_______________________________________");
                System.out.println("===== Gestió comandes restaurant ======");
                System.out.println("_______________________________________");
                System.out.println("1. Crear nova comanda");
                System.out.println("2. Actualitzar comanda anterior");
                System.out.println("3. Visualitzar últim tiquet");
                System.out.println("4. Sortir");
                System.out.println("Tria una opció: ");
                opcio = e.nextInt();

                switch (opcio) {
                    case 1:
                        novaComanda();
                    break;
                    case 2:
                        actualitzarComanda();
                    break;
                    case 3:
                        mostrarTiquet();
                    break;
                    case 4:
                        System.out.println("Sortint del programa...");
                    break;
                    default:
                        System.out.println("Opció no valida.")
                }

            } catch (InputMismatchException e) {
               System.out.println("Error: introdueix un número vàlid!");
               e.nextLine();
            }
        } while (opcio != 4);

        e.close();
    }

    public void novaComanda() {
        System.out.println("\n=========== Nova Comanda ===========");
        e.nextLine();
        System.out.println("Nom del client: ");
        nomClient = e.nextLine();

        comanda = "";
        totalSenseIVA = 0.0;

        introduirProductes();
        mostrarTiquet();
        System.out.println("Comanda enregistrada correctament");
    }

    public void actualitzarComanda() {
        if (nomClient.isEmpty()) {
            System.out.println("No hi ha cap comanda enregistrada...");
            return;
        }

        System.out.println("======= Actualitzar comanda =======");
        introduirProductes();
        mostrarTiquet();
        System.out.println("Comanda actualitzada correctament!");
    }

    













































}
