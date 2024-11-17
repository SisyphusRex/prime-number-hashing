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