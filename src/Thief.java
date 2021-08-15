public class Thief implements MailService {

    int value;
    int stolenValue = 0;

    public Thief(int value) {
        this.value = value;
    }

    public int getStolenValue(){
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if(((MailPackage)mail).getContent().getPrice() <= value){
            stolenValue +=value;
            return (Sendable) new Package("stones instead of"+((MailPackage)mail).getContent(),0);
        }
        return mail;
    }
}
