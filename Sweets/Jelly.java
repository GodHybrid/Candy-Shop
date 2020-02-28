package Sweets;

public class Jelly extends Sweets_abs
{
    private static float basePrice = 0.6f;
    private static float maxPrice = 1.4f;
    private static float baseWeight = 25.4f;
    private static float maxWeight = 76.4f;

    {
        Name = this.getClass().getSimpleName();
    }

    public Jelly()
    {
        Price = basePrice + (float)(Math.random() * (maxPrice - basePrice));
        Weight = baseWeight + (float)(Math.random() * (maxWeight - baseWeight));
        FlavorSetNew((int)(Math.random() * 3));
    }

    public Jelly(int flavorID, float price, float weight)
    {
        Price = price;
        Weight = weight;
        FlavorSetNew(flavorID);
    }

    public void FlavorSetNew(int flavorID) 
    {
        switch(flavorID)
        {
            case 0: Flavor_unq = "Strawberry";
                    break;
            case 1: Flavor_unq = "Blueberry";
                    break;
            case 2: Flavor_unq = "Lemon";
                    break;
            default: Flavor_unq = "Flavorless";
                    break;
        }
    }
}