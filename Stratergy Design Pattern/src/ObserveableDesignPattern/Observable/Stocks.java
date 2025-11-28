package ObserveableDesignPattern.Observable;

public interface Stocks {

    //public void add(NotificationAlertObserver observer);
    //public void remove(NotificationAlertObserver observer);
    public void notifySubscriber();
    public void setStockCount(int newStockCount);
    public int getStockCount();

}
