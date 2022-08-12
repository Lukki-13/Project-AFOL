import exceptions.*;

public class AFOLAPI {
    
    private AFOLRegion region;

    private static final String url = "https://www.lego.com/";

    private static AFOLAPI instance;

    private AFOLAPI(AFOLRegion region) {
        this.region = region;
    }

    /**
     * Get the lego.com URL with language code.
     * 
     * @return
     * The url with language code.
     */
    public String getURL() {
        return url+region.getRegioncode();
    }

    /**
     * Get the instance for working with the API.
     * With the API you can search for Sets and Actions from lego.com.
     * 
     * @param region
     * The language region
     * 
     * @return
     * The working instance for the correct language region
     */
    public static AFOLAPI getInstance(AFOLRegion region) throws AFOLNoRegionSetException {
        if(instance == null) {
            if(region != null) {
                instance = new AFOLAPI(region);
            } else {
                throw new AFOLNoRegionSetException();
            }
        }

        return instance;
    }

    /**
     * Searchs for the Set with the Setnumber.
     * 
     * @param setnumber
     * Setnumber (Example: 42075)
     * The number must be greater than zero.
     * 
     * @return
     * The Setinformation from lego.com with instruction representated
     * as an Object.
     * 
     * @throws AFOLSetNotFoundException
     * Set was not found. Maybe the number is not existing.
     */
    public AFOLSet searchSet(int setnumber) throws AFOLSetNotFoundException {
        return null;
    }

    /**
     * Searchs for the Set with the Setname.
     * 
     * @param setname
     * Setname (Example: First Responder)
     * 
     * @return
     * The Setinformation from lego.com with instruction representated
     * as an Object.
     * 
     * @throws AFOLSetNotFoundException
     * Set was not found. Maybe the name is wrong.
     */
    public AFOLSet searchSet(String setname) throws AFOLSetNotFoundException {
        return null;
    }

}