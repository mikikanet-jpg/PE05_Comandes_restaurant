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
    final double IVA= 0.10;

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
                        System.out.println("______________________________________");
                        System.out.println("========== Fins La Propera! ==========");
                        System.out.println("______________________________________");
                    break;
                    default:
                        System.out.println("Opció no valida.");
                }

            } catch (InputMismatchException ex) {
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

    public void introduirProductes() {
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Introdueix el producte: ");
                String producte = e.next();

                System.out.println("Preu unitari ($): ");
                double preu = e.nextDouble();

                System.out.println("Quantitat: ");
                int quantitat= e.nextInt();

                double subtotal = preu * quantitat;
                totalSenseIVA += subtotal; //+= serveix per afegir contingut a una variable, sumant si és un número o concatenant text si és un String.
                comanda += String.format("%-15s %3d x %.2f$ = %.2f$\n", producte, quantitat, preu, subtotal);

                System.out.println("Vols afegir un altre producte? (s/n): ");
                continuar = e.next().equalsIgnoreCase("s");

            } catch (InputMismatchException ex) {
                System.out.println("Error: introdueix valors vàlids!");
                e.nextLine();
            }
        }
    }

    public void mostrarTiquet() {
        if (nomClient.isEmpty()) {
            System.out.println("No hi ha cap comanda enregistrada.");
            return;
        }

        double iva = totalSenseIVA * IVA;
        double total = totalSenseIVA + iva;

        System.out.println("\n ============== Tiquet ==============");
        System.out.println("Client " + nomClient);
        System.out.println("----------------------------------");
        System.out.println(comanda);
        System.out.println("----------------------------------");
        System.out.printf("Total sense IVA: %.2f$\n", totalSenseIVA);
        System.out.printf("IVA (10%%): %.2f$\n", iva);
        System.out.println("==================================");
    }
}
