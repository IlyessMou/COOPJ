package first.prosit3;

public class Zoo {
    Animal[] animals;
    String name;
    String city;
    final int nbrCages = 25; 
    int animalCount = 0;
    
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[nbrCages]; 
    }
    
    public void displayZoo() {
        System.out.println("Zoo name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    public boolean addAnimal(Animal animal) {
        if (animalCount >= nbrCages) {
            System.out.println("Cannot add " + animal.name + ": Zoo is full!");
            return false;
        }
        
        if (searchAnimal(animal) != -1) {
            System.out.println("Cannot add " + animal.name + ": Animal already exists in the zoo!");
            return false;
        }
        
        animals[animalCount] = animal;
        animalCount++;
        System.out.println(animal.name + " has been added successfully!");
        return true;
    }
    
    public void displayAnimals() {
        System.out.println("\nAnimals in " + name + " Zoo !!!!!!!!");
        if (animalCount == 0) {
            System.out.println("No animals in the zoo yet.");
        } else {
            for (int i = 0; i < animalCount; i++) {
                System.out.println((i + 1) + ". " + animals[i]);
            }
        }
        System.out.println("Total animals: " + animalCount + "/" + nbrCages);
    }
    
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        
        if (index == -1) {
            System.out.println("Cannot remove " + animal.name + ": Animal not found in the zoo!");
            return false;
        }
        
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        
        animals[animalCount - 1] = null;
        animalCount--;
        
        System.out.println(animal.name + " has been removed successfully!");
        return true;
    }
    
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }
    
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) {
            return z1;
        } else {
            return z2;
        }
    }

    @Override
    public String toString() {
        return "The Zoo's name is " + name + ", it's in " + city + " city, it has " + nbrCages + " cages";
    }
}