//this will inherit Alert

public class SMSAlert extends Alert {
    private String phoneNumber;

    public SMSAlert(Earthquake earthquake, String phoneNumber) {
        super(earthquake); // call parent (Alert) constructors
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void sendAlert() {
        System.out.println("\n=======================");
        System.out.println("  SMS ALERT SENT");
        System.out.println("=====================");
        System.out.println("To : " + phoneNumber);
        System.out.println("Time : " + getFormattedTime());
        System.out.println("\nMessage : " );
        System.out.println(getAlertMessage());
        System.out.println("=====================");
    }

    @Override
    public String getAlertMessage() {
        // using parents getSeverityEmoji() method
        String emoji = getSeverityEmoji();

        String message = emoji + "\nEARTHQUAKE ALERT!!\n";
        message += "Magnitude : " + earthquake.getMagnitude() + "\n";
        message += "Location : " + earthquake.getLocation() + "\n";
        message += "Level : " + earthquake.getAlertLevel() + "\n";
        message += getQuickAction();

        return message;
    }

    private String getQuickAction() {
        switch(earthquake.getAlertLevel()) {
            case "CRITICAL" :
                return "ACTION : EVACUATE NOW!!";
            case "HIGH" :
                return "ACTION : TAKE COVER IMMEDIATELY";
            case "MEDIUM":
                return "ACTION : DROP< COVER< HOLD ON!";
            default :
                return "ACTION : STAY ALERT!";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
