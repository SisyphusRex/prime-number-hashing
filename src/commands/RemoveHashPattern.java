package primenumberhashing.src.commands;

//System Imports

//First Party Imports
import primenumberhashing.src.commands.AbstractCommand;
import primenumberhashing.src.receivers.Receiver;

public class RemoveHashPattern extends AbstractCommand {
    public RemoveHashPattern(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    @Override
    protected void executeReceiver() {
        this.receiver.removeHashPattern();
    }
}