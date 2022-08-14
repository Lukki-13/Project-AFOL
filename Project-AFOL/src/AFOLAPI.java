import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
                throw new AFOLNoRegionSetException("Region must be set!");
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
        return search(""+setnumber).get(0);
    }

    /**
     * Searchs for the Set with the Setname.
     * 
     * @param setname
     * Setname (Example: First Responder)
     * 
     * @return
     * Setinformation from lego.com of matching sets.
     * 
     * @throws AFOLSetNotFoundException
     * Set was not found. Maybe the name is wrong.
     */
    public List<AFOLSet> searchSet(String setname) throws AFOLSetNotFoundException {
        return search(setname);
    }

    /**
     * Searchs sets on lego.com and returns a list with matching sets.
     * 
     * @param searchData
     * A string with data to find the matching sets
     * 
     * @return
     * A list with matching sets
     * 
     * @throws AFOLSetNotFoundException
     * With the searchdata no set was found
     */
    private List<AFOLSet> search(String searchData) throws AFOLSetNotFoundException {
        try {
            // Create a neat value object to hold the URL
            URL url = new URL(getURL()+"/search?q="+searchData);

            // Open a connection(?) on the URL(??) and cast the response(???)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");

            // This line makes the request
            InputStream responseStream = connection.getInputStream();

            Scanner scanner = new Scanner(responseStream);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<AFOLSet> sets = new ArrayList<AFOLSet>();
        
        sets.add(new AFOLSet(0, "Test", AFOLTheme.CLASSIC, 0, false, (short)0, 0));
        return sets;
    }

}