public class River extends Line {
    private final String name;

    public River(final String name, final String... location) {
        super(location);
        this.name = name;
    }

    @Override
    public void render() {
        final String result = String.format("Render %s River as LINE %s", name, locations());
        System.out.println(result);
    }
}
