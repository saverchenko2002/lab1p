package SaverchenkoGroup10Lab1VarC2;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Breakfast {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        boolean sort = false, calories = false;
        int count = 0;
        for (String arg : args) {

            String[] parts = arg.split("/");

            if (parts.length == 1 && (!calories || !sort)) {
                if (parts[0].equals("-calories")) {
                    calories = true;
                    continue;

                } else if (parts[0].equals("-sort")) {
                    sort = true;
                    continue;
                }
            }
            try {
                Class myClass = Class.forName("SaverchenkoGroup10Lab1VarC2." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();
                    breakfast[count] = (Food) constructor.newInstance();
                    count++;
                } else if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[count] = (Food) constructor.newInstance(parts[1]);
                    count++;
                } else if (parts.length == 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[count] = (Food) constructor.newInstance(parts[1], parts[2]);
                    count++;
                }
            } catch (ClassNotFoundException a) {
                System.out.println("Класс " + parts[0] + " не найден. ");
            } catch (NoSuchMethodException b) {
                System.out.println("Метод не найден. ");
            }
        }

        Food j;
        boolean check=true;
        int [] counter = new int [count];
        for (int i=0; i<count;i++)
            counter[i]=0;
        int i=0, c=1, h=0;
        j=breakfast[i];
        for(int k=0;k<count;k++)
        {
            if (breakfast[k].equals(j))
            {
                h++;
                counter[k]=c;
            }
        }
        c++;
        System.out.println(breakfast[i]+" встречается в завтраке " + h + " раз");
        h=0; i++;
        do
        {
            for (int p=i;p<count;p++)
            {
                if (counter[p]!=i && counter[p]==0)
                {
                    i=p;
                    j=breakfast[i];
                    check=true;
                    break;
                }
                else check=false;

            }
            if (check)
            {
                for (int k = i; k < count; k++)
                {
                    if (breakfast[k].equals(j))
                    {
                        h++;
                        counter[k] = c;
                    }
                }

                System.out.println(breakfast[i] + " встречается в завтраке " + h + " раз");
                h=0; c++;
            }
            i++;
        }while(i<count);

        System.out.println();
        for (Food item:breakfast)
        {
            if (item==null)
                break;
            item.consume();
            System.out.println(" "+item.calculateCalories());
        }

        System.out.println("\nЗавтрак до сортировки:");
        for (Food item:breakfast)
        {
            if (item==null)
                break;
            System.out.println(item.toString());
        }

        System.out.println("\nЗавтрак после сортировки: ");
        if (sort)
        {
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1 == null) return 1;
                    if (f2 == null) return -1;
                    if (((Food)f1).calculateCalories() < ((Food)f2).calculateCalories())
                        return 1;
                    if (((Food)f1).calculateCalories() == ((Food)f2).calculateCalories())
                        return  0;
                    return  -1;
                }
            });
            for (Food item:breakfast)
            {
                if (item==null)
                    break;
                System.out.println(item.toString());
            }
        }

        if (calories) {
            int allCalories = 0;
            for (Food item : breakfast) {
                if (item == null) {
                    System.out.println("\nВсего " + allCalories + " калорий в завтраке.");
                    break;
                } else {
                    allCalories += item.calculateCalories();
                }
            }
        }
    }
}
