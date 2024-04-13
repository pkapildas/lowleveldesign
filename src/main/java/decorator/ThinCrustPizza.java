package decorator;

public class ThinCrustPizza extends Pizza{

 @Override
public  String description(){
  return "Thin Crust";
 }
 
 @Override
 public  double cost(){
  return 200.0;
 }
}