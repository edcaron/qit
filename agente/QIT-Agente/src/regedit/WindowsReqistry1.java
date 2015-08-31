package regedit;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * @author Oleg Ryaboy, based on work by Miguel Enriquez
 */
public class WindowsReqistry1 {

    /**
     *
     * @param location path in the registry
     * @param parameters parameters for the reg query on cmd
     * @return registry value or null if not found
     */
    public static final String readRegistry(String location, String parameters) {
        String output = "";
        try {
            // Run reg query, then read output with StreamReader (internal class)
            String cmd = "C:\\Users\\eduardo.caron\\Downloads\\planner-0.14.4.exe /S" ;
            System.out.println("comando: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();
            output = reader.getResult();            

        } catch (Exception e) {
            System.out.println("" + e.getCause());
        }
        return output;
    }

    static class StreamReader extends Thread {

        private InputStream is;
        private StringWriter sw = new StringWriter();

        public StreamReader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1) {
                    sw.write(c);
                }
            } catch (IOException e) {
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }

    public static void main(String[] args) {

        String value = WindowsReqistry1.readRegistry("HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", " /s /reg:64");

//        String[] lines = value.split("\n");
//        ArrayList<String> obj = new ArrayList<>();
        System.out.println(value);

    }
}
