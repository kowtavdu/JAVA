package dynamicProgramming;
import java.util.ArrayList;
class Interval 
{
    int buy, sell;
}
public class StockBuySell {

	// This function finds the buy sell schedule for maximum profit
    void stockBuySell(int price[], int n) 
    {
    	System.out.println("--------DAY------"+n);
        // Prices must be given for at least two days
        if (n == 1)
            return;
         
        int count = 0;
        System.out.println("--------COUNT------"+count);
        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();
 
        // Traverse through given price array
        int i = 0;
        while (i < n - 1) 
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element. 
            while ((i < n - 1) && (price[i + 1] <= price[i]))
            	i++;
 
            // If we reached the end, break as no further solution possible
            System.out.println("IIIIIIIIIIII "+i+ " "+n);
            if (i == n - 1)
                break;
 
            Interval e = new Interval();
            e.buy = i++;
            System.out.println("####BUY#####"+e.buy+"DDDDDDDDDDDD ");
            // Store the index of minima
             
 
            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;
            System.out.println("IIIIIIIIHHHHHHHIII "+i+ " "+n);
            // Store the index of maxima
            e.sell = i-1;
            System.out.println("####SELL#####"+e.sell+"DDDDDDDDDDDD ");
            sol.add(e);
            // Increment number of buy/sell
            count++;
        }
 
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                                                  + "will make profit");
        else
        	System.out.println("DDDDDDDDDDDD COUNT "+count);
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);
         
        return;
    }
	public static void main(String args[]) 
    {
        StockBuySell stock = new StockBuySell();
         
        // stock prices on consecutive days
        int price[] = {100, 180, 260,  310, 40, 535, 695};
        //int price[] = {230, 99, 430, 499, 443, 567, 754, 755, 887,565,987,578,465};
        //110
        //int price[] = {100, 180, 260, 310, 40, 535, 695};
        //80, 80, 50, -270,495, 160
        int n = price.length;
        System.out.println("KKKKK LENGHTH "+n); 
        // fucntion call
        stock.stockBuySell(price, n);
    }
}
