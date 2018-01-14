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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UfoSightingServiceImpl implements UfoSightingService {
    private static Logger logger = Logger.getLogger("UfoSightingServiceImpl");
    private static final String delimiter = "\t";
    private BufferedReader bufferedReader;

    public UfoSightingServiceImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public List<UfoSighting> getAllSightings() {
        logger.info("Entering getAllSightings@UfoSightingServiceImpl");
        List<UfoSighting> ufoSightingList = null;
        String line;
        try {
            if (null != this.bufferedReader) {
                ufoSightingList = new ArrayList<UfoSighting>();
                while ((line = this.bufferedReader.readLine()) != null) {
                    String[] dataObject = line.split(delimiter);
                    if (dataObject.length >= 6) {
                        ufoSightingList.add(new UfoSighting(dataObject[0], dataObject[1], dataObject[2], dataObject[3], dataObject[4], dataObject[5]));
                    }else
                        logger.info("Invalid UfoSightings at line#"+line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Exiting getAllSightings@UfoSightingServiceImpl");
        return ufoSightingList;
    }

    public List<UfoSighting> search(int yearSeen, int monthSeen) {
        logger.info("Entering search@UfoSightingServiceImpl");
        List<UfoSighting> ufoSightingList = null;
        String line;
        try {
            if (null != this.bufferedReader) {
                ufoSightingList = new ArrayList<UfoSighting>();
                while ((line = this.bufferedReader.readLine()) != null) {
                    String[] dataObject = line.split(delimiter);
                    String dateSeen = dataObject[0];
                    if (dataObject.length >= 6 && null != dateSeen && dateSeen.startsWith(Integer.toString(yearSeen) + Integer.toString(monthSeen))) {
                        ufoSightingList.add(new UfoSighting(dateSeen, dataObject[1], dataObject[2], dataObject[3], dataObject[4], dataObject[5]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Exiting search@UfoSightingServiceImpl");
        return ufoSightingList;
    }
}