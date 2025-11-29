public class Classn {
    public String publicMessage = "видно отовсюду";
    protected String protectedMessage = "видно в пакете и наследниках";
    String defaultMessage = "видно только в пакете";
    private String privateMessage = "видно только в этом классе";

    public void showMessages() {
        System.out.println(publicMessage);
        System.out.println(protectedMessage);
        System.out.println(defaultMessage);
        System.out.println(privateMessage);
    }

    public static void main(String[] args) {
        Classn obj = new Classn();
        obj.showMessages();

        Helper helper = new Helper();
        helper.printAccessible();
    }
}

class Helper {
    void printAccessible() {
        Classn example = new Classn();
        System.out.println("Доступ из другого класса в том же пакете");
        System.out.println(example.publicMessage);
        System.out.println(example.protectedMessage);
        System.out.println(example.defaultMessage);
        // System.out.println(example.privateMessage); //ошибка- private недоступен
    }
}