package dtu.project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class listAvailableDevelopers {
    public GregorianCalendar today = new GregorianCalendar();

    @BeforeEach
    void checkInit(){
        if(!AvailabilityTest.programStarted){
            AvailabilityTest.programStarted = true;
            SoftwareHuset.startProgram();
        }
    }

    @Test
    void listAvailableDevelopersA() {
        Developer developer = SoftwareHuset.getDeveloper("ekki");
        assertTrue(developer.getAvailability(today));
    }

    @Test
    void listAvailableDevelopersB() {
        Developer developer = SoftwareHuset.getDeveloper("ekki");
        developer.setSick();
        assertFalse(developer.getAvailability(today));
        developer.isSick = false;
        SoftwareHuset.updateCSVFile("developers");
    }
}