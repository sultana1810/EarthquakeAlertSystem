public class Main {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("|🌏 EARTHQUAKE ALERT SYSTEM                    |");
        System.out.println("|   Real-time Seismic Monitoring & Alert System |");
        System.out.println("=================================================");
        System.out.println();

        EarthquakeMonitoringSystem system = new EarthquakeMonitoringSystem();

        // subs. users to alert
        System.out.println("📋 REGISTERING SUBSCRIBERS...");
        System.out.println("====================================");
        system.subscribePhoned("+880 0123456789");  // Bangladesh
        system.subscribePhoned("+1-555-0101");       // USA
        system.subscribeEmail("alert@tokyo.gov.bd");
        system.subscribeEmail("emergency@usa.gov");
        system.subscribeEmail("user@example.com");

        // Simulate earthquake 1 - CRITICAL in Tokyo
        System.out.println("\n\n🌐 SEISMIC ACTIVITY DETECTED...");
        Location tokyo = new Location("Tokyo", "Japan", 35.6762, 139.6503);
        system.detectEarthQuake(tokyo, 7.2, 30, "2025-09-29 14:30:15", "CRITICAL");

        // Simulate earthquake 2 - MEDIUM in San Francisco
        System.out.println("\n\n🌐 SEISMIC ACTIVITY DETECTED...");
        Location sanFrancisco = new Location("San Francisco", "USA", 37.7749, -122.4194);
        system.detectEarthQuake(sanFrancisco, 4.5, 15, "2025-09-29 15:45:30", "MEDIUM");

        // Simulate earthquake 3 - HIGH in Nepal
        System.out.println("\n\n🌐 SEISMIC ACTIVITY DETECTED...");
        Location kathmandu = new Location("Kathmandu", "Nepal", 27.7172, 85.3240);
        system.detectEarthQuake(kathmandu, 5.8, 10, "2025-09-29 16:20:45", "HIGH");

        // Simulate earthquake 4 - LOW in Los Angeles
        System.out.println("\n\n🌐 SEISMIC ACTIVITY DETECTED...");
        Location losAngeles = new Location("Los Angeles", "USA", 34.0522, -118.2437);
        system.detectEarthQuake(losAngeles, 3.2, 8, "2025-09-29 17:10:00", "LOW");


        system.displayAllEarthquakes();

        System.out.println("\n===============================================");
        System.out.println("|  ✅ SYSTEM MONITORING COMPLETE                |");
        System.out.println("|  Stay safe and prepared!                      |");
        System.out.println("=================================================");


    }
}
