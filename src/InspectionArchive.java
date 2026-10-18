
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InspectionArchive {

    private final Map<String, List<InspectionRecord>> history =
            new HashMap<>();

    public void saveResult(InspectionRecord record) {

        if (record == null) {
            throw new IllegalArgumentException(
                    "Inspection record cannot be null"
            );
        }

        String serialNumber = record.getSerialNumber();

        if (!history.containsKey(serialNumber)) {
            history.put(serialNumber, new ArrayList<>());
        }

        history.get(serialNumber).add(record);

        System.out.println("Result saved: " + serialNumber);
    }

    public int getInspectionCount(String serialNumber) {

        if (!history.containsKey(serialNumber)) {
            return 0;
        }

        return history.get(serialNumber).size();
    }

    public InspectionRecord getLastRecord(String serialNumber) {

        List<InspectionRecord> records = history.get(serialNumber);

        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException(
                    "No inspection history found"
            );
        }

        return records.get(records.size() - 1);
    }

    public boolean getLastResult(String serialNumber) {
        return getLastRecord(serialNumber).isApproved();
    }
}
