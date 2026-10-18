import java.util.HashMap;
import java.util.Map;
public class WeaponRegistry {
    private final Map<String,Weapon> weapons = new HashMap<>();
    public void registerWeapon(Weapon weapon){

        if (weapon == null) {
            throw new IllegalArgumentException(
                    "Weapon cannot be null"
            );
        }

        String serialNumber = weapon.getSerialNumber();
        if(weapons.containsKey(serialNumber)){
            throw new IllegalStateException(
                   "Weapon already registered: " + serialNumber
            );

        }
        weapons.put(serialNumber, weapon);
        System.out.println("Weapon registered: " + serialNumber);
    }

    public Weapon findWeapon(String serialNumber) {

        Weapon weapon = weapons.get(serialNumber);

        if (weapon == null) {
            throw new IllegalArgumentException(
                    "Weapon not found: " + serialNumber
            );
        }

        return weapon;
    }

}
