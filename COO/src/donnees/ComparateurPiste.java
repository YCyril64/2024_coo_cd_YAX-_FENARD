package donnees;

public class ComparateurPiste implements ComparateurCd {

    @Override
    public boolean etreAvant(CD cd1, CD cd2) {
        return cd1.getNbPiste() > cd2.getNbPiste();
    }
}
