public abstract class Line implements Mappable {
    protected double[][] locations;

    public Line(final String[] locations) {
        this.locations = new double[locations.length][2];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Mappable.stringToLatLon(locations[i]);
        }
    }

    String locations() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("([");
        for (double[] location : locations) {
            stringBuilder.append(String.format("[%s,%s],", location[0], location[1]));
        }
        final int index = stringBuilder.lastIndexOf(",");
        stringBuilder.replace(index, index + 1, "");
        stringBuilder.append("])");
        return stringBuilder.toString();
    }
}
