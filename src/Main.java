
public class Main {

    public static void main(String[] args) {

        FencingInspectionFacade facade =
                new FencingInspectionFacade();

        Weapon foil = new Weapon(
                "F001", WeaponType.FOIL,
                true, true, true
        );

        Weapon epee = new Weapon(
                "E001", WeaponType.EPEE,
                true, true, false
        );

        Weapon sabre = new Weapon(
                "S001", WeaponType.SABRE,
                true, false, true
        );

        facade.registerWeapon(foil);
        facade.registerWeapon(epee);
        facade.registerWeapon(sabre);

        System.out.println("\nWeapon Inspection");

        facade.inspectWeapon("F001");
        facade.inspectWeapon("E001");
        facade.inspectWeapon("S001");

        System.out.println("\nInspection History");

        System.out.println(
                "Foil inspections: " +
                        facade.getInspectionCount("F001")
        );

        System.out.println(
                "Epee last result: " +
                        facade.getLastResult("E001")
        );

        facade.inspectWeapon("F001");

        System.out.println(
                "Foil inspections after repeat: " +
                        facade.getInspectionCount("F001")
        );

        System.out.println("\nInspection Reasons");

        System.out.println(
                "Foil: " + facade.getLastReason("F001")
        );

        System.out.println(
                "Epee: " + facade.getLastReason("E001")
        );

        System.out.println(
                "Sabre: " + facade.getLastReason("S001")
        );


    }
}
