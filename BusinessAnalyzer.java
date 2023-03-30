
public class BusinessAnalyzer {
    public static void main(String[] args) {
        String filePath = args[0];
        String flag = args[1];
        Stats stats = new Stats(filePath, flag);
        stats.getZipSummary("94108");
    }
}
