package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

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
        
        System.out.println("\nSearch for Animals!!!");
        int index = myZoo.searchAnimal(lion);
        System.out.println("Searching for " + lion.getName() + ": Found at index " + index);
        
        Animal duplicateLion = new Animal("Feline", "Sammy", 7, true);
        System.out.println("\nTrying to add duplicate animal:");
        myZoo.addAnimal(duplicateLion);
        
        System.out.println("\nTesting uniqueness constraint:");
        int duplicateIndex = myZoo.searchAnimal(duplicateLion);
        System.out.println("Searching for duplicate " + duplicateLion.getName() + ": Found at index " + duplicateIndex);
        
        System.out.println("\nTesting capacity constraint (trying to fill the zoo):");
        for (int i = 5; i <= 27; i++) {
            Animal tempAnimal = new Animal("Family" + i, "Animal" + i, i, true);
            myZoo.addAnimal(tempAnimal);
        }
        
        System.out.println("\nINSTRUCTION 13: Remove Animal!!!!");
        System.out.println("\nBefore removal:");
        myZoo.displayAnimals();
        
        myZoo.removeAnimal(tiger);
        
        System.out.println("\nAfter removing " + tiger.getName() + ":");
        myZoo.displayAnimals();
        
        Animal mchmawjoud = new Animal("Unknown", "Ghost", 0, false);
        myZoo.removeAnimal(mchmawjoud);
        
        System.out.println("\nINSTRUCTION 14: Testing Constant nbrCages!!!!");
        System.out.println("Maximum capacity of zoo: " + myZoo.getNbrCages() + " cages");
        
        System.out.println("\nINSTRUCTION 15: Additional Methods!!!!");
        
        System.out.println("Is " + myZoo.getName() + " zoo full? " + myZoo.isZooFull());
        
        Zoo anotherZoo = new Zoo("Belvedere", "TUNIS");
        Animal zebra = new Animal("Equidae", "Marty", 4, true);
        Animal hippo = new Animal("Hippo", "Gloria", 8, true);
        anotherZoo.addAnimal(zebra);
        anotherZoo.addAnimal(hippo);
        
        System.out.println("\n" + myZoo.getName() + " zoo has " + myZoo.getAnimalCount() + " animals");
        System.out.println(anotherZoo.getName() + " zoo has " + anotherZoo.getAnimalCount() + " animals");
        
        Zoo largerZoo = Zoo.comparerZoo(myZoo, anotherZoo);
        System.out.println("\nThe zoo with more animals is: " + largerZoo.getName() 
                           + " with " + largerZoo.getAnimalCount() + " animals");
        
        // Test de validation de l'âge négatif (INSTRUCTION 18)
        System.out.println("\n=== Testing INSTRUCTION 18: Validation ===");
        Animal invalidAnimal = new Animal("Test", "NegativeAge", -5, true);
        System.out.println("Created animal with negative age: age = " + invalidAnimal.getAge());
        
        // Test de validation du nom vide
        Zoo emptyNameZoo = new Zoo("", "TestCity");
        System.out.println("Created zoo with empty name: name = '" + emptyNameZoo.getName() + "'");
        
        System.out.println("\nFinal!!!!!!");
        myZoo.displayAnimals();
        System.out.println();
        anotherZoo.displayAnimals();
    }
}