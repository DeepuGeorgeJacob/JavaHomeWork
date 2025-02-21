package com.app.Challenege2;

public class Building implements Mappable {

    private final String name;
    private final UsageType usageType;


    public Building(final String name, final UsageType usageType) {
        this.name = name;
        this.usageType = usageType;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, usageType);
    }

    @Override
    public String getMarker() {
        switch (usageType) {
            case SPORTS -> {
                return String.format("%s %s", Color.ORANGE.name(), PointMarkers.PUSH_PIN.name());
            }
            case GOVERNMENT -> {
                return String.format("%s %s", Color.RED.name(), PointMarkers.STAR.name());
            }
            case BUSINESS -> {
                return String.format("%s %s", Color.GREEN.name(), PointMarkers.TRIANGLE.name());
            }
            case ENTERTAINMENT -> {
                return String.format("%s %s", Color.BLACK.name(), PointMarkers.TRIANGLE.name());
            }
            default -> {
                return String.format("%s %s", Color.BLUE.name(), PointMarkers.CIRCLE.name());
            }
        }
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }
}
