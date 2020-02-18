class BoundingBox {
    private final MapPoint minPoint;
    private final MapPoint maxPoint;

    BoundingBox(MapPoint minPoint, MapPoint maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

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
