package main.java.projekt.models;

import main.java.projekt.models.konteners.ContainerPrimary;

import java.util.ArrayList;
import java.util.List;

public class RailwayWagon {
    private static final List<ContainerPrimary> listOfContainers = new ArrayList<>();
    private static final int maxContainers = 10;

    public static List<ContainerPrimary> getListOfContainers() {
        return listOfContainers;
    }

    public static int getMaxContainers() {
        return maxContainers;
    }
}
