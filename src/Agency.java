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
        if(services.isEmpty()){
            System.out.println(name + " agency does not offer any services!");
        }
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
        Node service = serviceList.findService(serviceList.getFirst(), name);
        if(service == null){
            System.out.println("service not found");
            return;
        }
        services.add(service);
        service.setNumOfAgenciesUsing(service.getNumOfAgenciesUsing() + 1);
    }

    /**
     * deletes service from the offered services by the agency
     * if this agency is the only one offering the service, the service will be removed from the service list.
     * @param name
     */
    public void deleteService(String name){
        for (int i = 0; i < services.size(); i ++){
           if (services.get(i).getData().equals(name)){
               if (services.get(i).getNumOfAgenciesUsing() == 1){
                   serviceList.delete(services.get(i).getData());
               }
               services.remove(i);
               return;

           }
        }
        System.out.println(name + " is not offered by " + this.name + " agency");

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
