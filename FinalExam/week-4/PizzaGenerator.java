// https://leetcode.com/playground/5KBhRBtv

import java.util.*;

public class PizzaGenerator {
    private static final List<String> toppings = new ArrayList<>();
    private static final int basePrice = 8;
    private static final Map<String, Integer> prices = new HashMap<>();

    static {
        toppings.add("ham");
        toppings.add("salami");
        toppings.add("mushroom");
        toppings.add("spinach");
        toppings.add("artichoke");

        prices.put("ham", 2);
        prices.put("salami", 3);
        prices.put("mushroom", 1);
        prices.put("spinach", 1);
        prices.put("artichoke", 2);
    }

    public static List<String> generatePizzas() {
        List<String> pizzas = new ArrayList<>();

        for (int i = 0; i < toppings.size() - 2; i++) {
            for (int j = i + 1; j < toppings.size() - 1; j++) {
                for (int k = j + 1; k < toppings.size(); k++) {
                    String[] pizza = new String[]{
                            toppings.get(i),
                            toppings.get(j),
                            toppings.get(k)
                    };
                    Arrays.sort(pizza);

                    int price = basePrice;
                    for (int l = 0; l < pizza.length; l++) {
                        price += prices.get(pizza[l]);
                    }

                    pizzas.add(String.join(", ", pizza) + " - " + price);
                }
            }
        }

        return pizzas;
    }

    public static void main(String[] args) {
        System.out.println(generatePizzas());
    }
}
