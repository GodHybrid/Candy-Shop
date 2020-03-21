import java.io.BufferedReader;
import java.io.InputStreamReader;

import Sweets.*;

public class QuickStart
{
    private static CustomBox giftBox;

    public static void main(String[] args) 
    {
        var _main = new QuickStart();
        System.out.println("Welcome to the Sweets Shop. Feel at home.\n\n");
        System.out.print("You have the following options:\n\t1) Create a random gift box;\n\t2) Start making your own gift box;\n\t" +
                            "3) Exit;\n\nEnter your desired option:\n>> ");
        int option = Integer.parseInt(System.console().readLine());
        switch(option)
        {
            case 1: giftBox = new CustomBox().MakeRandom();
                    break;
            case 2: _main.Customize();
                    break;
            case 3: return;
            default:
        }
    }

    private void Customize() 
    {
        System.out.print("Congratulations on starting your delicious gift box! Now you can customize it further.\n\t1) Add another candy;\n\t2) Remove some candies;\n\t" +
                            "3) See detailed information;\n\t4) Optimize your gift;\n\t5) Finalize making your gift;\n\nEnter your desired option:\n>> ");
        int option = Integer.parseInt(System.console().readLine());
        switch(option)
        {
            case 1: if(giftBox == null) giftBox = new CustomBox();
                    giftBox.Add();
                    break;
            case 2: if(giftBox != null) giftBox.Remove();
                    else System.out.println("Your gift box is empty.");
                    break;
            case 3: if(giftBox != null) SeeDetails();
                    else System.out.println("Your gift box is empty.");
                    break;
            case 4: if(giftBox != null) giftBox.Optimize();
                    else System.out.println("Your gift box is empty.");
                    break;
            case 5: System.out.print("Have a good day, farewell!");
                    return;
            default: break;
        }
        Customize();
    }

    private void SeeDetails() 
    {
        System.out.print("1) Total weight;\n2) Total price;\n3) See the list of all candies;\n4) Finish inspecting;\n>> ");
        int option = Integer.parseInt(System.console().readLine());
        switch(option)
        {
            case 1: System.out.println("Total weight: " + giftBox.OutAndReWeight() + " g.\n");
                    break;
            case 2: System.out.println("Total price: " + giftBox.OutAndRePrice() + " rub.\n");
                    break;
            case 3: giftBox.OutFullInfo();
                    break;
            case 4: return;
            default: break;
        }
        SeeDetails();
    }
}