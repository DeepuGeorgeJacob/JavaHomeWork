package com.app.Challenege2;

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType utilityType;

    public UtilityLine(String name, UtilityType utilityType) {
        this.name = name;
        this.utilityType = utilityType;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, utilityType);

    }

    @Override
    public String getMarker() {
        switch (utilityType) {
            case WATER -> {
                return String.format("%s %s", Color.RED.name(), PointMarkers.DOTTED.name());
            }
            case ELECTRICAL -> {
                return String.format("%s %s", Color.GREEN.name(), PointMarkers.DOTTED.name());
            }
            default -> {
                return String.format("%s %s", Color.BLUE.name(), PointMarkers.SOLID.name());
            }
        }
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }
}
