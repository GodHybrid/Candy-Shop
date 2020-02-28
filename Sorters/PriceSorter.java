package Sorters;

import java.util.Comparator;
import Sweets.Sweets_abs;

public class PriceSorter implements Comparator<Sweets_abs> 
{
    public int compare(Sweets_abs candy1, Sweets_abs candy2) 
    {
        return Float.compare(candy2.getPrice(), candy1.getPrice());
    }
}