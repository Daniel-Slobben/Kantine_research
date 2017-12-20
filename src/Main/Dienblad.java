package Main;

import java.util.*;

/**
 * Het doel van deze klasse is om een dienblad te simuleren waarop een klant artikelen kan plaatsen
 * 
 */
public class Dienblad {    
    private Stack<Artikel> artikelen;

    /**
     * Constructor Main.Dienblad.
     */
    public Dienblad() 
    {
      artikelen = new Stack<Artikel>();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     * @param artikel
     */
    public void voegToe(Artikel artikel) 
    {
        artikelen.add(artikel);
    }
  
    /**
     * Methode om een Iterator<Main.Artikel> te returnen
     */
    public Iterator<Artikel> getArtikelLijst()
    {
        Iterator iteratorArtikelen = artikelen.iterator();
        return iteratorArtikelen;
    } 
}
