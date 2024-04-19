package observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable  implements StockObservable{
int stockCount =0;
    List<NotificationAlertObserver> observers = new ArrayList<>();
    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver observer : observers){
            observer.update();
        }

    }

    @Override
    public void setStockCount(int count) {
        if(stockCount ==0){
            notifySubscriber();
        }
        stockCount+= count;

    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
