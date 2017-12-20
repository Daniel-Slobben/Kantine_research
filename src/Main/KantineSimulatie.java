package Main;

import java.util.*;
import java.math.*;

public class KantineSimulatie {    
    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;
    
    private int aantalArtikelen;

    /**
     * Constructor
     */
    public KantineSimulatie()
    {
        kantine = new Kantine();
        random = new Random();
        kantineaanbod=new KantineAanbod(); 
        kantine.setKantineAanbod(kantineaanbod);
        aantalArtikelen = 0;
    }   
        
    /**
     * methode om een artikel toe te voegen aan het assortiment
     */
    public void voegArtikelToe(Artikel artikel, int hoeveelheid)
    {
        ArrayList<Artikel> artikelen = new ArrayList<>();
        kantine.getKantineAanbod().getAanbod().put(artikel.getArtikelnaam(), artikelen);
        for(int i = 0 ; i <hoeveelheid ; i++)
        {
            artikelen.add(new Artikel(artikel.getArtikelnaam(), artikel.getArtikelPrijs()));
        }
        aantalArtikelen++;        
    }
    
    /**
     * Methode om een array van random getallen liggend tussen min en max 
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) 
    {
        int[] tempNumber=new int[lengte];
        for(int i=0;i<lengte;i++) 
        {
            tempNumber[i]=getRandomValue(min, max);
        }
        return tempNumber;
    }

    /**
     * Methode om een random getal tussen min(incl) en 
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) 
    {
        return random.nextInt(max-min+1)+min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array 
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen, String[] namen) {
        String[] artikelen=new String[indexen.length];
        for(int i=0;i<indexen.length;i++) 
        { 
            artikelen[i]=namen[indexen[i]];
        }
        return artikelen;
    }
    
    /**
     * Maakt een persoon aan met 
     * willekeurig een Main.Student, Main.Docent of Kantinemederwerker
     * betaalwijze of contant of pinpas
     * saldo tussen de 6 en de 300 euro
     */
    private Persoon getPersoon()
    {
        int welkeKlant = random.nextInt(100);
        welkeKlant++;                
        Persoon persoon = null;
        if (welkeKlant > 0 && welkeKlant <= 89)
        {
            persoon = new Student();
        }                  
        if (welkeKlant > 89 && welkeKlant <= 99)
        {
            persoon = new Docent();
        }                      
        if (welkeKlant == 100)
        {
            persoon = new KantineMedewerker();
        }
        persoon.pakDienblad();
        if (random.nextInt(1) == 0)
        {
            persoon.setBetaalwijze("contant");
        }
        else 
        {
            persoon.setBetaalwijze("pinpas");
        }           
        
        persoon.getBetaalwijze().setSaldo(getRandomValue(2, 300));
        return persoon;
    }

    /**
     * Deze methode simuleert een aantal dagen in het 
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) 
    {
        double[] totaalDagOmzet = new double[dagen];
        int[] totaalDagArtikelen = new int[dagen];
        // for lus voor dagen
        for(int i=0;i<dagen;i++) 
        {            
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // laat de personen maar komen...
            for(int j=0;j<aantalpersonen;j++) 
            {
                // maak persoon en dienblad aan, koppel ze
                // bedenk hoeveel artikelen worden gepakt
              
                Persoon persoon = getPersoon();               

                // genereer de “artikelnummers”, dit zijn indexen 
                // van de artikelnamen array  
                int[] tepakken=getRandomArray(random.nextInt(aantalArtikelen), 0, (aantalArtikelen - 1));

                // vind de artikelnamen op basis van 
                // de indexen hierboven
                String [] artikelen = kantine.getKantineAanbod().getAanbod().keySet().toArray(new String[aantalArtikelen]);
                
                String[] artikelenMetNaam=geefArtikelNamen(tepakken, artikelen);
                kantine.loopPakSluitAan(persoon, artikelen);
                
                // System.out.println(persoon.toString());

                // loop de kantine binnen, pak de gewenste 
                // artikelen, sluit aan
            }       
        
            kantineaanbod.checkToResupply();
            kantine.verwerkRijVoorKassa();
        
            Kassa kassa = kantine.getKassa();
        
            double dagGeldTotaal = kassa.hoeveelheidGeldInKassa();
            int dagKlanten = kassa.aantalKlanten();
            int dagAantalArtikelen = kassa.aantalArtikelen();
        
            String dagGeldTotaalAfgerond = String.format("%.2f", dagGeldTotaal);
        
            int dag = i+1;
        
            kassa.resetKassa();
            System.out.println("Dag: " + dag + " " + "Aantal klanten vewerkt: " + dagKlanten + ". Dagtotaal : €" + dagGeldTotaalAfgerond);
            // verwerk rij voor de kassaloopPakSluitAan
            // druk de dagtotalen af en hoeveel personen binnen 
            // zijn gekomen
            // reset de kassa voor de volgende dag
      
            totaalDagOmzet[i] = dagGeldTotaal;
            totaalDagArtikelen[i] = dagAantalArtikelen;
        }        
           
        double[] omzetPerDag = Administratie.berekenDagOmzet(totaalDagOmzet);
        int indexOmzetPerDag = 0;
        for (double omzet : omzetPerDag)
        { 
            double omzetPerDagAfgerond = new BigDecimal(omzetPerDag[indexOmzetPerDag]).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println(getDay(indexOmzetPerDag) + " : € " + omzetPerDagAfgerond);
            indexOmzetPerDag++;
        }
    
        System.out.println("Gemiddeld aantal artikelen op een dag: " + new BigDecimal(Administratie.berekenGemiddeldAantal(totaalDagArtikelen)).setScale(2, RoundingMode.HALF_UP).doubleValue());    
        System.out.println("Gemiddelde omzet op een dag: € " + new BigDecimal(Administratie.berekenGemiddeldeOmzet(totaalDagOmzet)).setScale(2, RoundingMode.HALF_UP).doubleValue());
   
    }
    
    /**
     * Methode om dag van de week te bereken
     * Maandag is 0;
     */
    private String getDay(int dag)
    {
        switch (dag)
        {            
            case 0:
                return "maandag";
            
            case 1:
                return "dinsdag";
            
            case 2:
                return "woensdag";
            
            case 3:
                return "donderdag";
            
            case 4:
                return "vrijdag";
            
            case 5:
                return "zaterdag";
            
            case 6:
                return "zondag";
            
            default:
                return "onbekend";
        }
    }

}
