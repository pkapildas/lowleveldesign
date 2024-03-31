public class OrderPizza{
    
    public OrderPizza(String pizzaName){
        this(pizzaName,false,false,false);
    } 
    
 public OrderPizza(String pizzaName, Boolean addCheese, Boolean addCorn, Boolean addOnion){
        Pizza pizza = null;
        if(pizzaName == 'Thin Crust'){
            pizza = new ThinCrustPizza();
        }
        if(pizzaName == 'Flat Bread'){
             pizza = new FlatBreadPizza();
           
        }
        if(pizza != null){
              displayItems(pizza);
                if(addCheese){
                    pizza = new Cheese(pizza);
                    displayItems(pizza);
                }
                
                if(addCorn){
                    pizza = new Corn(pizza);
                      displayItems(pizza);
                }
              
                if(addOnion){
                    pizza = new Onion(pizza);
                    displayItems(pizza);
                }
                
            }
        
 }
    
    void displayItems(Pizza pizza){
         System.debug('Added '+pizza.description()+ ', Total is Rs. '+pizza.cost());
    }
}