package decorator;

public class FlatBreadPizza extends Pizza{
    @Override
public  String description(){
  return "Flat Bread";
 }
 
 @Override
 public  double cost(){
  return 200.0;
 }

}