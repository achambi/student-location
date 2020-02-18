import java.util.ArrayList;
import java.util.List;

class BoundingBoxManager {
    private List<BoundingBox> boundingBoxes;
    private List<MapPointElement> mapPoints;

    BoundingBoxManager(List<BoundingBox> boundingBoxes, List<MapPointElement> mapPoints) {
        this.boundingBoxes = boundingBoxes;
        this.mapPoints = mapPoints;
    }

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
