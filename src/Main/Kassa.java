package Main;

import java.util.*;
/**
 * Simuleert de kassa
 */
public class Kassa 
{    
    private double kassaGeld;
    private int kassaArtikelen;
    private int aantalKlanten; 
    private KassaRij kassarij;
    
    /**
     * Constructor Main.Kassa   *
     */
    public Kassa(KassaRij kassarij) 
    {
        kassaGeld = 0;
        kassaArtikelen = 0;
        aantalKlanten = 0;
        this.kassarij = kassarij;
    }

    /**
     * vraag het aantal artikelen en de totaalprijs op.
     * De implementatie wordt later vervangen 
     * door een echte betaling door de persoon. 
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon) 
    {      
        boolean betaalGelukt = true;
        Dienblad dienblad  = persoon.getDienblad();      
        Betaalwijze betaalwijze = persoon.getBetaalwijze();
        aantalKlanten++;
        double teBetalen = 0.0;
        for (Iterator<Artikel> artikelen = dienblad.getArtikelLijst(); artikelen.hasNext();) 
        {
            Artikel artikel = artikelen.next();
            double artikelPrijs = artikel.getArtikelPrijs();
            kassaArtikelen++;
            
            teBetalen += artikelPrijs;
        }            
        if (persoon instanceof KortingskaartHouder)
        {
            double kortingsPercentage = ((KortingskaartHouder)persoon).getKortingsPercentage();            
            Double korting = (kortingsPercentage/100) * teBetalen;
        
            if (((KortingskaartHouder)persoon).heeftMaximum() == true)
            {
                if (korting > ((KortingskaartHouder)persoon).getMaximum())
                {
                    korting = ((KortingskaartHouder)persoon).getMaximum();
                }                 
            }
            
            teBetalen = teBetalen - korting;
        }
        try 
        {
            betaalwijze.betaal(teBetalen);
		}
	    catch (TeWeinigGeldException e) 
	    {
		    // Te weinig geld, betalen is dus niet gelukt.
		    System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " - " + e.getMessage());
		}
		if (betaalGelukt)
		{
		    kassaGeld += teBetalen;
		}
    }
    
  
    /**
     * Geeft het aantal klanten aan
     * dat de kassa heeft gepasseerd
     * vanaf het moment dat de methode resetWaarden
     * is Aangeroep
     * @return aantal klanten
     */
    public int aantalKlanten()
    {
        return aantalKlanten;
    }
       
    /**
     * Geeft het aantal artikelen dat de kassa 
     * heeft gepasseerd, 
     * vanaf het moment dat de methode resetWaarden 
     * is aangeroepen.
     * @return aantal artikelen
     */
    public int aantalArtikelen() 
    {
        return kassaArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     *resetKassa 
     * is aangeroepen.
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() 
    {
        return kassaGeld;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en 
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() 
    {
        kassaGeld = 0;
        kassaArtikelen = 0;
        aantalKlanten = 0;
    }
}