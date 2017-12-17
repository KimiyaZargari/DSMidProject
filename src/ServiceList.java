/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class ServiceList {
    private Service first;
    private Service last;

    public ServiceList() {
        first = null;
        last = null;
    }

    /**
     * creates a node and adds it to the end of list
     * @param service name of the service
     * @return true if successfully created; false if the service already exists
     */
    public boolean addService(String service) {
        Service temp = first;
        if (first == null) {
            first = new Service(service);
            last = first;
        } else if (findService(temp, service) == null) {
            last = last.addNext(service);
        } else
            return false;
        return true;
    }

    /**
     * deletes node from list
     * @param name name of the node that wants to be deleted
     * @return true if successfully deleted and false if node with such name does not exist
     */

    public boolean delete(String name) {
        Service temp = first;
        Service next = temp.getNext();
        if (temp.getData().equals(name)) {
            first = next;
            return true;
        }
        while (next != null) {
            if(next.getData().equals(name)){
                temp.setNext(next.getNext());
                return true;
            }
        }
        return  false;
    }

    /**
     * creates a node and adds it as a sub service to a service
     * @param service name of the service node
     * @param subService name of the sub service node that should be created
     * @return true if successfully created and false if sub service already exists or service not found,
     */
    public boolean addSubService(String service, String subService) {

        Service temp = first;
        Service serviceService = findService(temp, service);
        if (temp == null) {
            System.out.println("no such service found");
            return false;
        }
        temp = first;
        if (findService(temp, subService) == null) {
            serviceService.addSub(subService);
            return true;
        }
        return false;
    }

    /**
     * prints full service list recursively
     * @param from the head of the list
     */
    public void show(Service from) {
        if (first == null) {
            System.out.println("the service list is empty");
            return;
        }
        while (from != null) {
            System.out.print(from.getData());
            if (from.hasSub()) {
                System.out.print(" <");
                show(from.getSubService());
                System.out.print(">");
            }
            if (from.hastNext())
                System.out.print(" , ");
            from = from.getNext();
        }
    }

    /**
     * searches list to find a node by having its name and returns it recursively
     * @param from head of the list  or sublist
     * @param service name of the node
     * @return the node with given name
     */
    public Service findService(Service from, String service) {
        while (from != null) {
            if (from.getData().equals(service)) {
                return from;
            }
            if (from.hasSub()) {
                Service node = findService(from.getSubService(), service);
                if (node != null)
                    return node;
            }
            from = from.getNext();
        }
        return null;
    }

    /**
     * @return a reference to the first node
     */
    public Service getFirst() {
        Service temp = first;
        return temp;
    }

}
