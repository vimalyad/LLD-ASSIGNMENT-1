package utils.impl;

import utils.behaviours.IDriverAllocator;

public class DriverAllocator implements IDriverAllocator {

    @Override
    public String allocate(String studentId) {
        return "DRV-17";
    }
}
