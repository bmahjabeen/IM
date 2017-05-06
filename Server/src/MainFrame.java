import javax.swing.*;

public class MainFrame extends JFrame {
    private JToggleButton jButtonIMServer1;
    private JDialog jDialog1;
    public JButton jButton1;
    private JButton buttonSignIn;
    private JLabel jLabel1;
    private JLabel labelWelcome;
    private JLabel jLabel3;
    private JLabel jLabelIMServerStatus;
    private JPanel panelAuthenticatedFrame;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    static JTextArea jTextAreaMsgConsole;
    private JFrame self = this;

    public MainFrame() {
        initComponents();
        this.jTextAreaMsgConsole.append("\nIM Server loaded.");
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

    private void initComponents() { // TODO break into separate components
        jScrollPane1 = new JScrollPane();
        jTextAreaMsgConsole = new JTextArea();
        panelAuthenticatedFrame = new JPanel();
        jLabel1 = new JLabel();
        jLabelIMServerStatus = new JLabel();
        jButton1 = new JButton();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jPanel3 = new JPanel();
        labelWelcome = new JLabel();
        buttonSignIn = new JButton();
        jButtonIMServer1 = new JToggleButton();
        AuthenticatedFrame authenticatedFrame = new AuthenticatedFrame(jButtonIMServer1, jLabelIMServerStatus, jTextAreaMsgConsole, labelWelcome);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("IM");
        setResizable(false);

        jTextAreaMsgConsole.setColumns(20);
        jTextAreaMsgConsole.setEditable(false);
        jTextAreaMsgConsole.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaMsgConsole.setLineWrap(true);
        jTextAreaMsgConsole.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMsgConsole);
        panelAuthenticatedFrame.setVisible(false);
        jLabel1.setText("IM Server");

        jLabelIMServerStatus.setText("IM Server is Down now.");

        jButton1.setText("Manage Users");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });

        GroupLayout jPanel1Layout = new GroupLayout(panelAuthenticatedFrame);
        panelAuthenticatedFrame.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonIMServer1)
                                                .addGap(72, 72, 72)
                                                .addComponent(jLabelIMServerStatus)
                                                .addGap(63, 63, 63))
                                        .addComponent(jButton1, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButtonIMServer1)
                                        .addComponent(jLabelIMServerStatus))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(jButton1))
        );

        jLabel3.setText("Message Console");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
        );

        labelWelcome.setText("You Must Sign In as an Admin to operate IM Server");

        buttonSignIn.setText("Sign In");
        buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String userName = Authentication.authenticate(self);
                if (userName != null) {
                    buttonSignIn.setVisible(false);
                    authenticatedFrame.setup(userName);
                    panelAuthenticatedFrame.setVisible(true);
                }
                else {
                    javax.swing.JOptionPane.showMessageDialog(self, "Authentication Failed!");
                }
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(labelWelcome, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSignIn)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSignIn)
                                        .addComponent(labelWelcome)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(panelAuthenticatedFrame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(75, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelAuthenticatedFrame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-497)/2, (screenSize.height-500)/2, 497, 500);
    }
}
