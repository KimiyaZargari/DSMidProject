/**
 * A service offered by the company. has reference to the next service the company adds
 * each service can have subservices.
 */
public class Service {
    private String data;
    private Service next;
    private String carModer;
    private String costumerDes;
    private String companyDes;
    private double expense;
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

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String getCarModer() {
        return carModer;
    }

    public void setCarModer(String carModer) {
        this.carModer = carModer;
    }

    public String getCompanyDes() {
        return companyDes;
    }

    public void setCompanyDes(String companyDes) {
        this.companyDes = companyDes;
    }

    public String getCostumerDes() {
        return costumerDes;
    }

    public void setCostumerDes(String costumerDes) {
        this.costumerDes = costumerDes;
    }
}
