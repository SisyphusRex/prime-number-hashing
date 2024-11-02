package primenumberhashing;

public class Program {

    private FunctionWrapper wrappedFunctions = new FunctionWrapper();

    public void run() {

        while (true) {
            int mainMenuChoice = wrappedFunctions.getMainMenuChoice();
            switch (mainMenuChoice) {
                case 0:
                    displayPopulateArrayMenu();
                case 1:
                    // Compare Data
                    displayCompareDataMenu();

                case 2:
                    // exit
                    break;
            }
        }

    }

    private void displayPopulateArrayMenu() {
        while (true) {
            int populateArrayMenuChoice = wrappedFunctions.getPopulateArrayMenuChoice();
            switch (populateArrayMenuChoice) {
                case 0:
                    // 2^n modulo
                    wrappedFunctions.populateArrayWithBase2Modulo();

                case 1:
                    // 10^n modulo
                    wrappedFunctions.populateArrayWithBase10Modulo();

                case 2:
                    // Prime Modulo
                    wrappedFunctions.populateArrayWithPrimeModulo();

                case 3:
                    // Other modulo
                    wrappedFunctions.populateArrayWithOtherModulo();

                case 4:
                    // exit to main menu
                    break;
            }
        }
    }

    private void displayCompareDataMenu() {
        while (true) {
            int compareDataMenuChoice = wrappedFunctions.getCompareDataMenuChoice();
            switch (compareDataMenuChoice) {
                case 0:
                    wrappedFunctions.showComparedData();
                case 1:
                    break;
            }
        }
    }
}