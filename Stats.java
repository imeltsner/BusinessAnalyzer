import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Stats {
    List<Item> items;

    Stats(String filePath, String flag) {
        if (flag.equals("AL")) {
            items = new ArrayList<Item>();
        }
        else if (flag.equals("LL")) {
            items = new LinkedList<Item>();
        }
        try {
            Scanner scan = new Scanner(new File(filePath));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Item data = new Item(line);
                if (!data.getNAICS().equals("") && !data.getNeighborhood().equals("") && !data.getType().equals("") && !data.getZipcode().equals("") && data.getZipcode().length() == 5) {
                    items.add(data);
                }
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    void getZipSummary(String code) {
        int count = 0;
        HashSet<String> busTypes = new HashSet<String>();
        HashSet<String> neighborhoods = new HashSet<String>();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item business = iterator.next();
            if (business.getZipcode().equals(code)) {
                count++;
                busTypes.add(business.getType());
                neighborhoods.add(business.getNeighborhood());
            }
        }
        System.out.println(code + " Business Summary");
        System.out.println("Total Businesses: " + count);
        System.out.println("Business Types: " + busTypes.size());
        System.out.println("Neighborhoods: " + neighborhoods.size());
    }

    void getNAICSSummary(String code) {
        int count = 0;
        int target = Integer.parseInt(code);
        HashSet<String> zipcodes = new HashSet<String>();
        HashSet<String> neighborhoods = new HashSet<String>();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item business = iterator.next();
            String nCode = business.getNAICS();
            String[] allCodes = nCode.split(" ");
            for (int j = 0; j < allCodes.length; j++) {
                String[] range = allCodes[j].split("-");
                if (!range[0].equals("")) {
                    int bot = Integer.parseInt(range[0]);
                    int top = Integer.parseInt(range[1]);
                    if (target >= bot && target <= top) {
                        count++;
                        zipcodes.add(business.getZipcode());
                        neighborhoods.add(business.getNeighborhood());
                    }
                } 
            }
        }
        System.out.println("NAICS " + code + " Summary");
        System.out.println("Total Businesses: " + count);
        System.out.println("Zip Codes: " + zipcodes.size());
        System.out.println("Neighborhoods: " + neighborhoods.size());
    }

    void getSummary() {
        int count = items.size();
        int closed = 0;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item business = iterator.next();
            if (!business.getOpen()) {
                closed++;
            }
        }
        System.out.println("Total Businesses: " + count);
        System.out.println("Closed Businesses: " + closed);
    }
}
