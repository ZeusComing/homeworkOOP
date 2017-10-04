public class Main {
    public static void main(String[] args) {
        Network topNetwork = new Network("topNetwork");
        Phone iPhone5S = new Phone("iPhone5S", 0.112, "0972531607" );
        Phone SamsungGalaxyJ5 = new Phone("Samsung Galaxy J5", 0.146, "0932600512");
        Phone LGK430 = new Phone("LG K430", 0.140, "0961578290");
        topNetwork.registration(iPhone5S.getNumber(), iPhone5S);
        topNetwork.registration(LGK430.getNumber(), LGK430);
        System.out.println("My number is " + iPhone5S.getNumber());
        iPhone5S.call(LGK430.getNumber());
        iPhone5S.call("0972531607");
        iPhone5S.call("0961578290");
        SamsungGalaxyJ5.call(iPhone5S.getNumber());
    }
}
