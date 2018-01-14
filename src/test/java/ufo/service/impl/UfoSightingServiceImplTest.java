/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This is a main entry Test class which will be used to test the following implementation methods of UfoSightings :-
 *                    (a) Get all sightings result from given csv file
 *                    (b) Get specific sightings result based on given inputs as Year & Month
 * Date Created :	14-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            14-01-2018 : Vinod Kumar - Updated JUnit test case for UFO Sightings App
 */

package ufo.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ufo.service.UfoSightingService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class UfoSightingServiceImplTest {
    private static Logger logger = Logger.getLogger("UfoSightingServiceImplTest");
    private UfoSightingService service = null;

    @Before
    public void initService() {
        try {
            service = new UfoSightingServiceImpl(new BufferedReader(new FileReader("../mysolution/src/main/resources/ufo_awesome.tsv")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyAllSightings_WithNoInputCondition() {
        //Given
        int expectedNoOfSightings=61391;

        //When
        int actualNoOfSightings = service.getAllSightings().size();
        logger.info("Total Sightings returned:"+actualNoOfSightings);

        //Then
        Assert.assertNotNull(service.getAllSightings());
        Assert.assertTrue(actualNoOfSightings == expectedNoOfSightings);
    }

    @Test
    public void verifySearchSightings_WithYearAndMonthAsInputCondition() {
        //Given
        int yearSeen = 1995;
        int monthSeen = 10;
        int expectedNoOfSightings=107;

        //When
        int actualNoOfSightings = service.search(yearSeen, monthSeen).size();
        logger.info("Total Sightings returned:"+actualNoOfSightings);

        //Then
        Assert.assertNotNull(service.getAllSightings());
        Assert.assertTrue(actualNoOfSightings == expectedNoOfSightings);
    }
}
