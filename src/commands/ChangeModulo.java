package primenumberhashing.src.commands;

import primenumberhashing.src.receivers.Receiver;

//System Imports

//First Party Imports

public class ChangeModulo extends AbstractCommand {
    public ChangeModulo(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    @Override
    protected void executeReceiver() {
        Integer newModulo = this.ui.getInteger();
        this.receiver.changeModulo(newModulo);
    }
}
