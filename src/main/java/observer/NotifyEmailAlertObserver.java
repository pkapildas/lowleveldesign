package observer;

public class NotifyEmailAlertObserver  implements  NotificationAlertObserver{
    private String email ;
    StockObservable stockObservable;

    public NotifyEmailAlertObserver(String email, StockObservable stockObservable) {
        this.email = email;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Send Email");
    }
}
