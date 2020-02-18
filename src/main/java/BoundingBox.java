/**
 * Bounding Box used to create and square area using geo-referenced.
 */
class BoundingBox {
    private final MapPoint minPoint;
    private final MapPoint maxPoint;

    /**
     * Custom Constructor
     *
     * @param minPoint An instance of {@link MapPoint} to describe min lat and min long of the Bounding Box.
     * @param maxPoint An instance of {@link MapPoint} to describe max lat and max long of the Bounding Box.
     */
    BoundingBox(MapPoint minPoint, MapPoint maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    /**
     * Verify if a {@link MapPointElement} is within the area.
     *
     * @param mapPoint {@link MapPointElement} to verify.
     * @return The same {@link MapPointElement} if it is within the area and null if it is not within the area.
     */
    MapPointElement verifyPoint(MapPointElement mapPoint) {
        if (mapPoint.getLatitude() >= minPoint.getLatitude() &&
            mapPoint.getLatitude() <= maxPoint.getLatitude() &&
            mapPoint.getLongitude() >= minPoint.getLongitude() &&
            mapPoint.getLongitude() <= maxPoint.getLongitude()) {
            return mapPoint;
        } else {
            return null;
        }
    }
}
