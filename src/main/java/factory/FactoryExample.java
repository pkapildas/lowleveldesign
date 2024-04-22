package factory;

public class FactoryExample {
    Shape getShape(String type){
        Shape shape =null;
        if(type =="circle"){
       //   shape =  new Circle();
        }
        else if (type =="Rect"){
          //  shape = new Rectangle();
        }
        return shape;
    }
}
