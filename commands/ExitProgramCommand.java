package primenumberhashing.commands;

public class ExitProgramCommand implements Command {

    @Override
    public void execute() {
        System.exit(0);
    }
}