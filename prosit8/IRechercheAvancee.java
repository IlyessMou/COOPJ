package first.prosit8;

import java.util.List;

public interface IRechercheAvancee<T> {
    List<T> rechercherParDepartement(String nomDepartement);
}