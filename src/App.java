import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class App {
    final static String inputFileUrl = "./input/input.txt";
    final static String outputFileUrl = "./output/dump.txt";

    public static void main(String[] args) throws Exception {
        readFile();
    }

    public static void readFile() {
        try {
            String appFilePath = new File("src/app.java").getAbsolutePath();
            System.out.println(appFilePath);
            File inputFile = new File(inputFileUrl);
            File outputFile = new File(outputFileUrl);
            FileWriter fwOut = new FileWriter(outputFile, false);
            Scanner scIN = new Scanner(inputFile);

            int count = 0;

            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName() + " at " + outputFile.getAbsolutePath());
            } else {
                System.out.println("File already exists at: " + outputFile.getAbsolutePath());
            }

            while (scIN.hasNext() && count < 100000) {
                String[] temp = scIN.nextLine().split("\t");
                System.out.println(temp[1]);

                /* if license is revokable we remove this information. */
                if (temp[1].startsWith("Remove")) {
                    String cleanedOutput = temp[1].replaceFirst("Remove", "");
                    fwOut.append(cleanedOutput + "\n");
                    System.out.println("cleaned output added.");
                } else {
                    fwOut.append(temp[1] + "\n");
                    System.out.println(temp[1] + " added to list.");
                }

                count++;
            }
            System.out.println(count);
            fwOut.close();
            scIN.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            System.out.println("readFile() exited.");
        }

    }
}
