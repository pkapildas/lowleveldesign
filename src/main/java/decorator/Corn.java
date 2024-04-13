package decorator;

public class Corn extends Topping{
Pizza pizza;
public Corn(Pizza pizza){
  this.pizza = pizza;
 }
 
 public   String description(){
  return this.pizza.description() + ", Cheese";
 }
public   double cost(){
  return this.pizza.cost() + 15.0;
 }
}