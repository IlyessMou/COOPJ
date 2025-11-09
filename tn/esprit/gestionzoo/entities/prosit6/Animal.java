package first.tn.esprit.gestionzoo.entities.prosit6;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;
    
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); 
        this.isMammal = isMammal;
    }

    // Getters
    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    // Setters
    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("L'âge ne peut pas être négatif. Âge défini à 0.");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "This animal's name is " + name + ", it belongs to the " + family 
               + " family, its' age=" + age + ", isMammal=" + isMammal;
    }
}