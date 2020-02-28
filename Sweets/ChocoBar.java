package Sweets;

public class ChocoBar extends Sweets_abs
{
    private static float basePrice = 2.9f;
    private static float maxPrice = 10.6f;
    private static float baseWeight = 80.5f;
    private static float maxWeight = 142.8f;

    {
        Name = this.getClass().getSimpleName();
    }
    
    public ChocoBar()
    {
        Price = basePrice + (float)(Math.random() * (maxPrice - basePrice));
        Weight = baseWeight + (float)(Math.random() * (maxWeight - baseWeight));
        FlavorSetNew((int)(Math.random() * 3));
    }

    public ChocoBar(int flavorID, float price, float weight)
    {
        Price = price;
        Weight = weight;
        FlavorSetNew(flavorID);
    }

    public void FlavorSetNew(int newFlavor) 
    {
        switch(newFlavor)
        {
            case 0: Flavor_unq = "Black";
                    break;
            case 1: Flavor_unq = "White";
                    break;
            case 2: Flavor_unq = "Milky";
                    break;
            default: Flavor_unq = "Flavorless";
                    break;
        }
    }
}