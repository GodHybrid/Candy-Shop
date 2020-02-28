package Sweets;

public class Caramel extends Sweets_abs
{
    private static float basePrice = 0.8f;
    private static float maxPrice = 2.7f;
    private static float baseWeight = 40.0f;
    private static float maxWeight = 70.2f;

    {
        Name = this.getClass().getSimpleName();
    }
    
    public Caramel()
    {
        Price = basePrice + (float)(Math.random() * (maxPrice - basePrice));
        Weight = baseWeight + (float)(Math.random() * (maxWeight - baseWeight));
        FlavorSetNew((int)(Math.random() * 3));
    }

    public Caramel(int flavorID, float price, float weight)
    {
        Price = price;
        Weight = weight;
        FlavorSetNew(flavorID);
    }

    public void FlavorSetNew(int newFlavor) 
    {
        switch(newFlavor)
        {
            case 0: Flavor_unq = "Gooseberry";
                    break;
            case 1: Flavor_unq = "Barberry";
                    break;
            case 2: Flavor_unq = "Apple";
                    break;
            default: Flavor_unq = "Flavorless";
                    break;
        }
    }
}