package first.prosit8;
import java.util.*;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {
    private ArrayList<Employe> employes;

    public SocieteArrayList() {
        this.employes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
        System.out.println("Employé ajouté: " + employe.getNom());
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe emp : employes) {
            if (emp.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe employe) {
        return employes.contains(employe);
    }

    @Override
    public void supprimerEmploye(Employe employe) {
        if (employes.remove(employe)) {
            System.out.println("Employé supprimé: " + employe.getNom());
        } else {
            System.out.println("Employé non trouvé");
        }
    }

    @Override
    public void displayEmploye() {
        System.out.println("\n=== Liste des Employés ===");
        if (employes.isEmpty()) {
            System.out.println("Aucun employé dans la société");
        } else {
            for (Employe emp : employes) {
                System.out.println(emp);
            }
        }
        System.out.println();
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
        System.out.println("Tri par ID effectué");
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Collections.sort(employes, new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int deptCompare = e1.getNomDepartement().compareTo(e2.getNomDepartement());
                if (deptCompare != 0) {
                    return deptCompare;
                }
                int gradeCompare = Integer.compare(e1.getGrade(), e2.getGrade());
                if (gradeCompare != 0) {
                    return gradeCompare;
                }
                return e1.getNom().compareTo(e2.getNom());
            }
        });
        System.out.println("Tri par département, grade et nom effectué");
    }

    @Override
    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe emp : employes) {
            if (emp.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                resultat.add(emp);
            }
        }
        return resultat;
    }
}