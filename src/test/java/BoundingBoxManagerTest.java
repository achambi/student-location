import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoundingBoxManagerTest {

    private List<BoundingBox> classes;

    @Before
    public void setUp() {
        double halfSideInMts = 10;

        MapPointElement point = new MapPointElement("Principles of computational geo-location analysis",
                                                    34.069140, -118.442689
        );
        BoundingBox engineeringClassroom = point.createBoundingBox(halfSideInMts);

        point = new MapPointElement("Sedimentary Petrology", 34.069585, -118.441878);
        BoundingBox geologyClassroom = point.createBoundingBox(halfSideInMts);

        point = new MapPointElement("Introductory Psychobiology", 34.069742, -118.441312);
        BoundingBox psychologyClassroom = point.createBoundingBox(halfSideInMts);

        point = new MapPointElement("Art of Listening", 34.070223, -118.440193);
        BoundingBox musicClassroom = point.createBoundingBox(halfSideInMts);

        point = new MapPointElement("Art History", 34.071528, -118.441211);
        BoundingBox humanitiesClassroom = point.createBoundingBox(halfSideInMts);

        classes = Arrays.asList(engineeringClassroom,
                                geologyClassroom,
                                psychologyClassroom,
                                musicClassroom,
                                humanitiesClassroom
        );
    }

    @Test
    public void testCalculateExample1() {
        {

            List<MapPointElement> students = Arrays.asList(
                //john_student - engineering
                new MapPointElement("John Wilson", 34.069149, -118.442639),
                //jane_student - geology
                new MapPointElement("Jane Graham", 34.069601, -118.441862),
                //pam_student - humanities
                new MapPointElement("Pam Bam", 34.071513, -118.441181)
            );

            List<MapPointElement> mapPointsFound = new BoundingBoxManager(
                classes,
                students
            ).studentsInClasses();

            assertNotNull(mapPointsFound);
            assertEquals(students.get(0), mapPointsFound.get(0));
            assertEquals(students.get(1), mapPointsFound.get(1));
            assertEquals(students.get(2), mapPointsFound.get(2));
        }
    }

    @Test
    public void testCalculateExample2() {
        {

            List<MapPointElement> students = Arrays.asList(
                //john_student - engineering
                new MapPointElement("John Wilson", 34.069849, -118.443539),
                //jane_student - geology
                new MapPointElement("Jane Graham", 34.069901, -118.441562),
                //pam_student - humanities
                new MapPointElement("Pam Bam", 34.071523, -118.441171)
            );

            List<MapPointElement> mapPointsFound = new BoundingBoxManager(
                classes,
                students
            ).studentsInClasses();

            assertNotNull(mapPointsFound);
            assertEquals(students.get(2), mapPointsFound.get(0));
        }
    }
}