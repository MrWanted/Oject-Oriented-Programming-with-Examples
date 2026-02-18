package oop.basics.solid;

// Abstraction
interface NotificationService {
    void send(String message);
}

// Low-level module
class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

// High-level module
class AlertManager {
    private final NotificationService notificationService;

    // Depend on abstraction, not implementation
    public AlertManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendAlert(String message) {
        notificationService.send(message);
    }
}

// Demo class
public class DependencyInversion {

    public static void main(String[] args) {
        NotificationService service = new EmailNotificationService();
        AlertManager alertManager = new AlertManager(service);

        alertManager.sendAlert("System outage detected");
    }
}

