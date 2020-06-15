package util;

public class Stock {

  public static void main(String[] args) {
    Stock stock = new Stock();
    System.out.println(stock.calcRet(300000, 8, 1.3f, 215, 295));
  }

  float calcRet(int total, int steps, float faction, int low, int high) {
    if (high <= low) {
      throw new RuntimeException("high should be larger than low");
    }

    if (faction < 1) {
      throw new RuntimeException("faction should be larger than 1 or equal to 1");
    }

    if (steps <= 2) {
      throw new RuntimeException("Steps should be larger then 2");
    }

    float total_fraction = 0;
    for (int i = 0; i <= steps; i ++) {
      float f = (float) Math.pow(faction, i);
      if (i == steps) {
        total_fraction += f;
      } else {
        total_fraction += 2 * f;
      }
    }

    float base = total / total_fraction;

    float span = ((float) (high - low)) / (steps);
    // float put = ((float) total) / (2 * steps + 1);
    float amount = 0;
    for (int i = 0; i <= steps; i ++) {
      float price = high - span * i;
      float put = (float) (base * Math.pow(faction, i));
      System.out.println("price: " + price + ", amount: " + (put / price));
      if (i == steps) {
        amount += put / price;
      } else {
        amount += (put / price) * 2;
      }
    }

    return  (amount * high - total) / total;
  }
}
