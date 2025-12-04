package first.prosit9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class DepartementHashSet implements IDepartement<Departement> {
    private HashSet<Departement> departements;

    public DepartementHashSet() {
        this.departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(Departement departement) {
        if (departements.add(departement)) {
            System.out.println("Département ajouté avec succès: " + departement.getNomDepartement());
        } else {
            System.out.println("Le département existe déjà: " + departement.getNomDepartement());
        }
    }

    @Override
    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement dept : departements) {
            if (dept.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement departement) {
        return departements.contains(departement);
    }

    @Override
    public void supprimerDepartement(Departement departement) {
        if (departements.remove(departement)) {
            System.out.println("Département supprimé: " + departement.getNomDepartement());
        } else {
            System.out.println("Département introuvable: " + departement.getNomDepartement());
        }
    }

    @Override
    public void afficherDepartements() {
        if (departements.isEmpty()) {
            System.out.println("Aucun département dans la liste.");
        } else {
            System.out.println("Liste des départements:");
            for (Departement dept : departements) {
                System.out.println(dept);
            }
        }
    }

    @Override
    public void trierDepartementsParId() {
        ArrayList<Departement> listeTrie = new ArrayList<>(departements);
        Collections.sort(listeTrie, new Comparator<Departement>() {
            @Override
            public int compare(Departement d1, Departement d2) {
                return Integer.compare(d1.getId(), d2.getId());
            }
        });
        
        System.out.println("Départements triés par ID:");
        for (Departement dept : listeTrie) {
            System.out.println(dept);
        }
    }

    @Override
    public void trierDepartementsParNomEtNombreEmployes() {
        ArrayList<Departement> listeTrie = new ArrayList<>(departements);
        Collections.sort(listeTrie, new Comparator<Departement>() {
            @Override
            public int compare(Departement d1, Departement d2) {
                int nomCompare = d1.getNomDepartement().compareTo(d2.getNomDepartement());
                if (nomCompare != 0) {
                    return nomCompare;
                }
                return Integer.compare(d1.getNombreEmployes(), d2.getNombreEmployes());
            }
        });
        
        System.out.println("Départements triés par Nom et Nombre d'Employés:");
        for (Departement dept : listeTrie) {
            System.out.println(dept);
        }
    }
}