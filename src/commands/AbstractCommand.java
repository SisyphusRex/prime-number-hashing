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