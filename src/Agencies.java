/**
 *Linked list of all agencies
 */
public class Agencies {

    private final Agency first;
    private Agency last;

    public Agencies() {
        first = new Agency();
        last = first;
    }

    /**
     * adds an agency to list
     *
     * @param name
     */
    public void add(String name) {
        if (first.getName() == null)
            first.setName(name);
        else {
            last = last.addNext(name);

        }
        System.out.println(last.getName() + " agency added");
    }

    /**
     * lists all agencies
     */
    public void show() {
        Agency temp = first;
        System.out.println("Agencies:");
        while (temp != null) {
            System.out.println(temp.getName());
            temp = (Agency) temp.getNext();
        }
    }

    /**
     * adds a service to an agency to offer
     *
     * @param agencyName name of the agency
     * @param service    name of the service
     */
    public void addOffer(String agencyName, String service) {
        Agency agency = findAgency(agencyName);
        if (agency == null) {
            System.out.println("no such agency found");
            return;
        }
        if (agency.findService(service) == null)
            agency.addService(service);
    }

    public void deleteServiceFromAgency(String service, String agency) {
        Agency agencyNode = findAgency(agency);
        if (agencyNode == null) {
            System.out.println(agency + " agency does not exist");
            return;
        }
        agencyNode.deleteService(service);
        System.out.println(service + " deleted from " + agency);
    }

    public void listServicesOfAgency(String agency) {
        Agency agencyNode = findAgency(agency);
        if (agencyNode == null) {
            System.out.println(agency + " agency does not exist");
            return;
        }
        agencyNode.showServices();
    }

    /**
     * finds an agency by name
     *
     * @param name name of the agency
     * @return instance of the agency
     */
    public Agency findAgency(String name) {
        Agency temp = first;
        while (temp != null && temp.getName() != null) {
            if (temp.getName().equals(name))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }
}
