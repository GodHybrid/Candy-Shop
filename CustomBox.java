import java.util.ArrayList;
import Sweets.*;
import Sorters.*;

public class CustomBox implements IMysteryBox
{
    private ArrayList<Sweets_abs> sweetsSet = new ArrayList<>();
    private float totalWeight;
    private float totalPrice;

    public CustomBox()
    {
        totalWeight = 0f;
        totalPrice = 0f;
    }

    public CustomBox MakeRandom()
    {
        sweetsSet.clear();
        for (int i = 0; i < 50 ; i++)
        {
            int rand = (int)(Math.random() * 4);
            switch(rand)
            {
                case 0: Add(new Jelly());
                    break;
                case 1: Add(new ChocoBar());
                    break;
                case 2: Add(new Caramel());
                    break;
                case 3: Add(new Dragee());
                    break;
                default:
            }
        }
        return this;
    }

    ////////////////////////////////////Addition////////////////////////////////////////////////////////////

    public void Add(Sweets_abs addition) 
    {
        sweetsSet.add(addition);
    }

    public void Add()
    {
        System.out.print("Let's add another candy to your gift box! Which one will it be: 1 - Jelly, 2 - Caramel, 3 - Chocolate bar, 4 - Dragee\n>>");        
        int option = Integer.parseInt(System.console().readLine());
        System.out.print("\nWeight: ");
        float weight = Float.parseFloat(System.console().readLine());
        System.out.print("\nPrice: ");
        float price = Float.parseFloat(System.console().readLine());
        int rand = (int)(Math.random() * 4);
        switch(option)
        {
            case 1: Add(new Jelly(rand, price, weight));
                    break;
            case 2: Add(new ChocoBar(rand, price, weight));
                    break;
            case 3: Add(new Caramel(rand, price, weight));
                    break;
            case 4: Add(new Dragee(rand, price, weight));
                    break;
            default: Add();
        }
    }

    ////////////////////////////////////Removal////////////////////////////////////////////////////////////

    public void Remove()
    {
        System.out.print("Let's remove one of your candies.\n 1 - By number, 2 - By index, 3 - Last one\n>>");        
        int option = Integer.parseInt(System.console().readLine());
        switch(option)
        {
            case 1: System.out.print("\nNumber: ");
                    RemoveAt((Integer.parseInt(System.console().readLine())) - 1);
                    break;
            case 2: System.out.print("\nIndex: ");
                    RemoveAt(Integer.parseInt(System.console().readLine()));
                    break;
            case 3: RemoveLast();
                    break;
            default: Remove();
        }
    }

    public void RemoveAt(int index) 
    {
        if(!sweetsSet.isEmpty()) 
        {
            if(index < sweetsSet.size()) sweetsSet.remove(index);
            else System.out.println("\nWrong index.");
        }
        else System.out.println("The box is already empty.");
    }

    public void RemoveLast() 
    {
        RemoveAt(sweetsSet.size() - 1);
    }

    ////////////////////////////////////Information Delivery////////////////////////////////////////////////////////////

    public float getWeightTotal()
    {
        return totalWeight;
    }

    public float getPriceTotal()
    {
        return totalPrice;
    }

    public float OutAndReWeight() 
    {
        totalWeight = 0f;
        for (Sweets_abs n : sweetsSet) 
        {
            totalWeight += n.getWeight();
        }
        return totalWeight;
    }

    public float OutAndRePrice() 
    {
        totalPrice = 0f;
        for (Sweets_abs n : sweetsSet) 
        {
            totalPrice += n.getPrice();
        }
        return totalPrice;
    }

    public void OutFullInfo() 
    {
        for (Sweets_abs n : sweetsSet) 
        {
            System.out.println((sweetsSet.indexOf(n) + 1) + "\\ " + n.getName() + " (" + n.getUnique() + ") // " + (Math.round(n.getPrice() * 100f) / 100f) + 
                                " - " + (Math.round(n.getWeight() * 100f) / 100f) + "\n");
        }
    }

    ////////////////////////////////////Optimization////////////////////////////////////////////////////////////

    public void Optimize() 
    {
        System.out.print("We will lighten up your gift box so you can carry it away or afford it. What is your problem?\n" + 
                            "1) I am limited in my funds;\n2) My gift box is too heavy;\n3) My gift box is fine;\n>>");
        int option = Integer.parseInt(System.console().readLine());
        switch(option)
        {
            case 1: System.out.print("\nWhat is the maximum price you can afford? ");
                    sweetsSet.sort(new PriceSorter());
                    reducePrice((Float.parseFloat(System.console().readLine())));
                    break;
            case 2: System.out.print("\nWhat is the maximum weight you can carry? ");
                    sweetsSet.sort(new WeightSorter());
                    reduceWeight((Float.parseFloat(System.console().readLine())));
                    break;
            case 3: break;
            default: Remove();
        }
    }
    
    private void reduceWeight(double weight)
    {
        if(totalWeight < weight && weight > 0f) 
        {
            System.out.println("\nYour gift box is now light enough!");
            return;
        }
        else 
        {
            RemoveLast();
            OutAndReWeight();
            reduceWeight(weight);
        }
    }

    private void reducePrice(double price)
    {
        if(totalPrice < price && price > 0f) 
        {
            System.out.println("\nYou can now afford the gift box!");
            return;
        }
        else 
        {
            RemoveLast();
            OutAndRePrice();
            reducePrice(price);
        }
    }
}