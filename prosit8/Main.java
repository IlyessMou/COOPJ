package first.prosit8;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        System.out.println("APPLICATION DE GESTION DES EMPLOYÉS \n");

        System.out.println("--- Ajout d'employés ---");
        societe.ajouterEmploye(new Employe(103, "Ben Ali", "Ahmed", "Informatique", 2));
        societe.ajouterEmploye(new Employe(101, "Trabelsi", "Fatma", "RH", 3));
        societe.ajouterEmploye(new Employe(105, "Mejri", "Mohamed", "Informatique", 1));
        societe.ajouterEmploye(new Employe(102, "Saidi", "Leila", "Finance", 2));
        societe.ajouterEmploye(new Employe(104, "Gharbi", "Karim", "RH", 1));

        societe.displayEmploye();

        //Tests de recherche 
        System.out.println("--- Recherche par nom ---");
        System.out.println("Recherche 'Ben Ali': " + societe.rechercherEmploye("Ben Ali"));
        System.out.println("Recherche 'Dupont': " + societe.rechercherEmploye("Dupont"));
        System.out.println();

        System.out.println("--- Recherche par objet ---");
        Employe empTest = new Employe(101, "Trabelsi", "Fatma", "RH", 3);
        System.out.println("Recherche employé ID 101: " + societe.rechercherEmploye(empTest));
        System.out.println();

        //Tri
        System.out.println("--- Tri par ID ---");
        societe.trierEmployeParId();
        societe.displayEmploye();
        
        System.out.println("--- Tri par département, grade et nom ---");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();

        //Recherche avancée par département
        System.out.println("--- Recherche avancée par département ---");
        String deptRecherche = "Informatique";
        List<Employe> employesInfo = societe.rechercherParDepartement(deptRecherche);
        System.out.println("Employés du département " + deptRecherche + ":");
        for (Employe emp : employesInfo) {
            System.out.println("  - " + emp);
        }
        System.out.println();

        deptRecherche = "RH";
        List<Employe> employesRH = societe.rechercherParDepartement(deptRecherche);
        System.out.println("Employés du département " + deptRecherche + ":");
        for (Employe emp : employesRH) {
            System.out.println("  - " + emp);
        }
        System.out.println();

        //suppression
        System.out.println("--- Suppression d'un employé ---");
        Employe empASupprimer = new Employe(105, "Mejri", "Mohamed", "Informatique", 1);
        societe.supprimerEmploye(empASupprimer);
        societe.displayEmploye();
    }
}