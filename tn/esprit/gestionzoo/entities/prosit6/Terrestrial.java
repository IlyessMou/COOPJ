package first.tn.esprit.gestionzoo.entities.prosit6;

public class Terrestrial extends Animal {
    protected int nbrLegs;
    
    public Terrestrial() {
        super("Terrestrial", "Unknown", 0, true);
        this.nbrLegs = 4;
    }
    
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }
    
    public int getNbrLegs() {
        return nbrLegs;
    }
    
    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", nbrLegs=" + nbrLegs;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Terrestrial other = (Terrestrial) obj;
        return this.getName().equals(other.getName()) && 
               this.getAge() == other.getAge() && 
               this.nbrLegs == other.nbrLegs;
    }
}