package algos;

public class BestDayToSell {
    public static void main(String[] args){
        int[] prices = {7,6,5,4,3,2};

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;                 // best day to buy so far
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);  // best sell today
            }
        }

        System.out.println(maxProfit);
    }
}

