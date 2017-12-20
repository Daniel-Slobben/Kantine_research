package Main;

/**
 * simuleert een kantine 
 */
public class Kantine 
{
    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor Main.Kantine
     */
    public Kantine() {
      kassarij=new KassaRij();
      kassa=new Kassa(kassarij);
      kantineAanbod = null;
    }
  
    /**
     * Setter Main.KantineAanbod
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod)
    {      
        this.kantineAanbod = kantineAanbod;    
    }
  
    /**
     * Getter Main.KantineAanbod
     */
    public KantineAanbod getKantineAanbod()
    {
        return kantineAanbod;
    }
  
     /**
     * In deze methode kiest een Main.Persoon met een dienblad
     * de artikelen in artikelnamen.
     * @param persoon
     * @artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) 
    {      
         for (String artikelNaam: artikelnamen)
         {
             Artikel artikel = kantineAanbod.getArtikel(artikelNaam);
             Dienblad dienblad = persoon.getDienblad();
             dienblad.voegToe(artikel);
         }            
         kassarij.sluitAchteraan(persoon);      
    } 


    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        
        while(kassarij.erIsEenRij() == true) 
        {          
            Persoon persoon = kassarij.eerstePersoonInRij();  
            kassa.rekenAf(persoon);
        }
    }
  
    /**
     * Getter van de Main.Kassa
     */
    public Kassa getKassa()
    {
        return kassa;      
    }

}
