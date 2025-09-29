//purpose : store geographical location data

public class Location {
    private String city;
    private String country;
    private double latitude;
    private double longitude;

    public Location(String city, String country, double latitude, double longitude) {
        this.city = city;
        this.country = country;;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    //override toString() method
    //ei method ta  call hoy jokhon object(string) ta print korar dorkar hoy,,,,,,,System.out.println(location)

    @Override
    public String toString() {
        return city + ", " + country + " (Lat : " + latitude + ", Lon : " + longitude + ")";
    }


 }
