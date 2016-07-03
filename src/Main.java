
/**
 * Created by theo on 16/04/16.
 */
public class Main {


    //https://en.wikipedia.org/wiki/List_of_algorithms
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Person[] peoples = new Person[10];
        for(int i = 0; i < peoples.length; i++) {
            peoples[i] = new Person("");
        }

        for(Person p : peoples) {
            System.out.println(p.getPopulation());
            System.out.println(p.getId());
        }



    }

}
