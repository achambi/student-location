import java.util.ArrayList;
import java.util.List;

/**
 * A bounding box manager to verify a list of @{@link MapPointElement} is within a list of {@link BoundingBox}
 */
class BoundingBoxManager {
    private List<BoundingBox> boundingBoxes;
    private List<MapPointElement> mapPoints;

    /**
     * Constructor
     *
     * @param boundingBoxes a {@link List} of {@link BoundingBox}
     * @param mapPoints     a {@link List} of {@link MapPointElement}
     */
    BoundingBoxManager(List<BoundingBox> boundingBoxes, List<MapPointElement> mapPoints) {
        this.boundingBoxes = boundingBoxes;
        this.mapPoints = mapPoints;
    }

    /**
     * Return all {@link MapPointElement} in a {@link List}<{@link BoundingBox}>.
     *
     * @return a {@link List} of {@link MapPointElement} found.
     */
    List<MapPointElement> studentsInClasses() {
        List<MapPointElement> mapPointsFound = new ArrayList<>();
        for (BoundingBox boundingBox : boundingBoxes) {
            for (MapPointElement mapPoint : mapPoints) {
                MapPointElement mapPointFound = boundingBox.verifyPoint(mapPoint);
                if (mapPointFound != null) {
                    mapPointsFound.add(mapPointFound);
                }
            }
        }
        return mapPointsFound;
    }
}
