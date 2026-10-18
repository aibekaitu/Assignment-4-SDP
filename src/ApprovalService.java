
public class ApprovalService {

    public boolean approve(Weapon weapon,
                           boolean safetyPassed,
                           boolean electricalPassed) {

        if (weapon == null) {
            throw new IllegalArgumentException(
                    "Weapon cannot be null"
            );
        }

        boolean approved = safetyPassed && electricalPassed;

        if (approved) {
            System.out.println(
                    weapon.getSerialNumber() + " APPROVED"
            );
        } else {
            System.out.println(
                    weapon.getSerialNumber() + " REJECTED"
            );
        }

        return approved;
    }
}
