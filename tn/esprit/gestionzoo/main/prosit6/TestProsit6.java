package first.tn.esprit.gestionzoo.main.prosit6;

import first.tn.esprit.gestionzoo.entities.prosit6.*;

public class TestProsit6 {
    public static void main(String[] args) {
        
        Zoo myZoo = new Zoo("Aquatic World", "TUNIS");
        
        //INST 25: Ajouter des animaux aquatiques
        System.out.println("INST 25");
        Dolphin dolphin1 = new Dolphin("Delphinidae", "Flipper", 5, true, "Ocean", 60.5f);
        Dolphin dolphin2 = new Dolphin("Delphinidae", "Charlie", 7, true, "Sea", 55.0f);
        Penguin penguin1 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 150.0f);
        Penguin penguin2 = new Penguin("Spheniscidae", "Skipper", 4, false, "South Pole", 200.0f);
        Penguin penguin3 = new Penguin("Spheniscidae", "Kowalski", 5, false, "Arctic", 180.0f);
        
        myZoo.addAquaticAnimal(dolphin1);
        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin1);
        myZoo.addAquaticAnimal(penguin2);
        myZoo.addAquaticAnimal(penguin3);
        
        myZoo.displayAquaticAnimals();
        
        // INST 26: Test de swim()
        System.out.println("\n INST 26");
        myZoo.swimAllAquatics();
        System.out.println("\nRemarque: Chaque type d'animal aquatique affiche son propre message!");
        System.out.println("La méthode swim() est maintenant abstraite, donc obligatoire à redéfinir.");
        
        //INST 27: Profondeur maximale
        System.out.println("\n INST 27");
        float maxDepth = myZoo.maxPenguinSwimmingDepth();
        System.out.println("Maximum penguin swimming depth: " + maxDepth + " meters");
        
        //INST 28: Nombre par type
        System.out.println("\n INST 28");
        myZoo.displayNumberOfAquaticsByType();
        
        //INST 31: Test de equals()
        System.out.println("\n INST 31");
        Dolphin dolphin3 = new Dolphin("Delphinidae", "Flipper", 5, true, "Ocean", 70.0f);
        Dolphin dolphin4 = new Dolphin("Delphinidae", "Flipper", 5, true, "Ocean", 60.5f);
        Penguin penguin4 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 150.0f);
        
        System.out.println("dolphin1 equals dolphin3 (même nom, âge, habitat): " + dolphin1.equals(dolphin3));
        System.out.println("dolphin1 equals dolphin4 (même nom, âge, habitat): " + dolphin1.equals(dolphin4));
        System.out.println("dolphin1 equals dolphin2 (différent nom): " + dolphin1.equals(dolphin2));
        System.out.println("penguin1 equals penguin4 (identique): " + penguin1.equals(penguin4));
        System.out.println("dolphin1 equals penguin1 (types différents): " + dolphin1.equals(penguin1));
        
        //extra testssss
        System.out.println("\nTest: Remplir le tableau aquatique");
        for (int i = 6; i <= 12; i++) {
            Dolphin d = new Dolphin("Delphinidae", "Dolphin" + i, i, true, "Ocean", 50.0f + i);
            myZoo.addAquaticAnimal(d);
        }
        
        myZoo.displayAquaticAnimals();
        myZoo.displayNumberOfAquaticsByType();
        
    }
}