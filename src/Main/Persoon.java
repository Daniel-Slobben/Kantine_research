package Main;

/**
 * Klasse Main.Persoon
 * Het doel van deze klasse is om een Main.Persoon object te maken.
 * @author: Daniël Slobben, Tobias Schlichter
 * @version: 01/12/2014
 */
public class Persoon
{
    private String bsn;
    private String voornaam;
    private String achternaam;
    private int dag;
    private int maand;
    private int jaar;
    private char geslacht;    
    private Dienblad dienblad;    
    private Betaalwijze betaalwijze;
    
    /**
     * constructor met parameters
     * Geboortedatum in cijfers, zonder 0.
     * Geslacht moet 'm' voor man zijn en 'v' voor vrouw.
     */
    public Persoon(String bsn, String voornaam, String achternaam, int dag, int maand, int jaar, char geslacht)
    {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;         
        setPersoongeboortedatum(dag, maand, jaar);
        setGeslacht(geslacht);    
        dienblad = null;
        betaalwijze = null;
    }    
    
    /**
     * parameterloze constructor
     */
    public Persoon()
    {
        bsn = "";
        voornaam = "";
        achternaam = "";
        setPersoongeboortedatum(0, 0, 0);
        setGeslacht('o');
        dienblad = null;
        betaalwijze = null;
    }
    
    /**
     * set Main.Betaalwijze
     * @param String om te kijken welke betaalwijze moet worden geset. 
     */
    public void setBetaalwijze(String betaalwijze)
    {
        if (betaalwijze.equals("contant"))
        {
            this.betaalwijze = new Contant();
        }
        else if (betaalwijze.equals("pinpas"))
        {
            this.betaalwijze = new Pinpas();
        }            
    }
    
    /**
     * getter betaalwijze
     */
    public Betaalwijze getBetaalwijze()
    {        
        return this.betaalwijze;
    }
    
    
    /**
     * override equals
     */
    public boolean equals(Persoon persoon)
    {
        if (persoon.getbsn() == this.getbsn())
        {
            return true;
        }
        else 
        {
            return false;
        }          
    }
    
    /**
     * Simuleert het pakken van een dienblad.
     */
    public void pakDienblad() 
    {
        if (dienblad == null)
        {
            dienblad = new Dienblad();
        }
    }   

    /**
     * Methode om artikel te pakken en te plaatsen op het dienblad
     * @param artikel
     */
    public void pakArtikel(Artikel artikel)
    {
        if (dienblad == null)
        {            
        }
        else
        {
            dienblad.voegToe(artikel);
        }
        
    }
    
    /**
     * methode om een dienblad te returnen
     */
    public Dienblad getDienblad()
    {
        return dienblad;
    }

    /**
     * Setter BurgerServiceNummer
     */
    public void setPersoonbsn(String bsn)
    {
        this.bsn = bsn;
    }
    
    /**
     * Setter voornaam
     */
    public void setPersoonvoornaam(String voornaam)
    {
        this.voornaam = voornaam;
    }
    
    /**
     * Setter achternaam
     */
    public void setPersoonachternaam(String achternaam)
    {
        this.achternaam = achternaam;
    }
    
    /**
     * Test of de ingevoerde jaartal een schrikkeljaar is.
     */
    private boolean isSchrikkel(int testJaar)
    {
        boolean schrikkeljaar = false;       
        if (testJaar % 4 == 0)
        {  
	        if (testJaar % 100 == 0)
	        {
		        if (testJaar % 400 == 0)
		        {
		            schrikkeljaar = true;
		        }
		        else
		        {
		            schrikkeljaar = false;
	            }
	        }
            else
            {
                schrikkeljaar = true;
            }
        }
        else 
        {
            schrikkeljaar = false;
        } 
        return schrikkeljaar;
    } 
    
    /**
     * Setter Geboortedatum
     */
    public void setPersoongeboortedatum(int testDag, int testMaand, int testJaar)
    {
        boolean test = true;
        if (testDag < 1)
        {            
            test = false;            
        }
        
        if (testMaand > 12 || testMaand < 1)
        {
            test = false;
        }
        
        if(testJaar < 1900 || testJaar > 2100)
        {
            test = false;
        }        
                
        switch(testMaand)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
               if (testDag > 31)
               {
                   test = false;
               }
               break;
           
            case 4:
            case 6:
            case 9:
            case 11:
               if (testDag > 30)
               {
                   test = false;
                }
                break;
                
            case 2:
               if (isSchrikkel(jaar) == false)
               {
                   if(testDag > 28)
                   {
                       test = false;
                   }
               }
               if(isSchrikkel(jaar) == true)
               {
                   if(testDag > 29)
                   {
                       test = false;
                   }                   
               }
               break;                
        }

        if (test = true)
        {
            dag = testDag;
            maand = testMaand;
            jaar = testJaar;
        }
        else 
        {
            dag = 0;
            maand = 0;
            jaar = 0;
            System.out.println("U heeft uw geboortedatum niet juist ingevoerd.");
        }
    }
    
    /**
     * Setter geslacht
     * 
     * Gebruik 'm' voor man en 'v' voor vrouw
     */
    public void setGeslacht(char geslacht)
    {
        if (geslacht == 'm' || geslacht == 'v')
        {
            this.geslacht = geslacht;
        }
        if (geslacht == 'o')
        {
            this.geslacht = 'o';
        }
        
        if (geslacht == 'm' || geslacht == 'v' || geslacht == 'o')
        {
        }
        else
        {
            System.out.println("U heeft de waarde niet juist ingevult, gebruik 'm' of 'v' !");
            this.geslacht = 'o';
        }                         
    }
    
    /**
     * Getter BSN
     */
    public String getbsn()
    {
        String onbekend = "onbekend";
        if (bsn == "")
        {
            return onbekend;
        }        
        return bsn;
    }
    
    /**
     * Getter voornaam
     */
    public String getVoornaam()
    {
        String onbekend = "onbekend";
        if (voornaam == "")
        {
            return onbekend;
        }        
        return voornaam;
    }
    
    /**
     * Getter achternaam
     */
    public String getAchternaam()
    {        
        String onbekend = "onbekend";
        if (achternaam == "")
        {
            return onbekend;
        }        
        return achternaam;
    }
    
    /**
     * Getter Geboortedatum
     */
    public String getGeboorteDatum() 
    {
        String temp;
        if (dag==0 && maand==0 && jaar==0) 
        {
             temp="Onbekend";
        } 
        else  
        {
            temp=dag+"/"+maand+"/"+jaar;
        }
        return temp;
    }
    
    /**
     * Getter geslacht
     */  
    public String getGeslacht()
    {
        String stringgeslacht = "";
        if (geslacht == 'm')
        {
            stringgeslacht = "Man";
        }
        else if (geslacht == 'v')
        {
            stringgeslacht = "Vrouw";
        }
        else 
        {
            stringgeslacht = "Onbekend";
        }
        return stringgeslacht;
    }
        
    /**
     * Laat alle velden van het object zien in de terminal
     */
    public String toString()
    {
        String toReturn = "";
        toReturn = toReturn + "BSN : " + getbsn() + ".\n";
        toReturn = toReturn + "Voornaam : " + getVoornaam() + ".\n";
        toReturn = toReturn + "Achternaam : " + getAchternaam() + ".\n";
        toReturn = toReturn + "Geboortedatum : " + getGeboorteDatum() + ".\n";
        toReturn = toReturn + "Geslacht: " + getGeslacht() + ".\n"; 
        return toReturn;
    }
}
    
