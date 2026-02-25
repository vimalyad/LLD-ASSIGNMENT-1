package utils.impl;

import entities.GeoPoint;
import utils.behaviours.IDistanceCalculator;

public class DistanceCalculator implements IDistanceCalculator {
    public double km(GeoPoint a, GeoPoint b) {
        double d = Math.abs(a.lat - b.lat) + Math.abs(a.lon - b.lon);
        return Math.round((d * 200.0) * 10.0) / 10.0;
    }
}
