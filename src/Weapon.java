public class Weapon {
    private String serialNumber;
    private WeaponType type;
    private boolean bladeIntract;
    private boolean guardSecure;
    private boolean circuitWorking;
    public Weapon(String serialNumber, WeaponType type, boolean bladeIntract, boolean guardSecure, boolean circuitWorking){
        this.bladeIntract=bladeIntract;
        this.circuitWorking=circuitWorking;
        this.guardSecure=guardSecure;
        this.type=type;
        this.serialNumber=serialNumber;
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public WeaponType getType(){
        return type;
    }
    public boolean isBladeIntract(){
        return bladeIntract;
    }

    public boolean isCircuitWorking() {
        return circuitWorking;
    }

    public boolean isGuardSecure() {
        return guardSecure;
    }
}
