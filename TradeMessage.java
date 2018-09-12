import java.util.*;
import java.text.*;

/**
 *  This class is used to create TradeMessage objects that are populated from the information in the JSON trade files. 
 *  
 *  @author Niall Campbell
 *  @version 1.0
 *  
 */
public class TradeMessage
{
    /**
     *  Instance variables/ 
     */
    private long userID;
    private String currencyFrom;
    private String currencyTo;
    private double amountSell;
    private double amountBuy;
    private double rate;
    private Date timePlaced;
    private String originatingCountry;
    
    
    /**
     * Default constructor for objects of class TradeMessage
     */
    public TradeMessage()
    {
        
    }
    
    public void setUserID(long userID)
    {
        this.userID = userID;
    }
    
    public long getUserID()
    {
        return userID;
    }
    
    public void setCurrencyFrom(String currencyFrom)
    {
        this.currencyFrom = currencyFrom;
    }
    
    public String getCurrencyFrom()
    {
        return currencyFrom;
    }
    
    public void setCurrencyTo(String currencyTo)
    {
        this.currencyTo = currencyTo;
    }
    
    public String getCurrencyTo()
    {
        return currencyTo;
    }
    
    public void setAmountSell(String amountSell)
    {
        this.amountSell = Double.parseDouble(amountSell);
    }
    
    public double getAmountSell()
    {
        return amountSell;
    }
    
    public void setAmountBuy(String amountBuy)
    {
        this.amountBuy = Double.parseDouble(amountBuy);
    }
    
    public double getAmountBuy()
    {
        return amountBuy;
    }
    
    public void setRate(double rate)
    {
        this.rate = rate;
    }
    
    public double getRate()
    {
        return rate;
    }
    
    public void setTimePlaced(String timePlaced)
    {
        this.timePlaced = DateConverter.convertDate(timePlaced);
    }
    
    public Date getTimePlaced()
    {
        return timePlaced;
    }
    
    public void setOriginatingCountry(String originatingCountry)
    {
        this.originatingCountry = originatingCountry;
    }
    
    public String getOriginatingCountry()
    {
        return originatingCountry;
    }
    
}
