public interface Mappable {

    static double[] stringToLatLon(String location) {
        String[] parts = location.split(",");
        double[] coordinates = new double[2];
        coordinates[0] = Double.parseDouble(parts[0].trim());
        coordinates[1] = Double.parseDouble(parts[1].trim());
        return coordinates;
    }
    void render();
}
