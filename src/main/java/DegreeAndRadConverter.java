class DegreeAndRadConverter {
    // degrees to radians
    static double Deg2rad(double degrees) {
        return Math.PI*degrees/180.0;
    }

    // radians to degrees
    static double Rad2deg(double radians) {
        return 180.0*radians/Math.PI;
    }
}
