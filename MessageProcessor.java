import java.util.*;

/**
 *  This class will analyse the TradeMessage objects for various trends.
 *  
 *  JSON File example:
 *  
 *      {"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}
 *  
 */
public class MessageProcessor
{
   /**
    *   This method prints the average amount of each currency sold.
    *   
    *   @param      map     HashMap containing the TradeMessage objects
    *   
    *   @return     void
    * 
    */
    public static void averageAmountOfCurrencySold(HashMap<Integer, TradeMessage> map)
    {   
        double transactionCountEUR = 0;
        double transactionCountGBP = 0;
        
        double totalEUR = 0;
        double totalGBP = 0;
        
        Set set = map.entrySet();
        Iterator iterator = set.iterator(); //Used to iterate through the set of TradeMessage objects. 
        
        while(iterator.hasNext())
        {
            Map.Entry mEntry = (Map.Entry)iterator.next();
            
            TradeMessage message = (TradeMessage) mEntry.getValue();
            
            if(message.getCurrencyFrom().equals("EUR"))
            {
                totalEUR += message.getAmountSell();
                transactionCountEUR++;
            }
            else if(message.getCurrencyFrom().equals("GBP"))
            {
                totalGBP += message.getAmountSell();
                transactionCountGBP++;
            }
            
        }
        
        System.out.println("The average amount of Euro sold is " + (totalEUR/transactionCountEUR));
        System.out.println("The average amount of GBP sold is " + (totalGBP/transactionCountGBP));
        System.out.println();
    }
   
    /**
    *   This method prints the average amount of each currency purchased. 
    *   
    *   @param      map     HashMap containing the TradeMessage objects
    *   
    *   @return     void
    * 
    */
    public static void averageAmountCurrencyPurchased(HashMap<Integer, TradeMessage> map)
    {
        double amountEUR = 0;
        double amountGBP = 0;
        
        double transCountEUR = 0;
        double transCountGBP = 0;
        
        Set set = map.entrySet();    
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext())
        {
            Map.Entry mEntry = (Map.Entry)iterator.next();
            
            TradeMessage message = (TradeMessage) mEntry.getValue();
            
            if(message.getCurrencyTo().equals("EUR"))
            {
                amountEUR += message.getAmountBuy();
                transCountEUR++;
            }
            else if(message.getCurrencyTo().equals("GBP"))
            {
                amountGBP += message.getAmountBuy();
                transCountGBP++;
            }
            
        }
        
        System.out.println("The average amount of EUR purchased is €" + amountEUR/transCountEUR);
        System.out.println("The average amount of GBP purchased is £" + amountGBP/transCountGBP);
        System.out.println();
    }
    
    /**
    *   This method prints the percentage of trades between the two currencies € & £ 
    *   
    *   @param      map     HashMap containing the TradeMessage objects
    *   
    *   @return     void
    * 
    */
    public static void mostpopularExchanges(HashMap<Integer, TradeMessage> map)
    {
        int totalTransactions = map.size();
        
        double transactionCountEURtoGBP = 0;
        double transactionCountGBPtoEUR = 0;
        
        Set set = map.entrySet();    
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext())
        {
            Map.Entry mEntry = (Map.Entry)iterator.next();
            
            TradeMessage message = (TradeMessage) mEntry.getValue();
            
            if(message.getCurrencyFrom().equals("EUR") && message.getCurrencyTo().equals("GBP"))
            {
                transactionCountEURtoGBP++;
            }
            else if(message.getCurrencyFrom().equals("GBP") && message.getCurrencyTo().equals("EUR"))
            {
                transactionCountGBPtoEUR++;
            }
            
        }
        
        System.out.println("The percentage of trades from EUR to GBP is: " + transactionCountEURtoGBP/totalTransactions + "%");
        System.out.println("The percentage of trades from GBP to EUR is: " + transactionCountGBPtoEUR/totalTransactions + "%");
        System.out.println();
    }
    
    /**
    *   This method prints the average exchange rates between the two currencies € & £ 
    *   
    *   @param      map     HashMap containing the TradeMessage objects
    *   
    *   @return     void
    * 
    */
    public static void averageRate(HashMap<Integer, TradeMessage> map)
    {
        double rateEUR = 0;
        double rateGBP = 0;
        
        double transCountEUR = 0;
        double transCountGBP = 0;
        
        Set set = map.entrySet();    
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext())
        {
            Map.Entry mEntry = (Map.Entry)iterator.next();
            
            TradeMessage message = (TradeMessage) mEntry.getValue();
            
            if(message.getCurrencyFrom().equals("EUR") && message.getCurrencyTo().equals("GBP"))
            {
                rateEUR += message.getRate();
                transCountEUR++;
            }
            else if(message.getCurrencyFrom().equals("GBP") && message.getCurrencyTo().equals("EUR"))
            {
                rateGBP += message.getRate();
                transCountGBP++;
            }
            
        }
        
        System.out.println("The average rate from EUR to GBP is: " + rateEUR/transCountEUR + "%");
        System.out.println("The percentage of trades from GBP to EUR is: " + rateGBP/transCountGBP + "%");
        System.out.println();
    }
}
