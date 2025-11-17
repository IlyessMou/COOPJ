package first.prosit9;

public class TestGestionEmployes {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        //Ajout d'employes
        Employe emp1 = new Employe(3, "Moulazm", "Ilyess", "Informatique", 2);
        Employe emp2 = new Employe(1, "Trabelsi", "Yosra", "RH", 3);
        Employe emp3 = new Employe(2, "Selim", "Mohamed", "Informatique", 1);
        Employe emp4 = new Employe(4, "Mansouri", "Mayar", "Finance", 2);

        societe.ajouterEmploye(emp1);
        societe.ajouterEmploye(emp2);
        societe.ajouterEmploye(emp3);
        societe.ajouterEmploye(emp4);

        System.out.println("**** Liste initiale des employés ****");
        societe.displayEmploye();

        //Recherche par nom
        System.out.println("\nRecherche d'employe");
        System.out.println("Recherche 'Ben Ali': " + societe.rechercherEmploye("Ben Ali"));
        System.out.println("Recherche 'Trabelsi': " + societe.rechercherEmploye("Trabelsi"));

        //Tri par id
        System.out.println("\nTri par id");
        societe.trierEmployeParId();
        societe.displayEmploye();

        //Tri par département et grade
        System.out.println("\nTri par Département et Grade");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();

        // Suppression d'un employé
        System.out.println("\nSuppression d'un employe::");
        societe.supprimerEmploye(emp2);
        societe.displayEmploye();
    }
}