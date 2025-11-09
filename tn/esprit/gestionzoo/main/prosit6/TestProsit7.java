package first.tn.esprit.gestionzoo.main.prosit6;

import first.tn.esprit.gestionzoo.entities.prosit6.*;
import first.tn.esprit.gestionzoo.exceptions.*;

public class TestProsit7 {
    public static void main(String[] args) {
        
        Zoo myZoo = new Zoo("Mini Zoo", "TUNIS", 3);
        
        System.out.println("Test 1: Ajout d'animaux valides");
        
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        try {
            myZoo.addAnimal(lion);
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (ZooFullException e) {
            System.out.println("ERREUR: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
        
        Animal tiger = new Animal("Felidae", "Tigro", 3, true);
        try {
            myZoo.addAnimal(tiger);
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (ZooFullException e) {
            System.out.println("ERREUR: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
        
        Animal elephant = new Animal("Elephantidae", "Dumbo", 10, true);
        try {
            myZoo.addAnimal(elephant);
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (ZooFullException e) {
            System.out.println("ERREUR: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
        
        System.out.println("\nTest 2: INSTRUCTION 33-Zoo plein (ZooFullException)");
        
        // Tentative d'ajouter un 4ème animal 
        Animal giraffe = new Animal("Giraffidae", "Zarafa", 6, true);
        try {
            myZoo.addAnimal(giraffe);
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (ZooFullException e) {
            System.out.println("EXCEPTION CAPTURÉE: " + e.getMessage());
            System.out.println("Le programme continue normalement...");
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (InvalidAgeException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
        
        System.out.println("\nTest 3: INSTRUCTION 34-Âge négatif (InvalidAgeException)");
        
        // Tentative d'ajouter un animal avec âge négatif
        Animal invalidAnimal = new Animal("Canidae", "InvalidDog", -5, true);
        try {
            myZoo.addAnimal(invalidAnimal);
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        } catch (ZooFullException e) {
            System.out.println("ERREUR: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("EXCEPTION CAPTURÉE: " + e.getMessage());
            System.out.println("L'animal avec un âge négatif n'a pas été ajouté.");
            System.out.println("Nombre d'animaux dans le zoo: " + myZoo.getAnimalCount() + "/" + myZoo.getNbrCages());
        }
        
        System.out.println("\nTest 4: Tests combinés");
        
        Zoo largerZoo = new Zoo("Grand Zoo", "SFAX", 5);
        
        Animal[] testAnimals = {
            new Animal("Felidae", "Lion1", 4, true),      
            new Animal("Ursidae", "Bear1", -2, true),     
            new Animal("Canidae", "Wolf1", 3, true),      
            new Animal("Felidae", "Tiger1", 5, true),     
            new Animal("Ursidae", "Bear2", 7, true),      
            new Animal("Canidae", "Fox1", 2, true),       
            new Animal("Felidae", "Leopard1", 6, true),   
            new Animal("Canidae", "Dog1", -1, true)       
        };
        
        for (int i = 0; i < testAnimals.length; i++) {
            System.out.println("\nTentative " + (i + 1) + ": Ajout de " + testAnimals[i].getName() 
                             + " (âge: " + testAnimals[i].getAge() + ")");
            try {
                largerZoo.addAnimal(testAnimals[i]);
            } catch (ZooFullException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            } catch (InvalidAgeException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
            System.out.println(" Animaux actuels: " + largerZoo.getAnimalCount() + "/" + largerZoo.getNbrCages());
        }
        
        myZoo.displayAnimals();
        largerZoo.displayAnimals();

    }
}