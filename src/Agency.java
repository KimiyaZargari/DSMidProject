import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class Agency {
    private String name;
    private static ServiceList serviceList;
    private List<Node> services;
    private Agency next;

    public Agency(String name) {
        this.name = name;
        next = null;
        services = new ArrayList<>();
    }
    public Agency(){
        this(null);

    }

    /**
     * adds next agency
     * @param name name of the agency
     * @return aGEncY instance
     */
    public Agency addNext(String name){
        return next = new Agency(name);
    }

    /**
     * lists all services offered by the agency
     */
    public void showServices() {
        System.out.println("service(s) of " + name + " agency ");
        for (int i = 0; i < services.size(); i ++){
            System.out.print( services.get(i).getData() + "  ");
        }
        System.out.println();
    }

    /**
     * adds a service to the agency's offered services
     * @param name name of the service
     */
    public void addService(String name) {
        services.add(serviceList.findService(serviceList.getFirst(), name));
    }


    public static void setServiceList(ServiceList serviceList) {
        Agency.serviceList = serviceList;
    }

    public Agency getNext() {
        return next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
