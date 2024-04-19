package observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockObservable iphoneNotify = new IphoneObservable();
        NotificationAlertObserver observer1 = new NotifyEmailAlertObserver("aaa@ee.com", iphoneNotify);
        iphoneNotify.add(observer1);
        iphoneNotify.setStockCount(10);
    }
}
