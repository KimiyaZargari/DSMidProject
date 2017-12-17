/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class Service {
    private String data;
    private Service next;
    private Service subService;
    private int numOfAgenciesUsing;

    public Service(String data) {
        this.data = data;
        this.next = null;
    }

    public Service() {
        data = null;
        next = null;
    }

    /**
     * creates a node with the given data and sets it as the next node
     * @param data data of the next node
     * @return next node
     */
    public Service addNext(String data) {
        if (next == null)
            next = new Service(data);
        else {
            Service newService = new Service(data);
            newService.setNext(next);
            next = newService;

        }
        return next;
    }

    /**
     * creates a node and adds it as a sub node
     * @param data data of the sub node
     */
    public void addSub(String data) {
        if (subService == null) {
            subService = new Service(data);
        } else {
            Service temp = subService;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Service(data);


        }
    }

    public int getNumOfAgenciesUsing() {
        return numOfAgenciesUsing;
    }

    public void setNumOfAgenciesUsing(int numOfAgenciesUsing) {
        this.numOfAgenciesUsing = numOfAgenciesUsing;
    }

    public void setNext(Service next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public Service getNext() {
        return next;
    }

    public Service getSubService() {
        return subService;
    }

    public boolean hastNext() {
        return next != null;
    }

    public boolean hasSub() {
        return subService != null;
    }

    public void setData(String data) {
        this.data = data;
    }
}
