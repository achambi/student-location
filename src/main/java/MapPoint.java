
public class MapPoint {
    private double latitude;
    private double longitude;

    public MapPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Earth radius at a given latitude, according to the WGS-84 ellipsoid [m]
    private double WGS84EarthRadius(double lat) {
        // http://en.wikipedia.org/wiki/Earth_radius
        // Semi-axes of WGS-84 geoidal reference
        // Major semiaxis [m]
        double WGS84_a = 6378137.0;
        double an = WGS84_a*WGS84_a*Math.cos(lat);
        // Minor semiaxis [m]
        double WGS84_b = 6356752.3;
        double bn = WGS84_b*WGS84_b*Math.sin(lat);
        double ad = WGS84_a*Math.cos(lat);
        double bd = WGS84_b*Math.sin(lat);
        return Math.sqrt((an*an + bn*bn)/(ad*ad + bd*bd));
    }

    public BoundingBox createBoundingBox(double halfSideInMts) {
        // Bounding box surrounding the point at given coordinates,
        // assuming local approximation of Earth surface as a sphere
        // of radius given by WGS84
        double lat = DegreeAndRadConvertor.Deg2rad(this.getLatitude());
        double lon = DegreeAndRadConvertor.Deg2rad(this.getLongitude());
        double halfSide = halfSideInMts;

        // Radius of Earth at given latitude
        double radius = WGS84EarthRadius(lat);
        // Radius of the parallel at given latitude
        double pradius = radius*Math.cos(lat);

        double latMin = DegreeAndRadConvertor.Rad2deg(lat - halfSide/radius);
        double latMax = DegreeAndRadConvertor.Rad2deg(lat + halfSide/radius);
        double lonMin = DegreeAndRadConvertor.Rad2deg(lon - halfSide/pradius);
        double lonMax = DegreeAndRadConvertor.Rad2deg(lon + halfSide/pradius);

        return new BoundingBox(new MapPoint(latMin, lonMin),
                               new MapPoint(latMax, lonMax)
        );
    }
}
