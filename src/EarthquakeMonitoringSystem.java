// main system that co-ordinates everything
// concept : collections(arryList), static variables

import java.util.ArrayList;

public class EarthquakeMonitoringSystem {
    private ArrayList<Earthquake> earthquakeHistory;
    private ArrayList<String> subscribedPhones;
    private ArrayList<String> subscribedEmails;

    public static int earthquakeCounter = 1000;

    public EarthquakeMonitoringSystem() {
        this.earthquakeHistory = new ArrayList<>();
        this.subscribedPhones = new ArrayList<>();
        this.subscribedEmails = new ArrayList<>();
    }

    public void subscribePhoned(String phone) {
        subscribedPhones.add(phone);
        System.out.println("Phone Subscribed : " + phone);
    }

    public void subscribeEmail(String email) {
        subscribedEmails.add(email);
        System.out.println("Email subscribed : " + email);
    }

    //main method---notun earthquake detect korar jonne
    public void detectEarthQuake(Location location, double magnitude, int depth, String timestamp, String alertLevel) {
        String id = "EQ" + (earthquakeCounter++);
        Earthquake earthquake = new Earthquake(id, location, magnitude, depth, timestamp, alertLevel);
        earthquakeHistory.add(earthquake);
        earthquake.displayInfo();
        processAlerts(earthquake);
    }

    private void processAlerts(Earthquake earthquake) {
        System.out.println("\n PROCESSING ALERTS...");
        System.out.println("=========================");

        // send SMS to phone subs.
        for(String phone : subscribedPhones) {
            Alert smsAlert = new SMSAlert(earthquake, phone);
            smsAlert.sendAlert();
        }

        //send email to email subs.
        for (String email : subscribedEmails) {
            Alert emailAlert = new EmailAlert(earthquake, email);
            emailAlert.sendAlert();
        }

        // send emer. alert
        if (earthquake.getAlertLevel().equals("CRITICAL") ||
                earthquake.getAlertLevel().equals("HIGH")) {
            Alert emergencyAlert = new EmergencyAlert(earthquake, "National Emergency Response Center");
            emergencyAlert.sendAlert();
        }

        System.out.println("\nALL ALERTS SENT");

    }

    public void displayAllEarthquakes() {
        System.out.println(" ALL RECORDED EARTHQUAKES");
        System.out.println("=================================");

        if (earthquakeHistory.isEmpty()) {
            System.out.println("No earthquakes recorded yet.");
            return;
        }

        for (Earthquake eq : earthquakeHistory) {
            System.out.println(eq.getId() + " | " +
                    eq.getLocation().getCity() + " | " +
                    "Mag: " + eq.getMagnitude() + " | " +
                    eq.getAlertLevel());
        }
        System.out.println("==============================");
    }

}
