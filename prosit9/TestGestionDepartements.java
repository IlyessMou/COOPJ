package first.prosit9;

public class TestGestionDepartements {
    public static void main(String[] args) {
        DepartementHashSet gestionDept = new DepartementHashSet();

        Departement dept1 = new Departement(3, "Informatique", 15);
        Departement dept2 = new Departement(1, "RH", 8);
        Departement dept3 = new Departement(2, "Finance", 12);
        Departement dept4 = new Departement(4, "Marketing", 10);

        System.out.println("Ajout des départements!!!");
        gestionDept.ajouterDepartement(dept1);
        gestionDept.ajouterDepartement(dept2);
        gestionDept.ajouterDepartement(dept3);
        gestionDept.ajouterDepartement(dept4);

        System.out.println("\nTentative d'ajout d'un doublon!!!!");
        Departement deptDoublon = new Departement(1, "RH", 8);
        gestionDept.ajouterDepartement(deptDoublon);

        System.out.println("\nListe de tous les départements!!");
        gestionDept.afficherDepartements();

        System.out.println("\nRecherche de départements!!!");
        System.out.println("Recherche 'Finance': " + gestionDept.rechercherDepartement("Finance"));
        System.out.println("Recherche 'Production': " + gestionDept.rechercherDepartement("Production"));

        System.out.println("Recherche objet dept2: " + gestionDept.rechercherDepartement(dept2));

        System.out.println("\nTri par ID!!!");
        gestionDept.trierDepartementsParId();

        System.out.println("\nTri par Nom et Nombre d'Employés!!");
        gestionDept.trierDepartementsParNomEtNombreEmployes();

        System.out.println("\nSuppression d'un département!!!");
        gestionDept.supprimerDepartement(dept2);
        
        System.out.println("\nListe après suppression!!!!");
        gestionDept.afficherDepartements();
    }
}