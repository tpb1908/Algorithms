/**
 * Created by pearson-brayt15 on 26/05/2016.
 */
public class Person {
    private String name;
    private int id;
    private static int population = 0;


    public Person(String name) {
        this.name = name;
        population++;
        this.id = population;
    }

    public int getPopulation() {
        return population;
    }

    public int getId() {
        return id;
    }
}
