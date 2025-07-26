// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src.commands;

//System Imports
import java.util.HashMap;

//First Party Imports
import primenumberhashing.src.receivers.Receiver;
import primenumberhashing.src.CSVReader;
import primenumberhashing.src.commands.Menu;

public class LoadHashTableAndPrint extends AbstractCommand {
    CSVReader myCSVReader = new CSVReader();
    protected String keyValueFilePath = "primenumberhashing/resources/GoodKeys.csv";

    public LoadHashTableAndPrint(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    @Override
    protected void executeReceiver() {
        try {
            this.receiver.loadHashTable(this.myCSVReader.getHashMapFromCSV(this.keyValueFilePath));
            ui.printReceiver(this.receiver);
        } catch (NullPointerException e) {
            ui.displayModuloOrConstantNotCreatedError();
        }

    }
}
