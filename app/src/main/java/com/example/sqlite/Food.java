/**
 * This class helps store and manipulate information about food
 * 
 */
package com.example.sqlite;
public class Food{
    private int carbohydrates = 0;
    private int fibers = 0;
    
    private String name = "";
    private String subsectionOfFood = "";
    private String picture = "";

    /**
     * 
     * @param carb stores the amount of carbohydrates of a food
     * @param fib stores the amount of fibers of a a food
     * 
     * @param nam stores the name of the food
     * @param subsection stores the kind of food
     * @param pic stores a picture of the food
     */
    public Food(int carb, int fib, String nam, String subsection, String pic){
        this.carbohydrates = carb;
        this.fibers = fib;
        
        this.name = nam;
        this.subsectionOfFood = subsection;
        this.picture = pic;
    }

    public Food(int carb, String nam, String subsection, String pic){
        this.carbohydrates = carb;
        this.fibers = 0;
        
        this.name = nam;
        this.subsectionOfFood = subsection;
        this.picture = pic;
    }

    public Food(int carb, int fib, String nam, String subsection){
        this.carbohydrates = carb;
        this.fibers = fib;
        
        this.name = nam;
        this.subsectionOfFood = subsection;
        this.picture = null;
    }
    
    public Food(int carb, String nam, String subsection){
        this.carbohydrates = carb;
        this.fibers = 0;
        
        this.name = nam;
        this.subsectionOfFood = subsection;
        this.picture = null;
    }


    public int getCarbohydrates(){
        return carbohydrates;
    }

    public int getFibers(){
        return fibers;
    }

    public String getName(){
        return name;
    }

    public String getSubsectionOfFood(){
        return subsectionOfFood;
    }

    public String getPicture(){
        return picture;
    }

    public void setCarbohydrates(int carb){
        this.carbohydrates = carb;
    }

    public void setFibers(int fib){
        this.fibers = fib;
    }

    public void setName(String nam){
        this.name = nam;
    }

    public void setSubsectionOfFood(String subSection){
        this.subsectionOfFood = subSection;
    }

    public void setPicture(String pic){
        this.picture = pic;
    }

    public void incrementCarbohydrates(){
        this.carbohydrates++;
    }

    public void decrementCarbohydrates(){
        this.carbohydrates--;
    }

    public void incrementFibers(){
        this.fibers++;
    }

    public void decrementFibers(){
        this.fibers--;
    }

    public String toString(){
        return "Here is information about " + this.name + ", part of "+this.subsectionOfFood+" which contains the following:\ncarbs: " + this.carbohydrates+"\nfibers: "+this.fibers+"\nThe picture associated to this Food is stored as "+this.picture+".";
    }
}
