
package ryhma50;

import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    
    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }
    
    public void suorita() {
        while (true) {
            System.out.println("Millaisen viitteen haluat lisätä? (paina enter lopettaaksesi)");
            
            tulostaViitetyypit();
            String viitetyyppi = this.lukija.nextLine();
            if (viitetyyppi.isEmpty()) {
                break;
            }
            if (viitetyyppi.equals("1")) {
                suoritaKirja();
            }
        }
    }
    
    public void tulostaViitetyypit() {
        System.out.println("1 kirja");
    }
    
    public void suoritaKirja() {
        System.out.println("Anna kirjan kirjoittajat:");
        String kirjoittajat = this.lukija.nextLine();
        System.out.println("Anna kirjan nimi:");
        String nimi = this.lukija.nextLine();
        System.out.println("Anna kirjan julkaisuvuosi:");
        String julkaisuvuosi = this.lukija.nextLine();
        System.out.println("Anna kirjan julkaisija:");
        String julkaisija = this.lukija.nextLine();
        System.out.println("Viite lisätty!\n");
    }
}
