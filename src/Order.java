/**
 * Created by Kimiya :) on 17/12/2017.
 */
public class Order {
    public enum ImmediacyLevel {IMMEDIATE, REQUIRED, NORMAL}

    private Agency agency;
    private Service service;
    private String costumerName;
    private ImmediacyLevel immediacyLevel;

    public Order(Service service, Agency agency, String costumerName, ImmediacyLevel immediacyLevel) {
        this.service = service;
        this.agency = agency;
        this.costumerName = costumerName;
        this.immediacyLevel = immediacyLevel;
    }

    /**
     * returns an integer for each immediacy level
     * @return 3 for immediate, 2 for required and 1 for normal.
     */
    public int getImmediacyLevel() {
        switch (immediacyLevel) {
            case IMMEDIATE:
                return 3;
            case REQUIRED:
                return 2;
            case NORMAL:
                return 1;
            default:
                return 2;

        }
    }
}