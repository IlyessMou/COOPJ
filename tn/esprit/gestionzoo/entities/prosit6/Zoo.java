package first.tn.esprit.gestionzoo.entities.prosit6;

public class Zoo {
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private final int NBR_CAGES = 25; 
    private final int NBR_AQUATIC_CAGES = 10;
    private int animalCount = 0;
    private int aquaticCount = 0;
    
    public Zoo(String name, String city) {
        setName(name); 
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
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
        return NBR_CAGES;
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
        System.out.println("Number of cages: " + NBR_CAGES);
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Cannot add " + animal.getName() + ": Zoo is full!");
            return false;
        }
        
        if (searchAnimal(animal) != -1) {
            System.out.println("Cannot add " + animal.getName() + ": Animal already exists in the zoo!");
            return false;
        }
        
        animals[animalCount] = animal;
        animalCount++;
        System.out.println(animal.getName() + " has been added successfully!");
        return true;
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
        System.out.println("Total animals: " + animalCount + "/" + NBR_CAGES);
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
        return animalCount >= NBR_CAGES;
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
        return "The Zoo's name is " + name + ", it's in " + city + " city, it has " + NBR_CAGES + " cages";
    }
}