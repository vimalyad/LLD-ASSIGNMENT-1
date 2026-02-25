package utils.behaviours;

import entities.GeoPoint;

public interface IDistanceCalculator {
    double km(GeoPoint p1, GeoPoint p2);
}
