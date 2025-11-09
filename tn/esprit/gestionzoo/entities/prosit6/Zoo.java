package first.tn.esprit.gestionzoo.entities.prosit6;

import first.tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import first.tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private int nbrCages;
    private final int NBR_AQUATIC_CAGES = 10;
    private int animalCount = 0;
    private int aquaticCount = 0;
    
    public Zoo(String name, String city) {
        setName(name); 
        this.city = city;
        this.nbrCages = 25; // Valeur par défaut
        this.animals = new Animal[nbrCages];
        this.aquaticAnimals = new Aquatic[NBR_AQUATIC_CAGES];
    }
    
    // Constructeur avec nombre de cages personnalisé (pour les tests)
    public Zoo(String name, String city, int nbrCages) {
        setName(name); 
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.aquaticAnimals = new Aquatic[NBR_AQUATIC_CAGES];
    }
    
    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Le nom du zoo ne peut pas être vide. Nom défini à 'Unknown Zoo'.");
            this.name = "Unknown Zoo";
        } else {
            this.name = name;
        }
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void displayZoo() {
        System.out.println("Zoo name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    // INSTRUCTION 32-34: Méthode modifiée avec gestion d'exceptions
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        // INSTRUCTION 34: Vérification de l'âge
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Âge d'animal invalide : l'âge ne peut pas être négatif.");
        }
        
        // INSTRUCTION 33: Vérification si le zoo est plein
        if (animalCount >= nbrCages) {
            throw new ZooFullException("Le zoo est plein, impossible d'ajouter un nouvel animal.");
        }
        
        // Vérification de doublon (conservée)
        if (searchAnimal(animal) != -1) {
            System.out.println("Cannot add " + animal.getName() + ": Animal already exists in the zoo!");
            return;
        }
        
        // INSTRUCTION 32: Ajout simple sans retour de valeur
        animals[animalCount] = animal;
        animalCount++;
        System.out.println(animal.getName() + " has been added successfully!");
    }
    
    // INSTRUCTION 25: Ajouter un animal aquatique
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount >= NBR_AQUATIC_CAGES) {
            System.out.println("Cannot add " + aquatic.getName() + ": Aquatic section is full!");
            return;
        }
        
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        System.out.println(aquatic.getName() + " has been added to aquatic section!");
    }
    
    // INSTRUCTION 26: Parcourir et appeler swim()
    public void swimAllAquatics() {
        System.out.println("\n=== All aquatic animals swimming ===");
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }
    
    // INSTRUCTION 27: Profondeur maximale des pingouins
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }
    
    // INSTRUCTION 28: Afficher le nombre par type
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
        
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }
        
        System.out.println("\n=== Aquatic Animals Count ===");
        System.out.println("Number of Dolphins: " + dolphinCount);
        System.out.println("Number of Penguins: " + penguinCount);
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
    
    public void displayAquaticAnimals() {
        System.out.println("\n=== Aquatic Animals in " + name + " ===");
        if (aquaticCount == 0) {
            System.out.println("No aquatic animals yet.");
        } else {
            for (int i = 0; i < aquaticCount; i++) {
                System.out.println((i + 1) + ". " + aquaticAnimals[i]);
            }
        }
        System.out.println("Total aquatic animals: " + aquaticCount + "/" + NBR_AQUATIC_CAGES);
    }
    
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        
        if (index == -1) {
            System.out.println("Cannot remove " + animal.getName() + ": Animal not found in the zoo!");
            return false;
        }
        
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        
        animals[animalCount - 1] = null;
        animalCount--;
        
        System.out.println(animal.getName() + " has been removed successfully!");
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