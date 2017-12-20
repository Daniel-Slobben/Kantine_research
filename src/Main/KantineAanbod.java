package Main;

import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private static final int BESTEL_NIVEAU = 250;
    private static final int NIVEAU_TOT_AANVULLEN = 1000;
    
    /**
     * constructor Main.KantineAanbod
     * geen artikelen
     */
    public KantineAanbod()
    {
        aanbod = new HashMap<>();
    }
    
    /**
     * methode om de voorraad naar het begin niveau te brengen     
     * Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    private void reSupply(String key) 
    {
        Artikel artikel = aanbod.get(key).get(0);
        System.out.println("Resupplied");
        for(int i = aanbod.get(key).size() ; i<= NIVEAU_TOT_AANVULLEN ; i++)
        {
            aanbod.get(key).add(new Artikel(artikel.getArtikelnaam(), artikel.getArtikelPrijs()));
        }
        
    }
    
    /**
     * methode om te kijken of er iets onders het bestelniveau komt
     */
    public void checkToResupply()
    {
        for(String key : aanbod.keySet())
        {
            if(aanbod.get(key).size()<BESTEL_NIVEAU)
            {
                reSupply(key);
            }
        }      
    }

    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
         return aanbod.get(productnaam); 
    }

    /**
     * Private methode om een Main.Artikel van de stapel artikelen af te pakken.
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel==null) { 
            return null;
        }
        if (stapel.size()==0)
        {           
           return null;
        }
        else 
        {            
            return stapel.remove(0);
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) {
        return getArtikel(getArrayList(naam));
    }
    
    public HashMap<String, ArrayList<Artikel>> getAanbod()
    {
        return aanbod;
    }
  
}
