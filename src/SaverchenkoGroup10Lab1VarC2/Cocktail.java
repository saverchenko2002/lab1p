package SaverchenkoGroup10Lab1VarC2;

public class Cocktail extends Food {

    private String fruit = null;
    private String drink = null;
    private int calories = 0;

    public Cocktail(String drink, String fruit) { super("Коктейль"); this.fruit=fruit; this.drink = drink; }

    public void consume() { System.out.println(this.toString()+" выпит"); }

    public int calculateCalories() {
        if (drink.equals("молочный") && fruit.equals("бананом"))
            calories=10;
        else if (drink.equals("шоколадный") && fruit.equals("клубникой"))
            calories = 30;
        else if (drink.equals("виноградный") && fruit.equals("киви"))
            calories = 20;
        return calories;
    }
    public String toString() { return super.toString()+" "+this.drink+" c "+this.fruit; }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (!(obj instanceof Cocktail)) return false;
            return (drink.equals(((Cocktail)obj).drink) && fruit.equals(((Cocktail)obj).fruit));
        } else return false;
    }

    public String getDrink() { return drink; }
    public String getFruit() { return fruit; }
    public void setDrink(String drink) { this.drink = drink; }
    public void setFruit(String fruit) { this.fruit = fruit; }
}
