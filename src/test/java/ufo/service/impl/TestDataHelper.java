/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This class will be used as test data helper class which would return a list with dummy data for JUnit testing
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.service.impl;

import ufo.dto.UfoSighting;

import java.util.ArrayList;
import java.util.List;

public class TestDataHelper {

    /**
     * @author: Vinod Kumar Nair (Wipro)
     * @return
     */
    public List<UfoSighting> getSightings(){
        List<UfoSighting> testSightingsData = new ArrayList<UfoSighting>();
        UfoSighting ufoSighting = null;
        //Test Data 1 for UFO Sightings
        String dateSeen = "20180101";
        String dateReported = "20180101";
        String placeSeen = "London";
        String shape = " Test shape 1";
        String duration = " Test duration 1";
        String description = "This is a test data 1";
        ufoSighting = new UfoSighting(dateSeen, dateReported, placeSeen, shape, duration, description);
        testSightingsData.add(ufoSighting);

        //Test Data 2 for UFO Sightings
        dateSeen = "20180108";
        dateReported = "20180108";
        placeSeen = "New York";
        shape = " Test shape 2";
        duration = " Test duration 2";
        description = "This is a test data 2";
        ufoSighting = new UfoSighting(dateSeen, dateReported, placeSeen, shape, duration, description);
        testSightingsData.add(ufoSighting);
        return testSightingsData;
    }
}
