
public class FencingInspectionFacade {

    private final WeaponRegistry registry;
    private final SafetyInspector safetyInspector;
    private final ElectricalInspector electricalInspector;
    private final ApprovalService approvalService;
    private final InspectionArchive archive;

    public FencingInspectionFacade() {
        registry = new WeaponRegistry();
        safetyInspector = new SafetyInspector();
        electricalInspector = new ElectricalInspector();
        approvalService = new ApprovalService();
        archive = new InspectionArchive();
    }

    public void registerWeapon(Weapon weapon) {
        registry.registerWeapon(weapon);
    }


    public boolean inspectWeapon(String serialNumber) {

        Weapon weapon = registry.findWeapon(serialNumber);

        boolean safetyPassed = safetyInspector.inspect(weapon);

        boolean electricalPassed =
                electricalInspector.inspect(weapon);

        boolean approved = approvalService.approve(
                weapon, safetyPassed, electricalPassed
        );

        InspectionRecord record = new InspectionRecord(
                weapon.getSerialNumber(),
                safetyPassed,
                electricalPassed,
                approved
        );

        archive.saveResult(record);

        return approved;
    }


    public int getInspectionCount(String serialNumber) {
        return archive.getInspectionCount(serialNumber);
    }

    public boolean getLastResult(String serialNumber) {
        return archive.getLastResult(serialNumber);
    }

    public String getLastReason(String serialNumber) {
        return archive.getLastRecord(serialNumber).getReason();
    }
}
