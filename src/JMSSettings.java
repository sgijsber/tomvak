
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maja Pesic
 */
public class JMSSettings {

    public static final String CONNECTION = "CONNECTION";
    public static final String LOAN_REQUEST = "LOAN_REQUEST";
    public static final String LOAN_REPLY = "LOAN_REPLY";
    public static final String LOAN_REPLY_2 = "LOAN_REPLY_2";
    public static final String CREDIT_REQUEST = "CREDIT_REQUEST";
    public static final String CREDIT_REPLY = "CREDIT_REPLY";
    public static final String BANK_1 = "BANK_1";
    public static final String BANK_2 = "BANK_2";
    public static final String BANK_3 = "BANK_3";
    public static final String BANK_REPLY = "BANK_REPLY";
    private HashMap<String, String> map;

    public JMSSettings(String fileName) {
        File file = new File(fileName);
        map = new HashMap<String, String>();
        Scanner scanner = null;
        try {

            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replaceAll(" ", "");
                StringTokenizer tk = new StringTokenizer(line, "=");
                String key = tk.nextToken();
                String value = tk.nextToken();
                System.out.println(key + "=" + value);
                map.put(key, value);
            }


            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JMSSettings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            scanner.close();
        }
    }

    public String get(String queue) {
        return map.get(queue);
    }
}
