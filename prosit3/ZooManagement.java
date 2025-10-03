package first.prosit3;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Ilyess's", "BIZERTE");
        
        System.out.println("Adding Animals!!!");
        Animal lion = new Animal("Felidae", "sammy", 7, true);
        Animal tiger = new Animal("Felidae", "tigero", 5, true);
        Animal elephant = new Animal("Elephantidae", "eleno", 10, true);
        Animal giraffe = new Animal("Giraffidae", "zarafa", 6, true);
        
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(giraffe);
        
        myZoo.displayAnimals();
        
        System.out.println("Search for Animals!!!");
        int index = myZoo.searchAnimal(lion);
        System.out.println("Searching for " + lion.name + ": Found at index " + index);
        
        Animal duplicateLion = new Animal("Feline", "Sammy", 7, true);
        System.out.println("\nTrying to add duplicate animal:");
        myZoo.addAnimal(duplicateLion);
        
        System.out.println("Testing uniqueness constraint:");
        int duplicateIndex = myZoo.searchAnimal(duplicateLion);
        System.out.println("Searching for duplicate " + duplicateLion.name + ": Found at index " + duplicateIndex);
        
        System.out.println("\nTesting capacity constraint (trying to fill the zoo):");
        for (int i = 5; i <= 27; i++) {
            Animal tempAnimal = new Animal("Family" + i, "Animal" + i, i, true);
            myZoo.addAnimal(tempAnimal);
        }
        
        System.out.println("INSTRUCTION 13: Remove Animal!!!!");
        System.out.println("\nBefore removal:");
        myZoo.displayAnimals();
        
        myZoo.removeAnimal(tiger);
        
        System.out.println("\nAfter removing " + tiger.name + ":");
        myZoo.displayAnimals();
        
        Animal mchmawjoud = new Animal("Unknown", "Ghost", 0, false);
        myZoo.removeAnimal(mchmawjoud);
        
        System.out.println("\n INSTRUCTION 14: Testing Constant nbrCages!!!!");
        System.out.println("Maximum capacity of zoo: " + myZoo.nbrCages + " cages");
        
        System.out.println("\n INSTRUCTION 15: Additional Methods!!!!");
        
        System.out.println("Is " + myZoo.name + " zoo full? " + myZoo.isZooFull());
        
        Zoo anotherZoo = new Zoo("Belvedere", "TUNIS");
        Animal zebra = new Animal("Equidae", "Marty", 4, true);
        Animal hippo = new Animal("Hippo", "Gloria", 8, true);
        anotherZoo.addAnimal(zebra);
        anotherZoo.addAnimal(hippo);
        
        System.out.println("\n" + myZoo.name + " zoo has " + myZoo.animalCount + " animals");
        System.out.println(anotherZoo.name + " zoo has " + anotherZoo.animalCount + " animals");
        
        Zoo largerZoo = Zoo.comparerZoo(myZoo, anotherZoo);
        System.out.println("\nThe zoo with more animals is: " + largerZoo.name + " with " + largerZoo.animalCount + " animals");
        
        System.out.println("\nFinal!!!!!!");
        myZoo.displayAnimals();
        System.out.println();
        anotherZoo.displayAnimals();
    }
}