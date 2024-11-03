package primenumberhashing.menus;

public class MainMenu extends AbstractMenu {

    @Override
    protected String[] assignMenuOptions() {
        String[] newMenuOptions = { "Populate Arrays", "Compare Statistics", "Exit" };
        return newMenuOptions;
    }

    @Override
    protected void processChoice(int choice) {

    }

}