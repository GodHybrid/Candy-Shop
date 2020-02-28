import Sweets.Sweets_abs;

public interface IMysteryBox
{
    void Add(Sweets_abs addition);
    void RemoveAt(int index);
    void RemoveLast();
    float getWeightTotal();
    float getPriceTotal();
    void OutFullInfo();
}