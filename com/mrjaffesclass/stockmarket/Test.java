import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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
            
            file.write("Date,Close");
            for(StockPrice price : prices){
                file.write(price.getDate() + "," + price.getClose() + "\n");
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
