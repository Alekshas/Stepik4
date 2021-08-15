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
        for (int i = 0; i < mailServices.length; i++) {
            mailServices[i].processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}
