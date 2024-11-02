package primenumberhashing;

public class FunctionWrapper {
    private UI userInterface = new UI();
    private String[] mainMenu = { "Populate Arrays", "Compare Statistics", "Exit" };
    private String[] populateArrayMenu = { "Base 2 (2^n) Modulo", "Base 10 (10^n) Modulo", "Prime Modulo",
            "Other Modulo" };
    private String[] typeOfKeysMenu = { "Well Distributed Keys", "Clustered Keys" };

    public int getMainMenuChoice() {
        userInterface.displayMenu(mainMenu);
        int choice = userInterface.getMenuChoice(mainMenu);
        return choice;

    }

    public int getPopulateArrayMenuChoice() {
        userInterface.displayMenu(populateArrayMenu);
        int choice = userInterface.getMenuChoice(populateArrayMenu);
        return choice;
    }

    public void populateArrayWithBase2Modulo() {
        int modulo = userInterface.getN();
        userInterface.displayMenu(typeOfKeysMenu);

    }

    public void populateArrayWithBase10Modulo() {

    }

    public void populateArrayWithPrimeModulo() {

    }

    public void populateArrayWithOtherModulo() {

    }

    public int getCompareDataMenuChoice() {

    }

    public void showComparedData() {

    }
}