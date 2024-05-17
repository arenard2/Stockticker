import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Test
{
    StockGetHistory stock;
    String apiKey  = new String("GA7WMEXJR2TJSHAH");
    String company = new String("aapl");
    
    
    public Test()
    {
        stock = new StockGetHistory(apiKey, company);
    }
    
    public void write()
    {
        try{
            FileWriter file = new FileWriter(company + ".csv");
            
            ArrayList<StockPrice> prices = stock.getStockPrices();
            
            file.write("Date,Close\n");
            for(StockPrice price : prices){
                Calendar cal = price.getDate();
                file.write("" + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "," + price.getClose() + "\n");
            }
            
            file.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        Test t = new Test();
        t.write();
    }
}
