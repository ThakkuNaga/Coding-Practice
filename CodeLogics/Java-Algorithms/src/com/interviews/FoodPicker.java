package com.interviews;
import java.util.ArrayDeque;
// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.util.ArrayList;

/**
 * There are two refrigerators in the kitchen.
 * One holds vegetables.
 * One holds meat.
 * 
 * A hungry person can choose to eat one of the following at a time:
 * 1. vegetables
 * 2. meat
 * 3. no preference (vegetable or meat)
 * 
 * When a person is hungry that person must eat the item that has been in the
 * refrigerator the longest time.
 * 
 * For example,
 * If the person wants a vegetable item then that person must take the item in
 * the vegetable refrigerator that was put in there first (relative to the other
 * items in that refrigerator).
 * 
 * If the person wants a meat item then that person must take the item in the
 * meat refrigerator that was put in there first (relative to the other items in that
 * refrigerator).
 * 
 * If the person has no preference then that person must take the item
 * (vegetable item or meat item) that was put in the refrigerator first (relative to the
 * other items in either of the two refrigerators).
 * 
 * Implement operations for:
 * 1. Adding an item to the proper fridge
 * 2. Removing a vegetable item or a meat item from the fridge // getFood
 * 3. Removing a vegetable item from the fridge // getVeggie
 * 4. Removing a meat item from the fridge // getMeat
 */

class FoodPicker {

    static ArrayDeque<String> meatQ = new ArrayDeque<>();
    static ArrayDeque<String> veggieQ = new ArrayDeque<>();

    public static void main(String[] args) {

        ArrayList<Food> foodItem = new ArrayList<>();
        Food food1 = new Food("meat", "chicken");
        Food food2 = new Food("meat", "beef");
        foodItem.add(food1);
        foodItem.add(food2);
        Food food3 = new Food("veggie", "carrot");
        Food food4 = new Food("veggie", "poteto");
        foodItem.add(food3);
        foodItem.add(food4);

        addFood(foodItem);

        System.out.println("Meat Refrigrator:"+meatQ);
        System.out.println("Veg Refrigrator:"+veggieQ);

        getVeggie();
        getMeat();
        getFood();

        System.out.println("Meat Refrigrator:"+meatQ);
        System.out.println("Veg Refrigrator:"+veggieQ);

        getVeggie();
        getMeat();
        getFood();

    }

    static void addFood(ArrayList<Food> foodItem) {

        for (Food food : foodItem) {
            if (food.type.equalsIgnoreCase("meat")) {
                meatQ.offerLast(food.item);
            } else if (food.type.equalsIgnoreCase("veggie")) {
                veggieQ.offerLast(food.item);
            }
        }

    }

    private static void getMeat() {
        System.out.println("Meat >> "+meatQ.pollFirst());
    }

    private static void getVeggie() {
        System.out.println("Veg >> "+veggieQ.pollFirst());
    }
    static void getFood() {
        if(veggieQ.size()>0){
            System.out.println("Food >> "+veggieQ.pollFirst());
        }else{
            System.out.println("Food >> "+meatQ.pollFirst());
        }
        
    }

}

class Food {

    String type;
    String item;

    Food(String type, String item) {
        this.type = type;
        this.item = item;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    


}
