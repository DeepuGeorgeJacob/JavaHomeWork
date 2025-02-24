public class Park extends Point {
    private final String name;

    public Park(final String name, final String location) {
        super(location);
        this.name = name;
    }

    @Override
    public void render() {
        final String result = String.format("Render %s Park as POINT %s", name, locations());
        System.out.println(result);
    }
}
