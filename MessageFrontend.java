import java.util.*;

/**
 *    This class will present the data from the JSON message files.
 *    
 *    @author Niall Campbell
 *    @version 1.0
 *    
 */
public class MessageFrontend
{
    /**
     *  The main class is used to run the other classes.
     *  
     *  A HashMap object is created to store the TradeMessage objects.
     *  
     *  Each JSON file is read in and converted to a TradeMessage object. Each object is stored in the HashMap.
     *  
     *  The methods from the MessageProcessor class are then run on these messages. 
     *  
     *  @param none
     *  @return none
     *  
     */
    public static void main()
    {
        HashMap<Integer, TradeMessage> map = new HashMap<Integer, TradeMessage>(); 
        
        TradeMessage message1 = new TradeMessage();
        TradeMessage message2 = new TradeMessage();
        TradeMessage message3 = new TradeMessage();
        TradeMessage message4 = new TradeMessage();
        TradeMessage message5 = new TradeMessage();
        
        String filePath1 = "JSON_Files\\test1.json";
        message1 = MessageConsumer.readInJSONFile(filePath1);
        map.put(1, message1);
        
        String filePath2 = "JSON_Files\\test2.json";
        message2 = MessageConsumer.readInJSONFile(filePath2);
        map.put(2, message2);
        
        String filePath3 = "JSON_Files\\test3.json";
        message3 = MessageConsumer.readInJSONFile(filePath3);
        map.put(3, message3);
        
        String filePath4 = "JSON_Files\\test4.json";
        message4 = MessageConsumer.readInJSONFile(filePath4);
        map.put(4, message4);
        
        String filePath5 = "JSON_Files\\test5.json";
        message5 = MessageConsumer.readInJSONFile(filePath5);
        map.put(5, message5);
        
        //Prints the average amount sold of each currency
        MessageProcessor.averageAmountOfCurrencySold(map);
        
        //Prints the average amount of each currency purchased
        MessageProcessor.averageAmountCurrencyPurchased(map);
        
        //Prints the percentage of each type of exchange
        MessageProcessor.mostpopularExchanges(map);
        
        //Prints the average exchange rate of each type of conversion
        MessageProcessor.averageRate(map);
    }
}
