import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private final String logFile = "demo_log.txt";
    private PrintWriter writer;

    private Logger() {
        try {
            FileWriter fw = new FileWriter(logFile, true);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logWithdraw(String account, double amount) {
        writer.println("WITHDRAW (" + account + "): " + amount + "$");
    }

    public void logDeposit(String account, double amount) {
        writer.println("DEPOSIT (" + account + "): " + amount + "$");
    }

    public void logTransfer(String fromAccount, String toAccount, double amount) {
        writer.println("TRANSFER (" + fromAccount + "->" + toAccount + "): " + amount + "$");
    }

    public void closeLogFile() {
        if (writer != null) {
            writer.close();
        }
    }
}
