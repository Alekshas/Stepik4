import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {

    Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            if (mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers")) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + " \"" + ((MailMessage) mail).getMessage() + "\"");
            } else {
                logger.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
            }
        }
        return mail;
    }
}
