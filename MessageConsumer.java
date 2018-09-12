import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;
import java.lang.Number;

/**
 *  This class will read in a JSON file and convert use its information to populate a TradeMessage object. 
 *  
 *  @author Niall Campbell
 *  @version 1.0
 *  
 *  JSON trade file example:
 *  
 *      {"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}
 *  
 */
public class MessageConsumer
{   
    /**
     *  The following method will read in and parse a JSON trade file.
     *  It will then use the info from this file to populate a TradeMessage object. 
     *  
     *  @param      String    String containing the file path of the JSON file.
     *  
     *  @return     TradeMessage    A TradeMessage object containing the info from the JSON file. 
     * 
     */
    public static TradeMessage readInJSONFile(String filePath)
    {
        JSONParser parser = new JSONParser();
        
        TradeMessage message = new TradeMessage();
        
        try{
            Object obj = parser.parse(new FileReader(filePath));
            
            JSONObject jsonObject = (JSONObject) obj; //Convert this object to a JSON object
            
            //Populate the TradeMessage object with the info from the JSON file
            message.setUserID((long) jsonObject.get("userId"));
            message.setCurrencyFrom((String) jsonObject.get("currencyFrom"));
            message.setCurrencyTo((String) jsonObject.get("currencyTo"));
            message.setAmountSell((String) jsonObject.get("amountSell"));
            message.setAmountBuy((String) jsonObject.get("amountBuy"));
            message.setRate((double) jsonObject.get("rate"));
            message.setTimePlaced((String) jsonObject.get("timePlaced"));
            message.setOriginatingCountry((String) jsonObject.get("originatingCountry"));
           
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return message;
    }
}
