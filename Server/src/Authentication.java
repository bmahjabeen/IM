import javax.swing.*;

public class Authentication {
    public static String authenticate(JFrame parentComponent)
    {
        String userName = (String)javax.swing.JOptionPane.showInputDialog(
                parentComponent,
                "User Name",
                "Authorizing...",
                javax.swing.JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        String password = (String)javax.swing.JOptionPane.showInputDialog(
                parentComponent,
                "Enter the password for the account...",
                "Password",
                javax.swing.JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        System.out.println("dummy login"); // TODO real login
        return userName;
    }
}
