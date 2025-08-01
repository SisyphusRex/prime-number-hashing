// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src.commands;

import primenumberhashing.src.receivers.Receiver;

//System Imports

//First Party Imports

public class ChangeHashConstant extends AbstractCommand {
    public ChangeHashConstant(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    @Override
    protected void executeReceiver() {
        Integer newHashConstant = this.ui.getHashConstant();
        this.receiver.changeHashConstant(newHashConstant);
    }
}
