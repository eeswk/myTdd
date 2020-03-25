package chap10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class BulkLoaderTest {
    private String bulkFilePath = "c://mygithub//bulk.txt";

    @Test
    void load() {
        BulkLoader loader = new BulkLoader();
        loader.load(bulkFilePath);
        //
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void callBash() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void changeMode() {

    }
}
