package Main;

import java.util.LinkedList;

/**
 * simuleert de rij van de kassa
 */
public class KassaRij 
{     
    private  LinkedList<Persoon> personen;
    
    /**
     * Constructor Main.KassaRij
     */
    public KassaRij()
    {      
         personen = new  LinkedList<Persoon>();
    }

    /**
     * Main.Persoon sluit achter in de rij aan
     * @param persoon
     */
    public void sluitAchteraan(Persoon persoon) 
    {
        personen.add(persoon);   
    } 

    /**
     * Indien er een rij bestaat, de eerste Main.Persoon uit
     * de rij verwijderen en retourneren. 
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
    public Persoon eerstePersoonInRij() 
    {
        Persoon persoon = null;
        if (this.erIsEenRij() == true)
        {
            persoon = personen.get(0);          
            personen.remove(0);          
        }
        return persoon;
    }

    /**
     * Methode kijkt of er personen in de rij staan. 
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() 
    {
        boolean rij = true;
        if (personen.size() == 0)
        {
            rij = false;
        }
        return rij;
    }  
}

