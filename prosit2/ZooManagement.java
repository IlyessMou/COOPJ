package first.prosit2;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Animal lion = new Animal("Lions", "Hannibal", 7, true);
        Zoo myZoo = new Zoo("Ilyess's", "BIZERTE", 20);
        myZoo.displayZoo();
        
        System.out.println(myZoo); 
        System.out.println(lion);  
    }
}
