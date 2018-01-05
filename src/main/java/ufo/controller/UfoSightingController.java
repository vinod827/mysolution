/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This class will be used as main controller class to populate following 2 types of results:-
 *                    (a) Get all sightings result from given csv file
 *                    (b) Get specific sightings result based on given inputs as Year & Month
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.controller;

import ufo.service.UfoSightingService;
import ufo.service.impl.UfoSightingServiceImpl;
import java.util.logging.Logger;

public class UfoSightingController {
    private static Logger logger = Logger.getLogger("UfoSightingController");
    private UfoSightingService ufoSightingService = new UfoSightingServiceImpl();

    public static void main(String[] args) {
        logger.info("Entering main@UfoSightingController");
        UfoSightingController ufoSightingController = new UfoSightingController();
        ufoSightingController.getAllSightings(); //To get all the results of sightings from CSV

        //Given inputs for 2nd condition i.e. result based specific year and month
        int yearSeen = 1995;
        int monthSeen = 10;
        ufoSightingController.search(yearSeen, monthSeen); //To get filtered results from CSV file for sightings
        logger.info("Exiting main@UfoSightingController");
    }

    private void getAllSightings() {
        logger.info("Entering getAllSightings@UfoSightingController");
        logger.info("Total sightings received:" + ufoSightingService.getAllSightings().size());
        logger.info("Exiting getAllSightings@UfoSightingController");
    }

    private void search(int yearSeen, int monthSeen){
        logger.info("Entering search@UfoSightingController");
        logger.info("Total sightings received with Year as 1995 & Month as October:" + ufoSightingService.search(yearSeen, monthSeen).size());
        logger.info("Exiting search@UfoSightingController");
    }
}