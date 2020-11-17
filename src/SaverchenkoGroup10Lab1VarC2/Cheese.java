package SaverchenkoGroup10Lab1VarC2;

public class Cheese extends Food {

    private int calories = 70;

    public Cheese() { super("Сыр"); };

    public void consume() { System.out.println(this.toString()+" съеден");}

    public int calculateCalories() { return calories; }
}
