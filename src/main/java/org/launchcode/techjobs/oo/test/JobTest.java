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
        Job job = new Job("product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("product tester", job.getName());
        assertEquals("ACME",job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence",job.getCoreCompetency().getValue());

        assertTrue(job.getName()instanceof String);
        assertTrue(job.getEmployer()instanceof Employer);
        assertTrue(job.getLocation()instanceof Location);
        assertTrue(job.getPositionType()instanceof PositionType);
        assertTrue(job.getCoreCompetency()instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 =new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String str = job.toString();
      assertEquals('\n', str.charAt(0));
      assertEquals('\n',str.charAt(str.length()-1));

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String str = job.toString();
        String output = String.format("\nID: %d\n"+
                "Name: %s\n"+
                "Employer: %s\n"+
                "Location: %s\n"+
                "Position Type: %s\n"+
                "Core Competency: %s\n", job.getId(),job.getName(),job.getEmployer(),job.getLocation(),
                job.getPositionType(),job.getCoreCompetency());

        assertEquals(output, str);

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job otherJob = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("Persistence"));

        String str = otherJob.toString();
        String output = String.format("\nID: %d\n"+
                        "Name: %s\n"+
                        "Employer: %s\n"+
                        "Location: %s\n"+
                        "Position Type: %s\n"+
                        "Core Competency: %s\n", otherJob.getId(),otherJob.getName(),"Data not available",otherJob.getLocation(),
              "Data not available",otherJob.getCoreCompetency());

        assertEquals(output,str);


    }


}
