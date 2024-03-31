public class Onion extends Topping{
Pizza pizza;
public Onion(Pizza pizza){
  this.pizza = pizza;
 }
 
 public   String description(){
  return this.pizza.description() + ', Onion';
 }
public   double cost(){
  return this.pizza.cost() + 15.0;
 }
}