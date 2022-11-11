package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KnapsackProblem {
    private static int knapSackCapacity;
    private static List<Item> allItems;

    public static void main(String[] args) {
        setUpTourist();
        int[][] calcTable = new int[allItems.size()][knapSackCapacity];
        for (int i = 0; i < calcTable.length; i++) {
            int currentItemCost = allItems.get(i).cost;
            int currentItemWeight = allItems.get(i).weight;
            for (int j = 0; j < calcTable[i].length; j++) {
                int prevMaxCost = 0;
                int newCost = 0;
                int remainingWeight = j + 1 - currentItemWeight;

                if (i == 0){
                    newCost = remainingWeight >= 0 ? currentItemCost : 0;
                } else {
                    prevMaxCost = calcTable[i-1][j];
                    newCost = remainingWeight == 0 ? currentItemCost : (
                            remainingWeight > 0 ? currentItemCost + calcTable[i-1][remainingWeight-1] : 0) ;
                }
                calcTable[i][j] = Math.max(prevMaxCost, newCost);
                System.out.print(calcTable[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Result weight : " + calcTable[allItems.size()-1][knapSackCapacity-1]);

        Set<String> result = getObjectsList(calcTable);
        System.out.println("Result : " + result);
    }

    private static Set<String> getObjectsList(int[][] calcTable) {
        Set<String> result = new HashSet<>();
        int i = allItems.size()-1;
        int j = knapSackCapacity-1;
        int weight = 0;
        int sum = calcTable[i][j];

        while (weight < knapSackCapacity && sum > 0){
            if (calcTable[i][j] > sum){
                j--;
                continue;
            }
            if (i != 0 && calcTable[i][j] <= calcTable[i-1][j]){
                i--;
                continue;
            }
            Item currentItem = allItems.get(i);
            result.add(currentItem.name);
            weight += currentItem.weight;
            sum -= currentItem.cost;
            i--;
            j--;
        }
        return result;

    }

    private static void setUpKnapsack(){
        knapSackCapacity = 4;
        allItems = new ArrayList<>(List.of(
                new Item("guitar", 1, 1500),
                new Item("stereo", 4, 3000),
                new Item("laptop", 3, 2000)
                , new Item("iphone", 1, 2000)
        ));
    }
    private static void setUpTourist(){
        knapSackCapacity = 6;
        allItems = new ArrayList<>(List.of(
                new Item("water", 3, 10),
                new Item("book", 1, 3),
                new Item("food", 2, 9),
                new Item("coat", 2, 5)
                , new Item("camera", 1, 6)
        ));
    }

    static class Item{
        String name;
        int weight;
        int cost;

        public Item(String name, int weight, int cost) {
            this.name = name;
            this.weight = weight;
            this.cost = cost;
        }
    }

}
