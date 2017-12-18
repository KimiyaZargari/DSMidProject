import java.awt.image.ImagingOpException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Kimiya :) on 15/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        Agencies agencies = new Agencies();
        ServiceList serviceList = new ServiceList();
        Agency.setServiceList(serviceList);
        OrderList orderList = new OrderList();
        int orderCnt = 1;
        while (true) {
            System.out.println("0) list orders");
            System.out.println("1) add service");
            System.out.println("2) add subservice");
            System.out.println("3) add offer to an agency");
            System.out.println("4) delete service from an agency");
            System.out.println("5) add agency");
            System.out.println("6) list agency");
            System.out.println("7) list services");
            System.out.println("8) list services of an agency");
            System.out.println("9) order");
            System.out.println("p) pop order");
            System.out.println("q) quit");
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            switch (input) {
                case "0":
                    orderList.listOrders();
                    break;
                case "1":
                    System.out.println("enter a service name:");
                    reader.nextLine();
                    String serviceName = reader.nextLine();
                    serviceList.addService(serviceName);
                    break;
                case "2":
                    System.out.println("enter service name: ");
                    reader.nextLine();
                    String service = reader.nextLine();
                    System.out.println("enter subservice name: ");
                    String subService = reader.nextLine();
                    serviceList.addSubService(service, subService);
                    break;
                case "3":
                    System.out.println("enter agency name: ");
                    reader.nextLine();
                    String agency = reader.nextLine();
                    System.out.println("enter service:");
                    service = reader.nextLine();
                    agencies.addOffer(agency, service);
                    break;
                case "4":
                    System.out.println("enter service");
                    reader.nextLine();
                    service = reader.nextLine();
                    System.out.println("enter agency");
                    agency = reader.nextLine();
                    agencies.deleteServiceFromAgency(service, agency);
                    break;
                case "5":
                    System.out.println("enter agency name:");
                    reader.nextLine();
                    agency = reader.nextLine();
                    agencies.add(agency);
                    break;
                case "6":
                    System.out.println("======");
                    agencies.show();
                    System.out.println("=====");
                    break;
                case "7":
                    System.out.println("=====");
                    serviceList.show(serviceList.getFirst());
                    System.out.println("\n=====");
                    break;
                case "8":
                    System.out.println("enter agency:");
                    reader.nextLine();
                    agency = reader.nextLine();
                    agencies.listServicesOfAgency(agency);
                    break;
                case "9":
                    System.out.println("enter service");
                    reader.nextLine();
                    service = reader.nextLine();
                    Service orderService = serviceList.findService(serviceList.getFirst(), service);
                    if (orderService == null) {
                        System.out.println("service not found");
                        break;
                    }
                    System.out.println("enter agency");
                    agency = reader.nextLine();
                    Agency orderAgency = agencies.findAgency(agency);
                    if (orderAgency == null) {
                        System.out.println("agency not found");
                        break;
                    }
                    if (orderAgency.findService(service) == null) {
                        System.out.println(service + " not offered by agency " + agency);
                        break;

                    }
                    System.out.println("what is the immediacy level:\n1)" + Order.ImmediacyLevel.NORMAL.toString() + "\n 2)" + Order.ImmediacyLevel.REQUIRED.toString() + "\n3)" + Order.ImmediacyLevel.IMMEDIATE.toString());
                    int inp;
                    try {
                        inp = reader.nextInt();
                    } catch (Exception e) {
                        inp = 2;
                    }

                    Order.ImmediacyLevel immediacyLevel;
                    switch (inp) {
                        case 1:
                            immediacyLevel = Order.ImmediacyLevel.NORMAL;
                            break;
                        case 2:
                            immediacyLevel = Order.ImmediacyLevel.REQUIRED;
                            break;
                        case 3:
                            immediacyLevel = Order.ImmediacyLevel.IMMEDIATE;
                            break;
                        default:
                            immediacyLevel = Order.ImmediacyLevel.REQUIRED;
                    }
                    System.out.println("enter name:");
                    reader.nextLine();
                    String name = reader.nextLine();

                    orderList.addOrder(new Order(orderService, orderAgency, name, immediacyLevel, orderCnt++));
                    break;
                case "q":
                    return;
                case "p":
                    if (!orderList.isEmpty())
                    System.out.println(orderList.popOrder().getCostumerName());

            }

        }
    }


}
