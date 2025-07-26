// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src;

//System Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.UserInterface;

public class CSVReader {

    public HashMap<String, String> getHashMapFromCSV(String filePath) {
        HashMap<String, String> data = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
