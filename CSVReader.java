package primenumberhashing;

import java.util.Scanner;

public class CSVReader {
    public Integer[] getArrayFromCSV(String filePath) {
        List<List<String>> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                data.add(getRecordFromLine(scanner.nextLine()));
            }
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}