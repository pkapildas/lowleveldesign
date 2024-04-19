package observer;

public interface StockObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscriber();
    void setStockCount(int count);
    int getStockCount();
}
