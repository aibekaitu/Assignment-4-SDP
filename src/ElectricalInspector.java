
public class ElectricalInspector {

    public boolean inspect(Weapon weapon) {

        if (weapon == null) {
            throw new IllegalArgumentException(
                    "Weapon cannot be null"
            );
        }

        if (!weapon.isCircuitWorking()) {
            System.out.println("Electrical circuit is not working!");
            return false;
        }

        System.out.println("Electrical circuit is working!");
        return true;
    }
}
