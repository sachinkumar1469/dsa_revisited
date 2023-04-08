package questions;

public class Q_07_MaxProfitInStock {

    public static int maxProfit(int[] price){

        var lowestPrice = price[0];
        var profit = 0;

        for(var i=0;i<price.length;i++){
            if(price[i]>lowestPrice){
                var currProfit = price[i]-lowestPrice;
                if(currProfit>profit){
                    profit = currProfit;
                }
            } else {
                lowestPrice = price[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int price[] = {0,7,1,5,3,2,4};
        int max = maxProfit(price);
        System.out.println(max);
    }
}
