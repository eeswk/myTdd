package chap10;

import java.io.*;

public class BulkLoader {
    private String content = "";

    public void load(String bulkFilePath) {
        try (FileInputStream fis = new FileInputStream(bulkFilePath)) {
            byte[] readBuffer = new byte[1024];
            while (fis.read(readBuffer, 0, readBuffer.length) != -1) {
                content += new String(readBuffer);
            }
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
