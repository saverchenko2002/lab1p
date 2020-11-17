package SaverchenkoGroup10Lab1VarC2;

import java.util.Objects;

public abstract class Food implements  Nutritious,Consumable {

    private String name;

    public Food(String name) { this.name=name; }

    public String toString() { return name; }

    public boolean equals(Object obj) {
        if (!(obj instanceof Food)) return false;
        if (name == null || ((Food) obj).name == null) return false;
        return name.equals(((Food) obj).name);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name=name; }
}
