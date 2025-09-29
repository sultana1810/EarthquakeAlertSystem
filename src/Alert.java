//this is the abstract class manee base class for all alert types(SMS, Email, Emergency)
//directly Alert objects toiri kora jabe naa

public abstract class Alert {
    protected Earthquake earthquake;

    public Alert(Earthquake earthquake) {
        this.earthquake = earthquake;
    }

    //abstract method
    public abstract void sendAlert();
    public abstract String getAlertMessage();

    //concrete method(has implementaton)
    protected String getFormattedTime() {
        return earthquake.getTimestamp();
    }
    protected String getSeverityEmoji() {
        switch (earthquake.getAlertLevel()) {
            case "CRITICAL":
                return "❤️";
            case "HIGH":
                return "🧡";
            case "MEDIUM" :
                return "💙";
            case "LOW" :
                return "💚";
            default :
                return "🤍";
        }


    }
}
