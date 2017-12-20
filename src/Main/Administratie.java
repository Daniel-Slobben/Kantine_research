package Main;

public class Administratie {
    
    private static final int  DAYS_IN_WEEK = 7;
    
    private Administratie()
    {
    }
    
    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (DAYS_IN_WEEK elementen) met dagomzetten
     */
     public static double[] berekenDagOmzet(double[] omzet) 
     {
         double[] omzetPerDag = new double[DAYS_IN_WEEK];
         for(int i=0;i<DAYS_IN_WEEK;i++) {             
             int j=0;
             while((i+DAYS_IN_WEEK*j) < omzet.length)
             {
                  omzetPerDag[i] += omzet[i+DAYS_IN_WEEK*j];
                  j++;
             }
         }
         return omzetPerDag;
    }
        
    /**
    * Deze methode berekent van de int array aantal de 
    * gemiddelde waarde
    * @param aantal
    * @return het gemiddelde
    */
    public static double berekenGemiddeldAantal(int[] aantal) 
    {
        double totaal = 0;
        for (int dagArtikel : aantal)
        {
            totaal += dagArtikel;
        }
        double gemiddeld = totaal / aantal.length;
        return gemiddeld;
    }
    
    /**
    * Deze methode berekent van de double array omzet de 
    * gemiddelde waarde
    * @param omzet
    * @return Het gemiddelde
    */
    public static double berekenGemiddeldeOmzet(double[] omzet) 
    {
        double totaal = 0;
        for (double dagOmzet : omzet)
        {
            totaal += dagOmzet;
        }
        double gemiddeld = totaal / omzet.length;
        return gemiddeld;        
    }
}