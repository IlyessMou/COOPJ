package first;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("the name of the zoo: ");
        String zooName = sc.nextLine();
        while (zooName.trim().isEmpty()) {
            System.out.print("Zoo name can't be empty, try again: ");
            zooName = sc.nextLine();
        }
        System.out.print("number of cages: ");
        int nbrCages = -1;
        while (nbrCages <= 0) {
            while (!sc.hasNextInt()) {
                System.out.print("enter a valid int:");
                sc.next();
            }
            nbrCages = sc.nextInt();
            if (nbrCages <= 0) {
                System.out.print("Number of cages must be positive...try again!!!: ");
            }
        }
        System.out.println("This is " + zooName + ", it has " + nbrCages + " cages!!");
        sc.close();
    }
}
