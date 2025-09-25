package first.prosit2;

import java.util.Arrays;

public class Zoo {
	Animal[] animals;
	String name;
	String city;
	int nbrCages=25;
	
	
	//Zoo myZoo=new Zoo();
	
	public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[nbrCages];
    }
	
	public void displayZoo() {
        System.out.println("Zoo name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

	@Override
	   public String toString() {
	       return "The Zoo's name is " + name + ", it's in " + city + " city , it has " + nbrCages+ " cages";
	   }
	
}
