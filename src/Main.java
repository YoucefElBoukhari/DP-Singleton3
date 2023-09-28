public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Simulate some bank transactions
        logger.logWithdraw("Account1", 100.0);
        logger.logDeposit("Account2", 200.0);
        logger.logTransfer("Account1", "Account2", 50.0);

        // Close the log file when done
        logger.closeLogFile();
    }
}
