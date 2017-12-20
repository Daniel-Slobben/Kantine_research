package Main;

public interface KortingskaartHouder
{
    // methode om kortingspercentage op te vragen
    public double getKortingsPercentage();
    
    // methode om op te vragen of er maximum per keer aan de korting zit    
    public boolean heeftMaximum();
    
    // methode om het maximum kortingsbedrag op te vragen
    public double getMaximum();
}