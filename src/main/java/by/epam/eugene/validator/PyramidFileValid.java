package by.epam.eugene.validator;

import java.io.File;

public class PyramidFileValid {

    public static boolean isFileValid(String pathFile) {
        if (pathFile == null || pathFile.isEmpty()) {
            return false;
        }
        File file = new File(pathFile);
        if (file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }
}
