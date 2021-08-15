public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            if (((MailPackage) mail).getContent().getContent().equals("weapons") || ((MailPackage) mail).getContent().getContent().equals("banned substance")) {
                throw new IllegalPackageException();
            }

            if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
