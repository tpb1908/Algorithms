import javax.swing.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by theo on 25/04/16.
 */
public class PaperParser implements Test {

    private enum type {
        alpha, numeric, roman
    }

    private static class identifier {
        type idType;
        String id;
        int start;
        int end;

        public identifier(String id, type idType, int start) {
            this.id = id;
            this.idType = idType;
            this.start = start;
        }

        public identifier() {}
    }

    //The string is declared in here
    public  PaperParser() {

    }


    @Override
    public void run() {
        parse();
    }

    public void parse() {
        String paper = "";
        try {
            final JFileChooser fc = new JFileChooser(); //Creating the file choose
            int returnVal = fc.showSaveDialog(new JFrame()); //parent component to JFileChooser
            if (returnVal == JFileChooser.APPROVE_OPTION) { //OK button pressed by user
                File file = fc.getSelectedFile(); //get File selected by user
                System.out.println("The path has been collected");
                String path = file.getAbsolutePath();
                byte[] bytes = Files.readAllBytes(Paths.get(path));
                paper = new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            System.out.println("Can't load file");
            return;
        }
        // ([\d]+ )(.*?)(?=([\d]+\.)|($))
        System.out.println("Paper loaded \n\n\n\n\n"+paper+ "\n\n\n\n\n");
        String[] lines = paper.split("^.[1-20]\\*");
        for(String s : lines) {
            System.out.println(" Line\n " + s + "\n\n\n\n");
        }

    }


}
