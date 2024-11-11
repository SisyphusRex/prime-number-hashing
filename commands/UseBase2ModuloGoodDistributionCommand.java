package primenumberhashing.commands;

import primenumberhashing.receivers.Base2Modulo;
import primenumberhashing.UserInterface;

public class UseBase2ModuloGoodDistributionCommand implements Command {
    @Override
    public void execute() {
        UserInterface ui = new UserInterface();
        int moduloN = ui.getN();
        Base2Modulo myBase2 = new Base2Modulo(moduloN);
    }
}