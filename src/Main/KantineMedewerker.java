package Main;

/**
 * Klasse Main.KantineMedewerker
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private int medewerkersNummer;
    private boolean achterKassa;

    /**
     * Constructor
     */
    public KantineMedewerker(int medewerkersNummer, boolean achterKassa)
    {
        super();
        this.medewerkersNummer = medewerkersNummer;
        this.achterKassa = achterKassa;
    }
    
    /**
     * parameterloze constructor
     */
    public KantineMedewerker()
    {
        medewerkersNummer = 0;
        achterKassa = false;
    }    
    
    /**
     * geeft kortingspercentage
     */
    public double getKortingsPercentage()
    {
        return 35.0;
    }
    
    /**
     * returned true als er een maximum aan de hoeveelheid korting is.
     */
    public boolean heeftMaximum()
    {
        return false;
    }
    
    public double getMaximum()
    {
        return 0.00;
    }  
    
    /**
     * Getter medewerkersNummer
     */
    public int getMedewerkersNummer()
    {        
         return medewerkersNummer;
    }
    
    /**
     * getter studieRichting
     */
    public boolean getAchterKassa()
    {
        return achterKassa;
    }
    
    /**
     * setter medewerkersNummer
     */
    public void setMedewerkersNummer(int medewerkersNummer)
    {
        this.medewerkersNummer = medewerkersNummer;
    }
    
    /**
     * setter achterKassa
     */
    public void setAchterKassa(boolean achterKassa)
    {
        this.achterKassa = achterKassa;
    }
    
    /**
     * Drukt alle gegevens van de persoon af
     */
    public String toString()
    {
        String toReturn = super.toString();
        toReturn = toReturn + "medewerkersNummer : " + getMedewerkersNummer() + ".\n";
        toReturn = toReturn + "achterKassa : " + getAchterKassa() + ".\n";
        return toReturn;
    }
}
