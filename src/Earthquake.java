//represent an earthquake event with all details

public class Earthquake {
    private String id;
    private Location location;    // Composition : Eq. "has a" location
    private double magnitude;     // Richter scale e.g, 7.2
    private int depth;            // kilometers below surface
    private String timestamp;      // kokhon hoyeche
    private String alertLevel;     // critical, high, medium, low

    public Earthquake(String id, Location location, double magnitude, int depth, String timestamp, String alertLevel) {
        this.id = id;
        this.location = location;
        this.magnitude = magnitude;
        this.depth = depth;
        this.timestamp = timestamp;
        this.alertLevel = alertLevel;
    }

    private String determineAlertLevel() {
        if(magnitude >= 7.0) return "CRITICAL";
        else if(magnitude >= 5.5) return "HIGH";
        else if(magnitude >= 4.0) return "MEDIUM";
        else return "LOW";

    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public int getDepth() {
        return depth;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void displayInfo() {
        System.out.println("\n---------------------------");
        System.out.println("🚨 EARTHQUAKE DETECTED ");
        System.out.println("-------------------------");
        System.out.println("ID : " + id);
        System.out.println("Location " + location); // calls location.toString
        System.out.println("Magnitude : " + magnitude + " on Richter Scale !!");
        System.out.println("Depth : " + depth + " KM below surface!!");
        System.out.println("Time : " + timestamp);
        System.out.println("Alert Level : " + alertLevel);
        System.out.println("-------------------------");
    }

    public String getImpactDescription() {
        switch(alertLevel) {
            case "CRITICAL" :
                return "Severe damage expected. Evacuate immediately!!";
            case "HIGH" :
                return "Significant damage possible. Take cover!!";
            case "MEDIUM" :
                return "Moderate shaking. Stay alert!";
            case "LOW" :
                return "Minor tremor. Stay calm!";
            default :
                return "Unknown impact";
        }
    }

}
