/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class Agencies {

    private final Agency first;
    private Agency  last;

    public Agencies(){
        first = new Agency();
        last = first;
    }

    /**
     * adds an agency to list
     * @param name
     */
    public void add(String name){
        if (first.getName() == null)
            first.setName(name);
        else{
            last = last.addNext(name);

        }
    }

    /**
     * lists all agencies
     */
    public void show(){
        Agency temp = first;
        System.out.println("Agencies:");
        while (temp != null){
            System.out.println(temp.getName());
            temp = (Agency) temp.getNext();
        }
        System.out.println( "=====================");
    }

    /**
     * adds a service to an agency to offer
     * @param agencyName name of the agency
     * @param service name of the service
     */
    public void addOffer(String agencyName, String service){
        Agency agency = findAgency(agencyName);
        if (agency == null){
            System.out.println("no such agency found");
            return;
        }
        agency.addService(service);
    }

    /**
     * finds an agency by name
     * @param name name of the agency
     * @return instance of the agency
     */
    public Agency findAgency(String name){
        Agency temp = first;
        while (temp != null){
            if( temp.getName().equals(name))
                return temp;
            temp = (Agency)temp.getNext();
        }
        return  null;
    }
}
