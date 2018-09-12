import java.util.*;
import java.text.*;

/**
 *  This class contains a method to convert the date format of the timePlaced variable of the TradeMessage object.
 *  
 *  @author Niall Campbell
 *  @version 1.0
 */
public class DateConverter
{
    /**
     *  This method converts a string into a Date object.
     *  
     *  @param      date             String that will be converted
     *  
     *  @return     dateConverted    A Date object of the date
     * 
     */
    public static Date convertDate(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        
        try{
            Date dateConverted = format.parse(date);
            return dateConverted;
        }
        catch(ParseException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
