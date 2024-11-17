package primenumberhashing.src.commands;

//System Imports

//First Party Imports

public class ChangeHashPattern extends AbstractCommand {
    public ChangeHashPattern(Menu parentMenu, Receiver receiver) {
        super(parentMenu, receiver);
    }

    protected void executeReceiver() {
        String newHashPattern = this.ui.getHashPattern();
        this.reciever.changeHashPattern(newHashPattern);
    }
}