import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FencingInspectionFacadeTest {

    @Test

    void shouldApproveSafeFoil() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon foil = new Weapon(
                "F001", WeaponType.FOIL,
                true, true, true
        );

        facade.registerWeapon(foil);

        boolean result = facade.inspectWeapon("F001");

        assertTrue(result);
        assertEquals(1, facade.getInspectionCount("F001"));
    }

    @Test
    void shouldRejectBrokenEpee() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon epee = new Weapon(
                "E001", WeaponType.EPEE,
                true, true, false
        );

        facade.registerWeapon(epee);

        boolean result = facade.inspectWeapon("E001");

        assertFalse(result);
        assertEquals(1, facade.getInspectionCount("E001"));
        assertFalse(facade.getLastResult("E001"));
    }

    @Test
    void shouldRejectUnsafeSabre() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon sabre = new Weapon(
                "S001", WeaponType.SABRE,
                true, false, true
        );

        facade.registerWeapon(sabre);

        boolean result = facade.inspectWeapon("S001");

        assertFalse(result);
        assertEquals(1, facade.getInspectionCount("S001"));
        assertFalse(facade.getLastResult("S001"));
    }

    @Test
    void shouldSaveRepeatedInspections() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon foil = new Weapon(
                "F001", WeaponType.FOIL,
                true, true, true
        );

        facade.registerWeapon(foil);

        boolean firstResult = facade.inspectWeapon("F001");
        boolean secondResult = facade.inspectWeapon("F001");

        assertTrue(firstResult);
        assertTrue(secondResult);

        assertEquals(2, facade.getInspectionCount("F001"));

        assertTrue(facade.getLastResult("F001"));
    }

    @Test
    void shouldRejectUnknownWeapon() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.inspectWeapon("UNKNOWN")
        );

        assertEquals(
                0,
                facade.getInspectionCount("UNKNOWN")
        );
    }

    @Test
    void shouldRejectDuplicateRegistration() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon foil = new Weapon(
                "F001", WeaponType.FOIL,
                true, true, true
        );

        facade.registerWeapon(foil);

        assertThrows(
                IllegalStateException.class,
                () -> facade.registerWeapon(foil)
        );

        assertEquals(
                0,
                facade.getInspectionCount("F001")
        );
    }

    @Test
    void shouldExplainRejectionReason() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon epee = new Weapon(
                "E001", WeaponType.EPEE,
                true, true, false
        );

        facade.registerWeapon(epee);

        boolean result = facade.inspectWeapon("E001");

        assertFalse(result);

        assertEquals(
                "Electrical check failed",
                facade.getLastReason("E001")
        );
    }

    @Test
    void shouldReportBothFailedChecks() {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon epee = new Weapon(
                "E002", WeaponType.EPEE,
                false, true, false
        );

        facade.registerWeapon(epee);

        boolean result = facade.inspectWeapon("E002");

        assertFalse(result);

        assertEquals(
                "Safety and electrical checks failed",
                facade.getLastReason("E002")
        );

        assertEquals(1, facade.getInspectionCount("E002"));
    }



}
