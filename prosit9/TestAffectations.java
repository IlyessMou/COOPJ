package first.prosit9;

import java.util.Map;
import java.util.TreeMap;

public class TestAffectations {
    public static void main(String[] args) {
        AffectationHashMap gestion = new AffectationHashMap();

        Employe emp1 = new Employe(3, "Moulazm", "Ilyess", "Informatique", 2);
        Employe emp2 = new Employe(1, "Trabelsi", "Yosra", "RH", 3);
        Employe emp3 = new Employe(2, "Selim", "Mohamed", "Informatique", 1);
        Employe emp4 = new Employe(4, "Mansouri", "Mayar", "Finance", 2);

        Departement deptInfo = new Departement(1, "Informatique", 15);
        Departement deptRH = new Departement(2, "RH", 8);
        Departement deptFinance = new Departement(3, "Finance", 12);
        Departement deptMarketing = new Departement(4, "Marketing", 10);

        System.out.println("TEST 1: Ajout d'affectations");
        gestion.ajouterEmployeDepartement(emp1, deptInfo);
        gestion.ajouterEmployeDepartement(emp2, deptRH);
        gestion.ajouterEmployeDepartement(emp3, deptInfo);
        gestion.ajouterEmployeDepartement(emp4, deptFinance);

        System.out.println("\nTEST 2: Affichage des affectations");
        gestion.afficherEmployesEtDepartements();

        System.out.println("\nTEST 3: Tentative d'affecter un employé à 2 départements");
        System.out.println("Tentative d'affecter emp1 (déjà dans Informatique) au département Marketing:");
        gestion.ajouterEmployeDepartement(emp1, deptMarketing);
        System.out.println("\nAffichage après modification:");
        gestion.afficherEmployesEtDepartements();

        System.out.println("\nTEST 4: Affichage de la liste des employés");
        gestion.afficherEmployes();

        System.out.println("\nTEST 5: Affichage de la liste des départements");
        gestion.afficherDepartements();

        System.out.println("\nTEST 6: Recherche d'un employé");
        System.out.println("Recherche emp2: " + gestion.rechercherEmploye(emp2));
        Employe empInexistant = new Employe(99, "Inconnu", "Test", "X", 1);
        System.out.println("Recherche employé inexistant: " + gestion.rechercherEmploye(empInexistant));

        System.out.println("\nTEST 7: Recherche d'un département");
        System.out.println("Recherche département RH: " + gestion.rechercherDepartement(deptRH));
        Departement deptInexistant = new Departement(99, "Production", 5);
        System.out.println("Recherche département inexistant: " + gestion.rechercherDepartement(deptInexistant));

        System.out.println("\nTEST 8: Suppression d'une affectation précise");
        System.out.println("Suppression de l'affectation emp3 - Informatique:");
        gestion.supprimerEmployeEtDepartement(emp3, deptInfo);
        gestion.afficherEmployesEtDepartements();

        System.out.println("\nTEST 9: Tentative de supprimer une affectation incorrecte");
        System.out.println("Tentative de supprimer emp4 du département RH (alors qu'il est en Finance):");
        gestion.supprimerEmployeEtDepartement(emp4, deptRH);

        System.out.println("\nTEST 10: Suppression d'un employé");
        System.out.println("Suppression de emp2:");
        gestion.supprimerEmploye(emp2);
        gestion.afficherEmployesEtDepartements();

        System.out.println("\nTEST 11: Tri des employés par ID (TreeMap)");
        gestion.ajouterEmployeDepartement(emp2, deptRH);
        gestion.ajouterEmployeDepartement(emp3, deptInfo);
        
        System.out.println("Avant tri (ordre HashMap - aléatoire):");
        gestion.afficherEmployesEtDepartements();
        
        System.out.println("\nAprès tri par ID (TreeMap):");
        TreeMap<Employe, Departement> mapTriee = gestion.trierMap();
        for (Map.Entry<Employe, Departement> entry : mapTriee.entrySet()) {
            System.out.println("Employé ID: " + entry.getKey().getId() + " - " + 
                             entry.getKey().getNom() + " " + entry.getKey().getPrenom() + 
                             " --> " + entry.getValue().getNomDepartement());
        }
    }
}