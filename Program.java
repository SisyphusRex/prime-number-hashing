package modulohash;

public class Program {

    private ProgramWrapper wrapped = new ProgramWrapper();

    public void run() {

        while (true) {
            int mainMenuChoice = wrapped.getMainMenuChoice();
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
            int populateArrayMenuChoice = wrapped.getPopulateArrayMenuChoice();
            switch (populateArrayMenuChoice) {
                case 0:
                    // 2^n modulo
                    wrapped.populateArrayWithBase2Modulo();

                case 1:
                    // 10^n modulo
                    wrapped.populateArrayWithBase10Modulo();

                case 2:
                    // Prime Modulo
                    wrapped.populateArrayWithPrimeModulo();

                case 3:
                    // Other modulo
                    wrapped.populateArrayWithOtherModulo();

                case 4:
                    // exit to main menu
                    break;
            }
        }
    }

    private void displayCompareDataMenu() {
        while (true) {
            int compareDataMenuChoice = wrapped.getCompareDataMenuChoice();
            switch (compareDataMenuChoice) {
                case 0:
                    wrapped.showComparedData();
                case 1:
                    break;
            }
        }
    }
}