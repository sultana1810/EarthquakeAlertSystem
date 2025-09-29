//Alert emergency services like fire, police, medical

public class EmergencyAlert extends Alert{
    private String serviceName;

    public EmergencyAlert(Earthquake earthquake, String serviceName) {
        super(earthquake);
        this.serviceName = serviceName;
    }
    @Override
    public void sendAlert() {
        System.out.println("\n🚨 ================================");
        System.out.println("    EMERGENCY SERVICE NOTIFICATION");
        System.out.println("==================================");
        System.out.println("Service: " + serviceName);
        System.out.println("Priority: URGENT");
        System.out.println("\n" + getAlertMessage());
        System.out.println("============================");
    }

    @Override
    public String getAlertMessage() {
        StringBuilder message = new StringBuilder();

        message.append("⚠️ EMERGENCY RESPONSE REQUIRED ⚠️\n\n");
        message.append("EARTHQUAKE EVENT:\n");
        message.append("• ID: ").append(earthquake.getId()).append("\n");
        message.append("• Magnitude: ").append(earthquake.getMagnitude()).append("\n");
        message.append("• Location: ").append(earthquake.getLocation()).append("\n");
        message.append("• Depth: ").append(earthquake.getDepth()).append(" km\n");
        message.append("• Alert Level: ").append(earthquake.getAlertLevel()).append("\n\n");

        message.append("ESTIMATED IMPACT:\n");
        message.append(estimateImpact()).append("\n\n");

        message.append("RECOMMENDED RESPONSE:\n");
        message.append(getResponseAction());

        return message.toString();
    }

    private String estimateImpact() {
        double mag = earthquake.getMagnitude();

        if (mag >= 8.0) {
            return "CATASTROPHIC - Mass casualties expected\n" +
                    "Infrastructure collapse likely";
        } else if (mag >= 7.0) {
            return "SEVERE - Significant casualties possible\n" +
                    "Major building damage expected";
        } else if (mag >= 6.0) {
            return "HIGH - Injuries likely\n" +
                    "Moderate to severe building damage";
        } else if (mag >= 5.0) {
            return "MODERATE - Minor injuries possible\n" +
                    "Some structural damage";
        } else {
            return "LOW - Minimal damage expected";
        }
    }

    private String getResponseAction() {
        switch(earthquake.getAlertLevel()) {
            case "CRITICAL":
                return "• Deploy all available units\n" +
                        "• Establish emergency command center\n" +
                        "• Coordinate evacuation\n" +
                        "• Prepare mass casualty response";
            case "HIGH":
                return "• Deploy emergency response teams\n" +
                        "• Assess structural damage\n" +
                        "• Set up medical triage\n" +
                        "• Monitor aftershock activity";
            case "MEDIUM":
                return "• Put teams on standby\n" +
                        "• Monitor situation\n" +
                        "• Prepare for possible escalation";
            default:
                return "• Monitor situation\n" +
                        "• No immediate deployment required";
        }
    }

    public String getServiceName() {
        return serviceName;
    }
}
