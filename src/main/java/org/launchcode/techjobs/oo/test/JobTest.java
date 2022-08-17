package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());

    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));

        assertEquals("product tester", job.getName());
        assertTrue(job.getEmployer()instanceof Employer && "ACME"== job.getEmployer().getValue());
        assertTrue(job.getLocation()instanceof Location && "Desert"== job.getLocation().getValue());
        assertTrue(job.getPositionType()instanceof PositionType && "Quality control"== job.getPositionType().getValue());
        assertTrue(job.getCoreCompetency()instanceof CoreCompetency && "Persistence"== job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 =new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }

}
