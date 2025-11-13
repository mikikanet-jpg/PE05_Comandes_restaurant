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

    String reset = "\u001B[0m";
    String vermell = "\u001B[31m";
    String cian = "\u001B[36m";
    String groc = "\u001B[33m";

     public static void main(String[] args) {
        PE05_Comandes_Restaurant p = new PE05_Comandes_Restaurant();
        p.inici();
    }
    public void inici() {
        int opcio = 0;
        do {
            try {
                System.out.println(cian + "\n_______________________________________");
                System.out.println("===== Gestió comandes restaurant ======");
                System.out.println("_______________________________________");
                System.out.println("1. Crear nova comanda");
                System.out.println("2. Actualitzar comanda anterior");
                System.out.println("3. Visualitzar últim tiquet");
                System.out.println("4. Sortir");
                System.out.println("Tria una opció: " + reset);
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
                        System.out.println(groc + "______________________________________");
                        System.out.println("========== Fins La Propera! ==========");
                        System.out.println("______________________________________" + reset);
                    break;
                    default:
                        System.out.println(vermell + "Opció no valida." + reset);
                }

            } catch (InputMismatchException ex) {
               System.out.println(vermell + "Error: introdueix un número vàlid!" + reset);
               e.nextLine();
            }
        } while (opcio != 4);

        e.close();
    }

    public void novaComanda() {
        System.out.println(cian + "\n=========== Nova Comanda ===========" + reset);
        e.nextLine();
        System.out.println(cian + "Nom del client: " + reset);
        nomClient = e.nextLine();

        comanda = "";
        totalSenseIVA = 0.0;

        introduirProductes();
        mostrarTiquet();
        System.out.println(cian + "Comanda enregistrada correctament" + reset);
    }

    public void actualitzarComanda() {
        if (nomClient.isEmpty()) {
            System.out.println(vermell + "No hi ha cap comanda enregistrada..." + reset);
            return;
        }

        System.out.println(cian + "======= Actualitzar comanda =======" + reset);
        introduirProductes();
        mostrarTiquet();
        System.out.println(cian + "Comanda actualitzada correctament!" + reset);
    }

    public void introduirProductes() {
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println(cian + "Introdueix el producte: " + reset);
                String producte = e.nextLine();

                System.out.println(cian + "Preu unitari ($): " + reset);
                double preu = e.nextDouble();

                System.out.println(cian + "Quantitat: " + reset);
                int quantitat= e.nextInt();

                double subtotal = preu * quantitat;
                totalSenseIVA += subtotal; //+= serveix per afegir contingut a una variable, sumant si és un número o concatenant text si és un String.

                // Afegir espais fins a 17 caràcters amb un for
                 String linia = producte;
                for (int i = producte.length(); i < 17; i++) {
                linia += " ";
                }

                comanda += String.format("%-15s %-10d %-12.2f %-10.2f\n", producte, quantitat, preu, subtotal);

                e.nextLine(); 

                System.out.println(groc + "Vols afegir un altre producte? (s/n): " + reset );
                continuar = e.next().equalsIgnoreCase("s");

                e.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println(vermell + "Error: introdueix valors vàlids!" + reset);
                e.nextLine();
            }
        }
    }

    public void mostrarTiquet() {
        if (nomClient.isEmpty()) {
            System.out.println( vermell + "No hi ha cap comanda enregistrada..." + reset);
            return;
        }

        double iva = totalSenseIVA * IVA;
        double total = totalSenseIVA + iva;


    System.out.println(cian + "\n ============== Tiquet ==============");
    System.out.println("Client: " + nomClient);
    System.out.println("----------------------------------");
    System.out.println(comanda); 
    System.out.println("----------------------------------");
    System.out.printf("Total sense IVA: %.2f$\n", totalSenseIVA);
    System.out.printf("IVA (10%%): %.2f$\n", iva);
    System.out.printf("Total amb IVA: %.2f$\n", total);
    System.out.println("==================================" + reset);
    }
}
