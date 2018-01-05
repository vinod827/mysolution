/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This class will be used as Implementation class for given Interface, UfoSightingService to write logic for following 2 types of results:-
 *                    (a) Get all sightings result from given csv file
 *                    (b) Get specific sightings result based on given inputs as Year & Month
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.service.impl;

import ufo.dto.UfoSighting;
import ufo.service.UfoSightingService;
import ufo.util.CsvFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UfoSightingServiceImpl implements UfoSightingService {
    private static Logger logger = Logger.getLogger("UfoSightingServiceImpl");
    private static String cvsSplitBy = "\t";

    public List<UfoSighting> getAllSightings() {
        logger.info("Entering getAllSightings@UfoSightingServiceImpl");
        BufferedReader bufferedReader = null;
        String line = "";
        UfoSighting ufoSighting = null;
        List<UfoSighting> ufoSightingList = null;
        String dateSeen = null;
        String dateReported = null;
        try {
            bufferedReader = CsvFileReader.getCSVFileBufferedReader();
            if (null != bufferedReader) {
                logger.info("CSV file read successfully");
                ufoSightingList = new ArrayList<UfoSighting>();
                while ((line = bufferedReader.readLine()) != null) {
                    // use tab as separator
                    String[] dataObject = line.split(cvsSplitBy);
                    dateSeen = dataObject[0];
                    dateReported = dataObject[1];
                    //ufoSighting = new UfoSighting(dateSeen, dateReported, placeSeen, shape, duration, description);
                    ufoSighting = new UfoSighting(dateSeen, dateReported, null, null, null, null);
                    ufoSightingList.add(ufoSighting);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("Exiting getAllSightings@UfoSightingServiceImpl");
        return ufoSightingList;
    }

    public List<UfoSighting> search(int yearSeen, int monthSeen) {
        logger.info("Entering search@UfoSightingServiceImpl");
        BufferedReader bufferedReader = null;
        String line = "";
        UfoSighting ufoSighting = null;
        List<UfoSighting> ufoSightingList = null;
        String dateSeen = null;
        String dateReported = null;
        String pattern = Integer.toString(yearSeen) + Integer.toString(monthSeen);
        boolean patternMatched = false;
        try {
            bufferedReader = CsvFileReader.getCSVFileBufferedReader();
            if (null != bufferedReader) {
                logger.info("CSV file read successfully");
                ufoSightingList = new ArrayList<UfoSighting>();
                while ((line = bufferedReader.readLine()) != null) {
                    // use tab as separator
                    String[] dataObject = line.split(cvsSplitBy);
                    dateSeen = dataObject[0];
                    if (null != dateSeen && dateSeen.startsWith(pattern)) {
                        patternMatched = true;
                    }
                    dateReported = dataObject[1];
                    ufoSighting = new UfoSighting(dateSeen, dateReported, null, null, null, null);
                    if (patternMatched) {
                        ufoSightingList.add(ufoSighting);
                    }
                    patternMatched = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("Exiting search@UfoSightingServiceImpl");
        return ufoSightingList;
    }
}