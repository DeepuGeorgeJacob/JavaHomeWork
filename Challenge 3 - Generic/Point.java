public abstract class Point implements Mappable {

    protected double[] locations;

    public Point(final String location) {
        this.locations = Mappable.stringToLatLon(location);
    }

    String locations() {
        return String.format("([%s,%s])", locations[0],locations[1]);
    }
}
