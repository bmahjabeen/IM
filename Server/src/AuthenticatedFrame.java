import javax.swing.*;
import java.awt.event.ActionEvent;

public class AuthenticatedFrame {
    JToggleButton buttonIMServer;
    JLabel jLabelIMServerStatus;
    JTextArea jTextAreaMsgConsole;
    private JLabel labelWelcome;

    public AuthenticatedFrame(JToggleButton buttonIMServer,
                              JLabel labelIMServerStatus,
                              JTextArea textAreaMsgConsole,
                              JLabel labelWelcome) {
        this.buttonIMServer = buttonIMServer;
        this.jLabelIMServerStatus = labelIMServerStatus;
        this.jTextAreaMsgConsole = textAreaMsgConsole;
        this.labelWelcome = labelWelcome;

        this.buttonIMServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleStartStop(evt);
            }
        });
    }

    public void setup(String userName) {
        labelWelcome.setText("Welcome " + userName + "!");
        buttonIMServer.setText("Start");
    }

    private void handleStartStop(ActionEvent evt) {
        if(evt.getActionCommand().equals("Start")) {
            buttonIMServer.setText("Stop");
            buttonIMServer.setActionCommand("Stop");
            jLabelIMServerStatus.setText("IM Server is UP now.  ");
            jTextAreaMsgConsole.append("\nIMServer Listening Started.");
        }
        if(evt.getActionCommand().equals("Stop")) {
            buttonIMServer.setText("Start");
            buttonIMServer.setActionCommand("Start");
            jLabelIMServerStatus.setText("IM Server is DOWN now.");
            jTextAreaMsgConsole.append("\nIMServer Listening Stopped.");
        }
    }
}

