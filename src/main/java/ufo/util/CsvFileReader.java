/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This class will be used as Utility class to read the given CSV file
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class CsvFileReader {
    protected static Logger logger = Logger.getLogger("CsvFileReader");
    private static Properties file_properties = null;
    private static String csvFile = null;

    static {
        try {
            file_properties = PropertyReader.fileProperties;
            csvFile = file_properties.getProperty("CSV_FILE_PATH");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedReader getCSVFileBufferedReader() {
        logger.info("Entering getCSVFileBufferedReader@CsvFileReader");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Exiting getCSVFileBufferedReader@CsvFileReader");
        return bufferedReader;
    }
}