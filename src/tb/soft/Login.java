package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame {
    private final Map <String, String> login_data = new HashMap<>(); //deklaracja kolekcji typu HashMap

    public Login(String title) throws HeadlessException {
        super(title);
        database();
        interfejs();
    }

    private void interfejs(){   //tworzenie okna z interfejsem logowania
        JPanel panel= new JPanel();
        add(panel);
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.white);

        setBounds(450, 180, 600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel log_in_label = new JLabel("Nazwa ");
        set_element(panel, log_in_label, 0, 0);

        JTextField name = new JTextField(10);
        set_element(panel, name, 1, 0);

        JLabel password = new JLabel("Hasło ");
        set_element(panel, password, 0, 1);

        JPasswordField pass = new JPasswordField(10);
        set_element(panel, pass, 1, 1);
        pass.setEchoChar('×');

        JButton log_in = new JButton("Zaloguj");
        JButton reset = new JButton("Reset");

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_data(name, pass, panel);
            }
        });
        set_element(panel, log_in,0, 2);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(name, pass, panel);
            }
        });
        set_element(panel, reset, 1, 2);
    }

    private void add_user(String name, String password){
        this.login_data.put(name, password);
    }

    private void set_element(JPanel panel, JComponent element, int x, int y){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        panel.add(element, c);
        Font font=new Font(Font.DIALOG_INPUT,Font.BOLD,15);
        element.setFont(font);
    }

    private void check_data( JTextField name, JPasswordField password, JPanel panel ) { //sprawdzenie danych logowania
        String login = name.getText();

        if (login_data.containsKey(login)) {
            if (Arrays.equals(password.getPassword(), login_data.get(login).toCharArray())) {
                panel.setBackground(Color.green); //poprawne dane
            } else {
                panel.setBackground(Color.red); //niepoprawne dane
            }
        }
        else{
                panel.setBackground(Color.red); //niepoprawne dane
            }

    }

    private void reset(JTextField name, JPasswordField password, JPanel panel){ //reset
        name.setText("");
        password.setText("");
        panel.setBackground(Color.white);
    }

    private void database(){ //baza danych logowania
        add_user("admin"    ,   "admin")   ;
        add_user("papaya22" ,   "ttttt")   ;
        add_user("dolan"    ,   "quack")   ;
        add_user("test"     ,   "test")    ;
        add_user("259201"   ,   "student") ;
    }
}
