package com.example.sqlite;

import com.example.sqlite.Food;

import java.util.ArrayList;

public class SavedMeal{

    private ArrayList<Food> listOfFood = new ArrayList<Food>();
    private String typeOfMeal;

    public SavedMeal(){
        this.typeOfMeal = "";
    }

    public SavedMeal(ArrayList<Food> listOfFoodIn,String typeOfMealIn){
        for (int i = 0; i<listOfFoodIn.size();i++){
            this.listOfFood.add(listOfFoodIn.get(i));
        }
        this.typeOfMeal = typeOfMealIn;
    }

    public void additionOfFood(Food foodIn){
        this.listOfFood.add(foodIn);
    }

    public void setPropertyClass(String foodClass){
        this.typeOfMeal = foodClass;
    }

    public ArrayList<Food> getListOfFood(){
        return listOfFood;
    }

    public String getTypeOfMeal(){
        return typeOfMeal;
    }
    public String toString(){
      String tmp="Type of meal is: "+ typeOfMeal+" and contains the following food: ";
      for(int i=0; i<listOfFood.size();i++){
        tmp+=listOfFood.get(i)+",";
    }
    return tmp;
  }
}
