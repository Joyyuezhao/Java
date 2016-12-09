package edu.nyu.cs9053.homework12;

import edu.nyu.cs9053.homework12.model.Region;
import edu.nyu.cs9053.homework12.model.VehicleMake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: blangel
 * Date: 12/7/16
 * Time: 8:55 AM
 */
public class VehicleMakeFilterer {

    /**
     * @param region for which to query
     * @param nameStartsWith for which to check if the query results match
     * @param loader to load VehicleMake objects
     * @return loaded VehicleMake objects in {@code region} whose name starts with {@code nameStartsWith}
     */
    public static List<VehicleMake> loadMatching(Region region, String nameStartsWith, VehicleLoader loader) {
        if ((nameStartsWith == null) || (region == null) || (loader == null)) {
            throw new IllegalArgumentException("The VehicleLoader and both region and nameStartsWith are required when loading VehicleMake matches");
        }
        List<VehicleMake> regionMakes = loader.getVehicleMakesByRegion(region.name());
        if (regionMakes == null) {
            return null;
        }
        List<VehicleMake> matches = new ArrayList<>(regionMakes.size());
        for (VehicleMake make : regionMakes) {
            if ((make.getName() == null) || !make.getName().startsWith(nameStartsWith)) {
                continue;
            }
            matches.add(make);
        }
        return matches;
    }

    /**
     * Java 8 equivalent of {@link #loadMatching(Region, String, VehicleLoader)}
     * Note, this should use Java 8 streams API
     */
    public static /* TODO - add return type; remove this comment once completed */ loadMatchingJava8(Region region, String nameStartsWith, VehicleLoader loader) {
	// TODO - remove this comment once completed
    }

}
