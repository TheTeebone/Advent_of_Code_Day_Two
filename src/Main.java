import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
// List to store all reports
        List<List<Integer>> reports = new ArrayList<>();

        // Path to the input file
        String filePath = "input.txt";

        // Read the file and process each report
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Create a new list for each report
                List<Integer> report = new ArrayList<>();
                // Split the line into numbers
                String[] levels = line.trim().split("\\s+");
                for (String level : levels) {
                    // Parse and add each level to the report list
                    report.add(Integer.parseInt(level));
                }
                // Add the report to the list of reports
                reports.add(report);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        int countSafe = 0;
        for(List<Integer> report : reports){
            boolean safe = true;
                if(report.get(0) < report.get(1)){
                    for (int i = 1 ; i < report.size() ; i ++){
                        if((report.get(i) - report.get(i-1)) != 1 && (report.get(i) - report.get(i-1) != 2)&& (report.get(i) - report.get(i-1) != 3)){
                            safe = false;
                            break;
                        }
                    }

                }
                if(report.get(0) > report.get(1)){
                    for (int i = (report.size() - 1) ; i > 0 ; i --)
                    if((report.get(i-1) - report.get(i)) != 1 && (report.get(i-1) - report.get(i) != 2)&& (report.get(i-1) - report.get(i) != 3)){
                        safe = false;
                        break;
                    }
                }
                if(Objects.equals(report.get(0), report.get(1))){
                    safe = false;
                }
            if(safe == true){
                countSafe++;
            }
        }
        LOGGER.info(String.valueOf(countSafe));

    }
}