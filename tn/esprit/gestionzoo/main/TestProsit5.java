package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class TestProsit5 {
    public static void main(String[] args) {
        System.out.println("INST 21");
        Aquatic aquatic1 = new Aquatic();
        Terrestrial terrestrial1 = new Terrestrial();
        Dolphin dolphin1 = new Dolphin();
        Penguin penguin1 = new Penguin();
        
        System.out.println("Objets créés avec succès!");
        System.out.println();
        
        System.out.println("INST 22:");
        Aquatic aquatic2 = new Aquatic("Fish", "Nemo", 2, false, "Ocean");
        Terrestrial terrestrial2 = new Terrestrial("Felidae", "Simba", 4, true, 4);
        Dolphin dolphin2 = new Dolphin("Delphinidae", "Flipper", 5, true, "Sea", 60.5f);
        Penguin penguin2 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 150.0f);
        
        System.out.println("Objets avec constructeurs paramétrés créés avec succès!");
        System.out.println();
        
        System.out.println("INST 23:");
        System.out.println("Aquatic: " + aquatic2);
        System.out.println("Terrestrial: " + terrestrial2);
        System.out.println("Dolphin: " + dolphin2);
        System.out.println("Penguin: " + penguin2);
        System.out.println();
        
        System.out.println("INST 24:");
        System.out.print("Aquatic swim: ");
        aquatic2.swim();
        
        System.out.print("Dolphin swim: ");
        dolphin2.swim();
        
        System.out.print("Penguin swim: ");
        penguin2.swim();
        System.out.println();
        
        System.out.println("extra testinggg");
        Dolphin dolphin3 = new Dolphin("Delphinidae", "Charlie", 7, true, "Pacific Ocean", 55.0f);
        Penguin penguin3 = new Penguin("Spheniscidae", "Skipper", 4, false, "South Pole", 200.0f);
        Terrestrial lion = new Terrestrial("Felidae", "Leo", 8, true, 4);
        
        System.out.println("\n" + dolphin3);
        System.out.println(penguin3);
        System.out.println(lion);
    }
}