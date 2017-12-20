package Main;

/**
 * Write a description of class Main.Testor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Testor
{
    public static void main(String[] args){
        KantineSimulatie kantineSimulatie = new KantineSimulatie();
        Artikel artikel1 = new Artikel("Pizza", 6.50);
        Artikel artikel2 = new Artikel("Bier", 2.20);
        Artikel artikel3 = new Artikel("Baco", 4.25);
        kantineSimulatie.voegArtikelToe(artikel1, 1000);
        kantineSimulatie.voegArtikelToe(artikel2, 1000);
        kantineSimulatie.voegArtikelToe(artikel3, 1000);
        kantineSimulatie.simuleer(400);
    }
    
}
