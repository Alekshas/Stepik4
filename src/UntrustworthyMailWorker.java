public class UntrustworthyMailWorker implements MailService {

    private final RealMailService realMailService;
    MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.realMailService = new RealMailService();
        this.mailServices = mailServices;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService : mailServices) {
            mail = mailService.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}
