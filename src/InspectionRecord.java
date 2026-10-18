
public class InspectionRecord {

    private final String serialNumber;
    private final boolean safetyPassed;
    private final boolean electricalPassed;
    private final boolean approved;

    public InspectionRecord(String serialNumber,
                            boolean safetyPassed,
                            boolean electricalPassed,
                            boolean approved) {

        this.serialNumber = serialNumber;
        this.safetyPassed = safetyPassed;
        this.electricalPassed = electricalPassed;
        this.approved = approved;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isSafetyPassed() {
        return safetyPassed;
    }

    public boolean isElectricalPassed() {
        return electricalPassed;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getReason() {

        if (approved) {
            return "All checks passed";
        }

        if (!safetyPassed && !electricalPassed) {
            return "Safety and electrical checks failed";
        }

        if (!safetyPassed) {
            return "Safety check failed";
        }

        return "Electrical check failed";
    }
}
