import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargeurMagasinTest {


    @Test
    void chargerMagTest_OK_01(){
        boolean estMag = false;
        try {
            ChargeurMagasin cm = new ChargeurMagasin("TD00/musicbrainzSimple");
            Magasin M2 = cm.chargerMagasin();

            if(M2 instanceof Magasin){
                estMag = true;
            }
            assertEquals(true, estMag);
            assertEquals(M2.getNombreCds(), 12);
        }
        catch (FileNotFoundException e){
            System.out.println("répertoire inexistant");
        }
    }

    @Test
    void chargerMagTest_RepInexistant_02(){
        boolean estMag = false;
        try {
            ChargeurMagasin cm = new ChargeurMagasin("TD00/music");
            Magasin M2 = cm.chargerMagasin();

            if(M2 instanceof Magasin){
                estMag = true;
            }
            assertEquals(true, estMag);
            assertEquals(M2.getNombreCds(), 12);
        }
        catch (FileNotFoundException e){
            System.out.println("répertoire inexistant");
            assertEquals(false, estMag);
        }
    }

}
