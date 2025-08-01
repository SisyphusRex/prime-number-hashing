// Copyright 2025 Theodore Podewil
// GPL-3.0-or-later

/*
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>. 
*/

package primenumberhashing.src.receivers;

//System Imports

//First Party Imports

public class TestObject {
    public String key;
    public String value;
    private int maxLength = 4;

    public TestObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        String name = this.value;
        if (name.length() >= maxLength) {
            return String.format("(%s)", this.value.substring(0, 3));
        } else {
            return String.format("(%s)", this.value);
        }

    }
}
