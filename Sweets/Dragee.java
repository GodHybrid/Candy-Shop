package Sweets;

public class Dragee extends Sweets_abs
{
    private static float basePrice = 0.4f;
    private static float maxPrice = 1.2f;
    private static float baseWeight = 12.7f;
    private static float maxWeight = 24.1f;

    {
        Name = this.getClass().getSimpleName();
    }
    
    public Dragee()
    {
        Price = basePrice + (float)(Math.random() * (maxPrice - basePrice));
        Weight = baseWeight + (float)(Math.random() * (maxWeight - baseWeight));
        FlavorSetNew((int)(Math.random() * 4));
    }

    public Dragee(int flavorID, float price, float weight)
    {
        Price = price;
        Weight = weight;
        FlavorSetNew(flavorID);
    }

    public void FlavorSetNew(int newFlavor) 
    {
        switch(newFlavor)
        {
            case 0: Flavor_unq = "Random";
                    break;
            case 1: Flavor_unq = "Also random";
                    break;
            case 2: Flavor_unq = "Still random";
                    break;
            case 3: Flavor_unq = "Bertie Botts flavors (they're random)";
                    break;
            default: Flavor_unq = "Flavorless (but kinda random)";
                    break;
        }
    }
}