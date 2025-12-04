package first.prosit9;

import java.util.*;

public class AffectationHashMap {
    private HashMap<Employe, Departement> affectations;

    public AffectationHashMap() {
        this.affectations = new HashMap<>();
    }

    // Question 3c: Lorsqu'on tente d'ajouter un même employé à deux départements différents,la HashMap remplace automatiquement l'ancienne valeur par la nouvelle car une clé ne peut avoir qu'une seule valeur. L'employé sera donc affecté uniquement au dernier département ajouté.
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e)) {
            System.out.println("Attention: L'employé " + e.getNom() + " " + e.getPrenom() + 
                             " est déjà affecté au département " + affectations.get(e).getNomDepartement());
            System.out.println("L'ancienne affectation sera remplacée par: " + d.getNomDepartement());
        }
        affectations.put(e, d);
        System.out.println("Employé " + e.getNom() + " " + e.getPrenom() + 
                         " affecté au département " + d.getNomDepartement());
    }

    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation dans la collection.");
        } else {
            System.out.println("Liste des affectations Employé-Département!!!!!");
            for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
                System.out.println("Employé: " + entry.getKey().getNom() + " " + 
                                 entry.getKey().getPrenom() + " (ID: " + entry.getKey().getId() + 
                                 ") --> Département: " + entry.getValue().getNomDepartement() + 
                                 " (ID: " + entry.getValue().getId() + ")");
            }
        }
    }

    public void supprimerEmploye(Employe e) {
        if (affectations.remove(e) != null) {
            System.out.println("Employé " + e.getNom() + " " + e.getPrenom() + " supprimé avec succès.");
        } else {
            System.out.println("Employé " + e.getNom() + " " + e.getPrenom() + " introuvable.");
        }
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e)) {
            Departement deptActuel = affectations.get(e);
            if (deptActuel.equals(d)) {
                affectations.remove(e);
                System.out.println("Affectation supprimée: " + e.getNom() + " " + 
                                 e.getPrenom() + " du département " + d.getNomDepartement());
            } else {
                System.out.println("L'employé " + e.getNom() + " " + e.getPrenom() + 
                                 " n'est pas affecté au département " + d.getNomDepartement());
            }
        } else {
            System.out.println("Employé " + e.getNom() + " " + e.getPrenom() + " introuvable.");
        }
    }

    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé dans la collection.");
        } else {
            System.out.println("Liste des employés!!");
            for (Employe emp : affectations.keySet()) {
                System.out.println(emp);
            }
        }
    }

    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département dans la collection.");
        } else {
            System.out.println("Liste des départements!!!");
            HashSet<Departement> departements = new HashSet<>(affectations.values());
            for (Departement dept : departements) {
                System.out.println(dept);
            }
        }
    }

    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> triee = new TreeMap<>(affectations);
        return triee;
    }
}