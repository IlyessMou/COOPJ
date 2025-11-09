package first.tn.esprit.gestionzoo.entities.prosit6;

public abstract class Aquatic extends Animal {
    protected String habitat;
    
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    public abstract void swim();
    
    @Override
    public String toString() {
        return super.toString() + ", habitat=" + habitat;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Aquatic)) return false;
        
        Aquatic other = (Aquatic) obj;
        return this.getName().equals(other.getName()) && 
               this.getAge() == other.getAge() && 
               this.habitat.equals(other.habitat);
    }
}