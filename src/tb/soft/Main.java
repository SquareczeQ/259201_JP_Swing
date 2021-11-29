package tb.soft;

public class Main {

    public static void main(String[] args) {
	try {
        Login login = new Login("Logowanie");
        login.setVisible(true);
    }
	catch (Exception e) {
	    e.printStackTrace(System.err);
    }
    }
}
