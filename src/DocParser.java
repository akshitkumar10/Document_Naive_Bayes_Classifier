import java.io.File;

public class DocParser {
    public String[] trainingDocs;
    public int[] trainingLabels;
    public DocParser(String path){
        File posFolder = new File(path + "/train/pos");
        File negFolder = new File(path + "/train/neg");

        File[] posDocsList = posFolder.listFiles();
        File[] negDocsList = negFolder.listFiles();

        this.trainingLabels = new int[posDocsList.length + negDocsList.length];
        this.trainingDocs = new String[posDocsList.length + negDocsList.length];

        for (int i = 0; i < posDocsList.length; i++) {
            trainingDocs[i] = path + "/train/pos/" + posDocsList[i].getName();
            trainingLabels[i] = 0;
        }
        for (int i = 0; i < negDocsList.length; i++) {
            trainingDocs[i + posDocsList.length] = path + "/train/neg/" + negDocsList[i].getName();
            trainingLabels[i + posDocsList.length] = 1;
        }
    }
}
