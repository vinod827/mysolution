/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	This is a JUnit Test to test the following logic for UfoSightings App:-
 *                    (a) Get all sightings result from given csv file
 *                    (b) Get specific sightings result based on given inputs as Year & Month
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ufo.dto.UfoSighting;
import ufo.service.UfoSightingService;
import ufo.util.CsvFileReader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UfoSightingServiceImplTest {
    private UfoSightingService ufoSightingService;
    private CsvFileReader csvFileReader;
    private UfoSighting ufoSighting;
    private TestDataHelper testDataHelper;

    @Before
    public void setUp() throws Exception {
        ufoSightingService = Mockito.mock(UfoSightingServiceImpl.class);
        csvFileReader = Mockito.mock(CsvFileReader.class);
        ufoSighting = Mockito.mock(UfoSighting.class);
        testDataHelper = new TestDataHelper();
    }

    @Test
    public void testGetAllSightings(){
        //Given
        List<UfoSighting> ufoSightingList = testDataHelper.getSightings();

        //When
        Mockito.when(ufoSightingService.getAllSightings()).thenReturn(ufoSightingList);

        //Then
        assertNotNull(ufoSightingList);
    }

    @Test
    public void testSearchSightingsWhenYearAndMonthIsGivenAsInput(){
        //Given
        List<UfoSighting> ufoSightingList = testDataHelper.getSightings();
        int yearSeen = 2018;
        int monthSeen = 01;

        //When
        Mockito.when(ufoSightingService.search(yearSeen, monthSeen)).thenReturn(ufoSightingList);

        //Then
        assertEquals(ufoSightingList.size(), 2);
    }
}