package com.app.Challenege2;

public interface Mappable {

    String JSON_PROPERTY = "\"properties\" : { %s }";

    static void mapIt(final Mappable mappable) {
        final String json = mappable.toJson();
        System.out.println(json);
    }

    default String toJson() {
        return String.format(JSON_PROPERTY,
                String.format("\"type\" : \"%s\", \"label\" : \"%s\", \"marker\" : \"%s\"",
                        getShape(), getLabel(), getMarker()));
    }

    String getLabel();

    String getMarker();

    Geometry getShape();
}
