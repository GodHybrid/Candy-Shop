package Sorters;

import java.util.Comparator;
import Sweets.Sweets_abs;
 
public class NameSorter implements Comparator<Sweets_abs> 
{
    public int compare(Sweets_abs candy1, Sweets_abs candy2) 
    {
        return candy2.getName().compareToIgnoreCase(candy1.getName());
    }
}