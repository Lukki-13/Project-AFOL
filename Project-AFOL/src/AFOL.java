import exceptions.AFOLNoRegionSetException;
import exceptions.AFOLSetNotFoundException;

public class AFOL {
    public static void main(String[] args) {
        try {
            AFOLAPI api = AFOLAPI.getInstance(AFOLRegion.DE);
            api.searchSet(42075);
        } catch (AFOLSetNotFoundException | AFOLNoRegionSetException e) {
            e.printStackTrace();
        }
    }
}
