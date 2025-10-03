package first.prosit3;

public class Animal {
	String family;
	String name;
	int age;
	boolean isMammal;
	
	//Animal lion=new Animal();
	
	public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

	@Override
	public String toString() {
		return "This animal's name is " + name + ", it belongs to the " + family + " family, its' age=" + age + ", isMammal=" + isMammal;
	}
	
}
