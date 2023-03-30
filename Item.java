public class Item {
    private String zipcode;
    private String NAICS;
    private String type;
    private String neighborhood;
    private boolean isOpen;

    Item(String line) {
        String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        zipcode = data[14];
        NAICS = data[16];
        type = data[17];
        neighborhood = data[23];
        isOpen = data[11].equals("");
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

    public void print() {
        System.out.println("Zipcode: " + zipcode + " | NAICS: " + NAICS + " | Bus Type: " + type + " | Neighborhood: " + neighborhood + " Open: " + isOpen);
    }
}
