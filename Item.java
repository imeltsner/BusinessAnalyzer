/**
 * Stores relevant info for a single business
 * @author Isaac Meltsner
 */
public class Item {
    //class variables
    private String zipcode;
    private String NAICS;
    private String type;
    private String neighborhood;
    private boolean isOpen;
    private boolean isNew;

    /**
     * Parses and stores relevant data
     * @param line a single line from CSV file
     */
    Item(String line) {
        String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        zipcode = data[14];
        NAICS = data[16];
        type = data[17];
        neighborhood = data[23];
        isOpen = data[11].equals("");
        String[] openDate = data[10].split("/");
        int month = Integer.parseInt(openDate[0]);
        if (openDate[2].equals("2023") || (openDate[2].equals("2022") && month >= 4)) {
            isNew = true;
        }
        else {
            isNew = false;
        }
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getNAICS() {
        return NAICS;
    }

    public String getType() {
        return type;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public boolean getOpen() {
        return isOpen;
    }

    public boolean getNew() {
        return isNew;
    }

    public void print() {
        System.out.println("Zipcode: " + zipcode + " | NAICS: " + NAICS + " | Bus Type: " + type + " | Neighborhood: " + neighborhood + " Open: " + isOpen);
    }
}
