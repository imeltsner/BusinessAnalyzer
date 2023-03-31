import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class BusinessAnalyzer {
    public static void main(String[] args) {
        String filePath = args[0];
        String flag = args[1];
        ArrayDeque<String> commands = new ArrayDeque<String>();
        Stats stats = new Stats(filePath, flag);
        Scanner scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine().toLowerCase();
            String[] commandArray = command.split(" ");
            if (command.contains("zip")) {
                stats.getZipSummary(commandArray[1]);
                commands.add(command);
            }
            else if (command.contains("naics")) {
                stats.getNAICSSummary(commandArray[1]);
                commands.add(command);
            }
            else if (command.contains("history")) {
                Iterator<String> iter = commands.iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }
            else if (command.contains("quit")) {
                break;
            }
            else {
                System.out.println("invalid command");
            }
        }
        scan.close();
    }
}
