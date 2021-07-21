package by.epam.eugene.reader;

import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.validator.CustomFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PyramidReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> read(String pathFile) throws PyramidException {
        if (!CustomFileValidator.isFileValid(pathFile)) {
            logger.error("File can not valid.  Path: " + pathFile);
            throw new PyramidException("File can not valid.  Path: " + pathFile);
        }
        logger.debug("File has been validated");
        List<String> arrayList;

        Path path = Paths.get(pathFile);
        try (Stream<String> lineStream = Files.lines(path)) {
            arrayList = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("File read exception" + e);
            throw new PyramidException("File read exception", e);
        }
        logger.debug("File has been read. Result:" + arrayList);
        return arrayList;
    }
}
