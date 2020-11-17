package SaverchenkoGroup10Lab1VarC2;

public class Apple extends Food {

    private String size = null;
    private int calories = 0;

    public Apple(String size) { super("Яблоко"); this.size=size; }

    public void consume() { System.out.println(this.toString()+" съедено"); }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String toString() { return super.toString()+" размера "+size; }

    public boolean equals(Object obj){
        if (super.equals(obj))
        {
            if (!(obj instanceof Apple)) return false;
            return size.equals(((Apple)obj).size);
        }
        else return false;
    }

    public int calculateCalories()
    {
        if (size.equals("большое")) calories = 15;
        else if (size.equals("среднее")) calories = 10;
        else if (size.equals("маленькое")) calories = 5;
        return calories;
    }
}
