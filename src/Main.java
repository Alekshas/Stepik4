import java.awt.event.MouseAdapter;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Package package1 = new Package("stones",3000);
        MailMessage mailMessage1 = new MailMessage("Lesha","stones","Hi");

        MailPackage mailPackage = new MailPackage("Lesha","Nastya", package1);
        Inspector inspector = new Inspector();
        //inspector.processMail(mailMessage1);
        inspector.processMail((Sendable) mailPackage);


//        Logger logger = Logger.getLogger(Main.class.getName());
//        Spy spy = new Spy(logger);
//        spy.processMail(mailMessage1);
//        MailMessage mailMessage2 = new MailMessage("Austin Powers","Nastya","Hi");
//        spy.processMail(mailMessage2);

    }
}
