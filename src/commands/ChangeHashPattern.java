package primenumberhashing.src.commands;

import primenumberhashing.src.commands.Menu;

//System Imports

//First Party Imports
import primenumberhashing.src.receivers.Receiver;

public class ChangeHashPattern extends AbstractCommand {
    public ChangeHashPattern(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    protected void executeReceiver() {
        String newHashPattern = this.ui.getHashPattern();
        this.receiver.changeHashPattern(newHashPattern);
    }
}