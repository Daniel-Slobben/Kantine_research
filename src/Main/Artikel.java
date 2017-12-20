package Main;

/**
 * Main.Artikel
 * @author: Daniël Slobben, Tobias Schlichter
 */
public class Artikel
{
    private String naam;
    private double prijs;
    
    /**
     * Constructor Main.Artikel
     * String naamArtikel
     * int prijsArtikel
     */
    public Artikel(String naamArtikel, double prijsArtikel)
    {
        naam = naamArtikel;
        prijs = prijsArtikel;
    }
    
    /**
     * Setter van de naam
     */
    public void setArtikelnaam(String naamArtikel)
    {
        naam = naamArtikel;
    }
    
    /**
     * Getter van de naam
     */
    public String getArtikelnaam()
    {
        return naam;
    }
    
    /**
     * Setter van de prijs
     */
    public void setArtikelPrijs(double prijsArtikel)
    {
        prijs = prijsArtikel;
    }
    
    /**
     * Getter van de prijs
     */
    public double getArtikelPrijs()
    {
        return prijs;
    }
    
    /**
     * Laat alle velden van het object zien in de terminal
     */
    public void drukAf()
    {
        System.out.println("Naam van het artikel: " + getArtikelnaam());
        System.out.println("Prijs van het artikel: " + getArtikelPrijs());
    }
    
}
    
    