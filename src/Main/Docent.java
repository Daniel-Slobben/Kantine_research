package Main;

/**
 * Klasse Main.Docent
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    private String afkorting;
    private String afdeling;

    /**
     * constructor
     */
    public Docent(String afkorting, String afdeling)
    {
        super();
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    
    /**
     * parameterloze constructor
     */
    public Docent()
    {
        afkorting = "";
        afdeling = "";
    }
    
    /**
     * geeft kortingspercentage
     */
    public double getKortingsPercentage()
    {
        return 25.0;
    }
    
    /**
     * returned true als er een maximum aan de hoeveelheid korting is.
     */
    public boolean heeftMaximum()
    {
        return true;
    }
    
    public double getMaximum()
    {
        return 1.00;
    }    

    /**
     * Getter afdeling
     */
    public String getAfdeling()
    {        
        if (afdeling == "")
        {
            return "Onbekend";
        }
        else
        {
            return afdeling;
        }
    }
    
    /**
     * getter afkorting
     */
    public String getAfkorting()
    {
        if (afkorting == "")
        {
            return "Onbekend";
        }
        else
        {
            return afkorting;
        }
    }
    
    /**
     * setter afdeling
     */
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    /**
     * setter afkorting
     */
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    /**
     * Drukt alle gegevens van de persoon af
     */
    public String toString()
    {
        String toReturn = super.toString();
        toReturn = toReturn + "afkorting : " + getAfkorting() + ".\n";
        toReturn = toReturn + "afdeling : " + getAfdeling() + ".\n";
        return toReturn;
    }
}
