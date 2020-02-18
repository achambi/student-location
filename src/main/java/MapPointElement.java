public class MapPointElement extends MapPoint {
    private final String name;

    public MapPointElement(String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.name = name;
    }
}
