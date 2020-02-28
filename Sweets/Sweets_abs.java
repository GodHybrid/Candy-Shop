package Sweets;

public abstract class Sweets_abs
{
    protected String Name;
    protected float Weight;
    protected float Price;
    protected String Flavor_unq;

    public String getName()
    {
        return Name;
    }

    public String getUnique()
    {
        return Flavor_unq;
    }

    public float getPrice()
    {
        return Price;
    }

    public float getWeight()
    {
        return Weight;
    }

    public void WeightSetNew(float newWeight)
    {
        Weight = newWeight;
    }

    public void PriceSetNew(float newPrice)
    {
        Price = newPrice;
    }

    abstract void FlavorSetNew(int newFlavor);
}