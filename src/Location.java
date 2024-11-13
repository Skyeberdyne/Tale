import java.util.*;

public class Location {

    // Fields:
    private String currentLocation;
    // private DetermineResult newResult;
    private Map<String, String> challengeTable; // This contains all the location's natural position and effect values

    //------------------------------------------------------------------------------------------//

    // Constructor:
    public Location() {
        // this.newResult = newResult;
        this.currentLocation = "A1";
    }

    //------------------------------------------------------------------------------------------//

    //
    public void changeLocation(String newLocation) {
        this.currentLocation = newLocation;
        // this.newResult.alterChallengeFile(newLocation);
    }

    //------------------------------------------------------------------------------------------//

    //
    public String reportLocation() {
        return this.currentLocation;
    }
}
