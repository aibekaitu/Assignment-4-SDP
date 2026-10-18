public class SafetyInspector {

    public boolean inspect(Weapon weapon) {

        if (weapon == null) {
            throw new IllegalArgumentException(
                    "Weapon cannot be null"
            );
        }

        boolean safe = true;

        if (!weapon.isBladeIntract()) {
            System.out.println("Blade is damaged!");
            safe = false;
        }

        if (!weapon.isGuardSecure()) {
            System.out.println("Guard is not secure!");
            safe = false;
        }

        return safe;
    }
}
