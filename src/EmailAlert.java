public class EmailAlert extends Alert{
    private String emailAddress;

    public EmailAlert(Earthquake earthquake, String emailAdress) {
        super(earthquake);
        this.emailAddress = emailAdress;
    }

    @Override
    public void sendAlert() {
        System.out.println("\n==========================");
        System.out.println("    EMAIL ALERT SENT");
        System.out.println("===========================");
        System.out.println("To: " + emailAddress);
        System.out.println("Subject: EARTHQUAKE WARNING - " + earthquake.getAlertLevel());
        System.out.println("\n" + getAlertMessage());
        System.out.println("=====================");
    }

    @Override
    public String getAlertMessage() {
        StringBuilder message = new StringBuilder();

        message.append("═══ EARTHQUAKE ALERT ═══\n\n");
        message.append(getSeverityEmoji()).append(" ALERT LEVEL: ")
                .append(earthquake.getAlertLevel()).append("\n\n");

        message.append("DETAILS:\n");
        message.append("• ID: ").append(earthquake.getId()).append("\n");
        message.append("• Magnitude: ").append(earthquake.getMagnitude())
                .append(" on Richter Scale\n");
        message.append("• Location: ").append(earthquake.getLocation()).append("\n");
        message.append("• Depth: ").append(earthquake.getDepth()).append(" km\n");
        message.append("• Time: ").append(earthquake.getTimestamp()).append("\n\n");

        message.append("IMPACT ASSESSMENT:\n");
        message.append(earthquake.getImpactDescription()).append("\n\n");

        message.append("SAFETY INSTRUCTIONS:\n");
        message.append(getSafetyInstructions()).append("\n");

        return message.toString();
    }

    private String getSafetyInstructions() {
        switch(earthquake.getAlertLevel()) {
            case "CRITICAL":
                return "1. EVACUATE immediately to open areas\n" +
                        "2. Stay away from buildings and power lines\n" +
                        "3. If trapped, signal for help\n" +
                        "4. Listen to emergency broadcasts";
            case "HIGH":
                return "1. DROP, COVER, and HOLD ON\n" +
                        "2. Take cover under sturdy furniture\n" +
                        "3. Stay away from windows\n" +
                        "4. Be prepared for aftershocks";
            case "MEDIUM":
                return "1. Stay alert and identify safe spots\n" +
                        "2. Check emergency supplies\n" +
                        "3. Review evacuation routes\n" +
                        "4. Keep phone charged";
            default:
                return "1. Stay calm and monitor updates\n" +
                        "2. No immediate action required\n" +
                        "3. Review emergency procedures";
        }
    }

    public String getEmailAdress() {
        return emailAddress;
    }


}
