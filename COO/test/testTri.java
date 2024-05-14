import XML.ChargeurMagasin;
import donnees.CD;
import donnees.ComparateurAlbum;
import donnees.ComparateurArtiste;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testTri {

    @Test
    public void testTrieArtiste() throws FileNotFoundException {
        boolean b = true;
        CD precedent;
        ChargeurMagasin cm = new ChargeurMagasin("musicbrainzSimple/");
        Magasin m = cm.chargerMagasin();

        m.trier(new ComparateurArtiste());
        precedent = m.getCd(0);

        for (CD cd : m.getListeCds()) {
            if(precedent.compareToArtiste(cd) > 0){
                b = false;
                break;
            }
            precedent = cd;
        }
        assertTrue(b);
    }

    @Test
    public void testTrieTitre() throws FileNotFoundException {
        boolean b = true;
        CD precedent;
        ChargeurMagasin cm = new ChargeurMagasin("musicbrainzSimple/");
        Magasin m = cm.chargerMagasin();

        m.trier(new ComparateurAlbum());
        precedent = m.getCd(0);

        for (CD cd : m.getListeCds()) {
            if(precedent.compareToTitre(cd) > 0){
                b = false;
                break;
            }
            precedent = cd;
        }
        assertTrue(b);
    }

}
