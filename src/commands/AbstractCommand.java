// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src.commands;

//System Imports

//First Party Imports
import primenumberhashing.src.receivers.Receiver;
import primenumberhashing.src.UserInterface;
import primenumberhashing.src.commands.Command;
import primenumberhashing.src.commands.Menu;

abstract class AbstractCommand implements Command {
    private Menu parentMenu;
    protected Receiver receiver;
    protected UserInterface ui = new UserInterface();

    public AbstractCommand(Menu parentMenu, Receiver receiver) {
        this.parentMenu = parentMenu;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.executeReceiver();
        this.parentMenu.execute();
    }

    abstract protected void executeReceiver();

}
