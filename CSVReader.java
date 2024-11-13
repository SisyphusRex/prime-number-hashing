package primenumberhashing;

import java.util.Scanner;

import primenumberhashing.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class CSVReader {

    public List<List<String>> getArrayFromCSV(String filePath) {
        List<List<String>> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                data.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            UserInterface.displayFileNotFoundError();
        }
        return data;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public Hashmap<String, String> getHashMapFromCSV(String filepath) {
        HashMap<String, String> data = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String[] splitLine = line.split(",");
                data.put(splitLine[0], splitLine[1]);
            }
        } catch (FileNotFoundException e) {
            UserInterface.displayFileNotFoundError();
        } catch (IndexOutOfBoundsException e) {
            UserInterface.displayIndexError();
        }

        return data;
    }

}