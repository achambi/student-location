
class MapPoint {
    private final double latitude;
    private final double longitude;

    MapPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    double getLongitude() {
        return longitude;
    }

    double getLatitude() {
        return latitude;
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

    BoundingBox createBoundingBox(double halfSideInMts) {
        // Bounding box surrounding the point at given coordinates,
        // assuming local approximation of Earth surface as a sphere
        // of radius given by WGS84
        double lat = DegreeAndRadConverter.Deg2rad(this.getLatitude());
        double lon = DegreeAndRadConverter.Deg2rad(this.getLongitude());

        // Radius of Earth at given latitude
        double radius = WGS84EarthRadius(lat);
        // Radius of the parallel at given latitude
        double pradius = radius*Math.cos(lat);

        double latMin = DegreeAndRadConverter.Rad2deg(lat - halfSideInMts/radius);
        double latMax = DegreeAndRadConverter.Rad2deg(lat + halfSideInMts/radius);
        double lonMin = DegreeAndRadConverter.Rad2deg(lon - halfSideInMts/pradius);
        double lonMax = DegreeAndRadConverter.Rad2deg(lon + halfSideInMts/pradius);

        return new BoundingBox(new MapPoint(latMin, lonMin),
                               new MapPoint(latMax, lonMax)
        );
    }
}
