import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.io.File;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;

public abstract class ChroneApp extends JFrame implements ActionListener {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3309/java";
    private static final String USERNAME = "location";
    private static final String PASSWORD = "database";

    // Regular expression patterns
    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,15}$";
    private static final String NAME_PATTERN = "^[a-zA-Z]{1,50}$";
  
    

    public ChroneApp() {
        JFrame openPage =new JFrame("Welcome");
        openPage.setSize(460, 400);
        openPage.setLayout(null);
        openPage.setLocationRelativeTo(null);
        openPage.setResizable(false);
        openPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openPage.getContentPane().setBackground(Color.ORANGE);

        JTextArea textArea =new JTextArea(" Hello! Choose Your Account Here!");
        textArea.setBounds(150,1,300,300);
        textArea.setFont(new Font("Times New Roman",Font.BOLD,20));
        textArea.setForeground(Color.RED);
        textArea.setLineWrap(true);
       // textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        openPage.add(textArea);

        JButton user = new JButton("USER");
        JButton admin = new JButton("ADMIN");
        user.setBounds(20,80,100,30);
        admin.setBounds(20,200,100,30);
        openPage.add(admin);
        openPage.add(user);
        

        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                               
        JFrame example = new JFrame("WELCOME TO STUDENT'S PORTAL");
        example.setSize(600, 500);
        example.setLayout(null);
        example.setLocationRelativeTo(null);
        example.setResizable(false);
        example.getContentPane().setBackground(Color.LIGHT_GRAY);

        JOptionPane.showMessageDialog(example, "Welcome to user's account!", "User account", JOptionPane.INFORMATION_MESSAGE);
        
        JLabel usernameLabel = new JLabel("UserName");
        JTextField usernameField = new JTextField();
        example.add(usernameLabel);
        usernameLabel.setLocation(130, 105);
        usernameLabel.setSize(150, 20);
        usernameField.setLocation(230, 105);
        usernameField.setSize(150, 20);
        example.add(usernameField);

        JButton back =new JButton("<====");
        back.setBounds(0, 0,130,20);
        back.setFont(new Font("Arial", Font.ITALIC, 30));
        back.setBackground(Color.GRAY);
        example.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                example.dispose();
                JFrame openPage = new JFrame();
            }
        });


        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        example.add(passwordLabel);
        passwordLabel.setLocation(130, 160);
        passwordLabel.setSize(150, 20);
        passwordField.setLocation(230, 160);
        passwordField.setSize(150, 20);
        example.add(passwordField);

        JCheckBox showPassword = new JCheckBox("Show password");
        showPassword.setBounds(190, 185, 120, 25);
        showPassword.setForeground(Color.BLUE);
        showPassword.setBackground(Color.lightGray);
        example.add(showPassword);
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (showPassword.isSelected()){
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        });

        JButton signin = new JButton("SignIn");
        example.add(signin);
        signin.setSize(100, 20);
        signin.setLocation(280, 230);

        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sign = new JFrame("SIGN IN");
                sign.setSize(600, 500);
                sign.setLocationRelativeTo(null);
                sign.setLayout(null);
                sign.setResizable(false);
                sign.getContentPane().setBackground(Color.ORANGE);

                JLabel firstNameLabel = new JLabel("First Name");
                JTextField firstNameField = new JTextField();
                sign.add(firstNameLabel);
                sign.add(firstNameField);
                firstNameLabel.setSize(100, 20);
                firstNameLabel.setLocation(100, 20);
                firstNameField.setSize(140, 20);
                firstNameField.setLocation(200, 20);

                JLabel secondNameLabel = new JLabel("Second Name");
                JTextField secondNameField = new JTextField();
                sign.add(secondNameLabel);
                sign.add(secondNameField);
                secondNameLabel.setSize(100, 20);
                secondNameLabel.setLocation(100, 50);
                secondNameField.setSize(140, 20);
                secondNameField.setLocation(200, 50);

                JLabel userNameLabel = new JLabel("UserName");
                JTextField userNameField = new JTextField();
                sign.add(userNameLabel);
                sign.add(userNameField);
                userNameLabel.setSize(100, 20);
                userNameLabel.setLocation(100, 80);
                userNameField.setSize(140, 20);
                userNameField.setLocation(200, 80);

                JLabel emailLabel = new JLabel("Email");
                JTextField emailField = new JTextField();
                sign.add(emailLabel);
                sign.add(emailField);
                emailLabel.setSize(100, 20);
                emailLabel.setLocation(100, 110);
                emailField.setSize(140, 20);
                emailField.setLocation(200, 110);

                JLabel passwordLabel = new JLabel("Password");
                JPasswordField passwordField = new JPasswordField();
                sign.add(passwordLabel);
                sign.add(passwordField);
                passwordLabel.setSize(100, 20);
                passwordLabel.setLocation(100, 140);
                passwordField.setSize(140, 20);
                passwordField.setLocation(200, 140);

                JLabel idLabel = new JLabel("ID No");
                JPasswordField idField = new JPasswordField();
                sign.add(idLabel);
                sign.add(idField);
                idLabel.setSize(100, 20);
                idLabel.setLocation(300, 140);
                idField.setSize(140, 20);
                idField.setLocation(400, 140);

                JLabel dateLabel = new JLabel("D.O.B");
                JTextField dateField = new JTextField();
                sign.add(dateLabel);
                sign.add(dateField);
                dateLabel.setSize(100, 20);
                dateLabel.setLocation(100, 170);
                dateField.setSize(140, 20);
                dateField.setLocation(200, 170);

                JButton register = new JButton("Register");
                register.setSize(100, 20);
                register.setLocation(110, 220);
                sign.add(register);

                register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String firstName = firstNameField.getText();
                        String secondName = secondNameField.getText();
                        String userName = userNameField.getText();
                        String email = emailField.getText();
                        String password = new String(passwordField.getPassword());
                        String dateOfBirth = dateField.getText();
                        String user_id = idField.getText();

                        if (!isValid(NAME_PATTERN, firstName)) {
                            JOptionPane.showMessageDialog(sign, "Invalid first name", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!isValid(NAME_PATTERN, secondName)) {
                            JOptionPane.showMessageDialog(sign, "Invalid second name", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!isValid(USERNAME_PATTERN, userName)) {
                            JOptionPane.showMessageDialog(sign, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!isValid(EMAIL_PATTERN, email)) {
                            JOptionPane.showMessageDialog(sign, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!isValid(PASSWORD_PATTERN, password)) {
                            JOptionPane.showMessageDialog(sign, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String sql = "INSERT INTO project (firstName, secondName, userName, email, password, dateOfBirth, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

                        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                            preparedStatement.setString(1, firstName);
                            preparedStatement.setString(2, secondName);
                            preparedStatement.setString(3, userName);
                            preparedStatement.setString(4, email);
                            preparedStatement.setString(5, password);
                            preparedStatement.setString(6, dateOfBirth);
                            preparedStatement.setString(7, user_id);

                            int rowInserted = preparedStatement.executeUpdate();
                            if (rowInserted > 0) {
                                sign.dispose();
                                JFrame example = new JFrame();
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JButton back = new JButton("Back");
                back.setSize(100, 20);
                back.setLocation(250, 220);
                sign.add(back);

                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sign.dispose();
                    }
                });

                sign.setVisible(true);
            }
        });

        JButton loginButton = new JButton("Login");
        example.add(loginButton);
        loginButton.setSize(100, 20);
        loginButton.setLocation(150, 230);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if (!isValid(USERNAME_PATTERN, enteredUsername)) {
                    JOptionPane.showMessageDialog(example, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!isValid(PASSWORD_PATTERN, enteredPassword)) {
                    JOptionPane.showMessageDialog(example, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                    String checkUserQuery = "SELECT password FROM project WHERE userName = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(checkUserQuery)) {
                        preparedStatement.setString(1, enteredUsername);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            String storedPassword = resultSet.getString("password");
                            if (storedPassword.equals(enteredPassword)) {
            
                                JFrame login = new JFrame("Dashboard");
                                login.setSize(600, 500);
                                login.setLayout(null);
                                login.setLocationRelativeTo(null);
                                login.setResizable(false);
                                login.getContentPane().setBackground(Color.BLUE);
                                login.setDefaultCloseOperation(EXIT_ON_CLOSE);

                                JOptionPane.showMessageDialog(login, "Login successfull", "Login", JOptionPane.INFORMATION_MESSAGE);
                               
                                JButton notification = new JButton("Nofications");
                                JButton submission = new JButton("Submssions");
                                JButton help = new JButton("Helb/Suggestiond");
                                JButton transcript = new JButton("Transcript");
                                JButton course = new JButton("Courses Offered");
                                JButton fee = new JButton("School Fees");
                                JButton passwordChange = new JButton("Privacy");
                                JButton exitpage = new JButton("Exit");
                                JButton logout = new JButton("Logout"); 
                                JTextArea area = new JTextArea("WELCOME TO CHUKA UNIVERSITY");
                                JButton profile = new JButton("Profile"); 
                              //  String imagePath = "Kenya-Government.jpg";
                                ImageIcon image = new ImageIcon("Kenya-Government.jpg");
                               JLabel imageLabel = new JLabel(image);
                               imageLabel.setBounds(2,340,100,100);
                               login.add(imageLabel);
                                login.add(exitpage);
                                login.add(profile);
                                login.add(passwordChange);
                                login.add(area);
                                login.add(notification);
                                login.add(submission);
                                login.add(help);
                                login.add(transcript);
                                login.add(course);
                                login.add(fee);
                                login.add(logout);
                                profile.setBounds(480,280,100,20);
                                passwordChange.setBounds(480,330,100,20);
                                exitpage.setBounds(480,430,100,20);
                                area.setBounds(115,5,355,450);
                                area.setForeground(Color.black);
                                area.setBackground(Color.LIGHT_GRAY);
                                area.setLineWrap(true);
                                area.setWrapStyleWord(true);
                                area.setEditable(false);
                                area.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
                              
                             try (Connection connecting = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                             Statement statement = connecting.createStatement();
                                ResultSet result= statement.executeQuery("SELECT *  FROM project")){
                                    int columnCount = result.getMetaData().getColumnCount();
                                    StringBuilder data = new StringBuilder();
                                    for (int i = 1; i<=columnCount; i++){
                                        data.append(result.getMetaData().getColumnName(i)).append("\t");
                                    }
                                    data.append("\n");
                                    while (result.next()) {
                                        for(int i = 1; i<=columnCount; i++){
                                            data.append(result.getString(i)).append("\t");
                                        }
                                        data.append("\n");
                                    }
                                    area.setText(data.toString());
                                } catch (Exception j){
                                    j.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Error loading data from database:" +j.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                                }

                                logout.setSize(100,20);
                                logout.setLocation(480,380);
                                //logout.setBorder(null);
                                notification.setSize(100,20);
                                notification.setLocation(8,40);
                                submission.setSize(100,20);
                                submission.setLocation(8,90);
                                help.setSize(100,20);
                                help.setLocation(8,140);
                                transcript.setSize(100,20);
                                transcript.setLocation(8,190);
                                course.setSize(100,20);
                                course.setLocation(8,240);
                                fee.setSize(100,20);
                                fee.setLocation(8,290);

        /*************************************************PASSWORD CHANGE******************************************/
                                passwordChange.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame resetPasswordFrame = new JFrame("Reset Password");
                                        resetPasswordFrame.setSize(359, 300);
                                        resetPasswordFrame.setLocationRelativeTo(null);
                                        resetPasswordFrame.setLayout(null);
                                        resetPasswordFrame.setResizable(false);
                                        resetPasswordFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
                        
                                        JLabel emailLabel = new JLabel("Email:");
                                        JTextField emailField = new JTextField();
                                        emailLabel.setBounds(50, 50, 100, 25);
                                        emailField.setBounds(150, 50, 150, 25);
                                        resetPasswordFrame.add(emailLabel);
                                        resetPasswordFrame.add(emailField);
                        
                                        JLabel newPasswordLabel = new JLabel("New Password:");
                                        JPasswordField newPasswordField = new JPasswordField();
                                        newPasswordLabel.setBounds(50, 100, 100, 25);
                                        newPasswordField.setBounds(150, 100, 150, 25);
                                        resetPasswordFrame.add(newPasswordLabel);
                                        resetPasswordFrame.add(newPasswordField);
                        
                                        JButton resetButton = new JButton("Reset Password");
                                        resetButton.setBounds(100, 200, 150, 25);
                                        resetPasswordFrame.add(resetButton);
                        
                                        resetButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String email = emailField.getText();
                                                String newPassword = new String(newPasswordField.getPassword());
                        
                                                if (!isValid(EMAIL_PATTERN, email)) {
                                                    JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                if (!isValid(PASSWORD_PATTERN, newPassword)) {
                                                    JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                        
                                                String updatePasswordQuery = "UPDATE project SET password = ? WHERE email = ?";
                        
                                                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                                                     PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
                        
                                                    preparedStatement.setString(1, newPassword);
                                                    preparedStatement.setString(2, email);
                        
                                                    int rowUpdated = preparedStatement.executeUpdate();
                                                    if (rowUpdated > 0) {
                                                        JOptionPane.showMessageDialog(resetPasswordFrame, "Password reset successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                        resetPasswordFrame.dispose();
                                                    } else {
                                                        JOptionPane.showMessageDialog(resetPasswordFrame, "Email not found", "Error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                            }
                                        });
                        
                                        resetPasswordFrame.setVisible(true);
                                    }
                                });
                        
                    fee.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String username = JOptionPane.showInputDialog("Enter username:");
                            if (username != null && !username.trim().isEmpty()) {
                                displayFeeFromDatabase(username);
                            } else {
                                JOptionPane.showMessageDialog(null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });  
       
                    transcript.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String username = JOptionPane.showInputDialog("Enter username:");
                            if (username != null && !username.trim().isEmpty()) {
                                displayFeeFromDatabase(username);
                            } else {
                                JOptionPane.showMessageDialog(null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }); 
                                profile.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame profile = new JFrame("UPDATING YOUR DETAILS");
                                        profile.setSize(600, 500);
                                        profile.setLocationRelativeTo(null);
                                        profile.setLayout(null);
                                        profile.setResizable(false);
                                        profile.getContentPane().setBackground(Color.white);
                        
                                        JLabel firstNameLabel = new JLabel("First Name");
                                        JTextField firstNameField = new JTextField();
                                        profile.add(firstNameLabel);
                                        profile.add(firstNameField);
                                        firstNameLabel.setSize(100, 20);
                                        firstNameLabel.setLocation(20, 50);
                                        firstNameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        firstNameField.setSize(140, 20);
                                        firstNameField.setLocation(110, 50);
                        
                                        JLabel secondNameLabel = new JLabel("Second Name");
                                        JTextField secondNameField = new JTextField();
                                        profile.add(secondNameLabel);
                                        profile.add(secondNameField);
                                        secondNameLabel.setSize(100, 20);
                                        secondNameLabel.setLocation(300, 25);
                                        secondNameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        secondNameField.setSize(140, 20);
                                        secondNameField.setLocation(420, 25);
                        
                                        JLabel emailLabel = new JLabel("Email");
                                        JTextField emailField = new JTextField();
                                        profile.add(emailLabel);
                                        profile.add(emailField);
                                        emailLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        emailLabel.setSize(100, 20);
                                        emailLabel.setLocation(20, 110);
                                        emailField.setSize(140, 20);
                                        emailField.setLocation(110, 110);              
                        
                                        JLabel idLabel = new JLabel("ID No");
                                        JTextField idField = new JTextField();
                                        profile.add(idLabel);
                                        profile.add(idField);
                                        idLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        idLabel.setSize(100, 20);
                                        idLabel.setLocation(300, 80);
                                        idField.setSize(140, 20);
                                        idField.setLocation(420, 80);

                                        JLabel courseLabel = new JLabel("Course");
                                        JTextField courseField = new JTextField();
                                        profile.add(courseLabel);
                                        profile.add(courseField);
                                        courseLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        courseLabel.setSize(100, 20);
                                        courseLabel.setLocation(20, 170);
                                        courseField.setSize(140, 20);
                                        courseField.setLocation(130, 170);
                        
                                        JLabel dateLabel = new JLabel("D.O.B");
                                        JTextField dateField = new JTextField();
                                        profile.add(dateLabel);
                                        profile.add(dateField);
                                        dateLabel.setSize(100, 20);
                                        dateLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                                        dateLabel.setLocation(300, 140);
                                        dateField.setSize(140, 20);
                                        dateField.setLocation(420, 140);
                        
                                        JLabel passwordLabel = new JLabel("Verify Password:");
                                        JPasswordField passwordField = new JPasswordField();
                                        profile.add(passwordLabel);
                                        profile.add(passwordField);
                                        passwordLabel.setFont(new Font("Times New Roman",Font.BOLD,13));
                                        passwordLabel.setSize(100, 20);
                                        passwordLabel.setLocation(270, 205);
                                        passwordField.setSize(140, 20);
                                        passwordField.setLocation(420, 205);

                                        JButton update = new JButton("Update");
                                        update.setSize(100, 20);
                                        update.setLocation(230, 250);
                                        profile.add(update);
                        
                                        update.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String newemail = emailField.getText();
                                                String newfirstName = firstNameField.getText();
                                                String newsecondName = secondNameField.getText();
                                                String newdateOfBirth = dateField.getText();
                                                String newuser_id = idField.getText();
                                                String newcourse = courseField.getText();
                                                String password = new String(passwordField.getPassword());
                        
                                                if (!isValid(EMAIL_PATTERN, newemail)) {
                                                    JOptionPane.showMessageDialog(profile, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                if (!isValid(NAME_PATTERN, newfirstName)) {
                                                    JOptionPane.showMessageDialog(profile, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                if (!isValid(NAME_PATTERN, newsecondName)) {
                                                    JOptionPane.showMessageDialog(profile, "Invalid second name", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                                if (!isValid(PASSWORD_PATTERN, password)) {
                                                    JOptionPane.showMessageDialog(profile, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                        
                                                String updatePasswordQuery = "UPDATE project SET firstName = ?, secondName = ?, email = ?, dateOfBirth = ?, user_id = ?, course = ? WHERE password = ?";
                        
                                                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                                                PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
                   
                                                    preparedStatement.setString(1, newfirstName);
                                                    preparedStatement.setString(2, newsecondName);
                                                    preparedStatement.setString(3, newemail);
                                                    preparedStatement.setString(4, newdateOfBirth);
                                                    preparedStatement.setString(5, newuser_id);
                                                    preparedStatement.setString(6, newcourse);
                                                    preparedStatement.setString(7, password);
                                                    int rowUpdated = preparedStatement.executeUpdate();
                        
                                                    if (rowUpdated > 0) {
                                  JOptionPane.showMessageDialog(profile, "Profile Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                  profile.dispose();
                              } else {
                                  JOptionPane.showMessageDialog(profile, "You Entered Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
                              }
                          } catch (SQLException ex) {
                              ex.printStackTrace();
                          }
                      }
                  });
  
                                        profile.setVisible(true);
                                    }
                                });
                                
                                /****************** ***************************** ***************/
                                submission.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFileChooser fileChooser = new JFileChooser();
                                        int result = fileChooser.showSaveDialog(null);
                                        if (result == JFileChooser.APPROVE_OPTION) {
                                            String filePath = fileChooser.getSelectedFile().getAbsolutePath().replace("\\", "\\\\");
                        
                                            String username = usernameField.getText();
                                            String userQuery = "SELECT user_id FROM project WHERE userName = ?";
                                            String insertQuery = "INSERT INTO reports (report_id, image) SELECT ?, load_file(?) FROM DUAL " +
                                                    "WHERE NOT EXISTS (SELECT 1 FROM reports WHERE report_id = ?)";
                        
                                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                                                 PreparedStatement userStatement = connection.prepareStatement(userQuery);
                                                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                        
                                                // Retrieve the user_id based on the username
                                                userStatement.setString(1, username);
                                                ResultSet rs = userStatement.executeQuery();
                        
                                                if (rs.next()) {
                                                    int userId = rs.getInt("user_id");
                        
                                                    // Insert or update the reports table with the file path
                                                    insertStatement.setInt(1, userId);
                                                    insertStatement.setString(2, filePath);
                                                    insertStatement.setInt(3, userId);
                                                    int rowsAffected = insertStatement.executeUpdate();
                        
                                                    if (rowsAffected > 0) {
                                                        JOptionPane.showMessageDialog(null, "Image stored successfully", "Success message", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Image already exists for this user", "Information message", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "User not found", "Error message", JOptionPane.ERROR_MESSAGE);
                                                }
                        
                                                rs.close();
                                            } catch (SQLException e1) {
                                                e1.printStackTrace();
                                                JOptionPane.showMessageDialog(null, "Error storing the image: " + e1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    }
                                });
                           
        course.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                JFrame faculty = new JFrame("Courses Offered");
                faculty.setSize(360, 300);
                faculty.setLayout(null);
                faculty.setLocationRelativeTo(null);
                faculty.setResizable(false);
                faculty.getContentPane().setBackground(Color.lightGray);
                JButton fset = new JButton("Faculty of Science, Egineering & Technology");
                fset.setBounds(20, 45, 300, 20);
                JLabel comment = new JLabel("Select Your Faculty Here!");
                comment.setBounds(20,5,300,20);
                comment.setForeground(Color.GREEN);
                comment.setBackground(Color.WHITE);
                comment.setFont(new Font("Times New Roman", Font.BOLD, 25));
                JButton law = new JButton("Faculty of Law");
                law.setBounds(100, 195, 150, 20);
                JButton nursing = new JButton("Faculty of Nursing & Biomedical");
                nursing.setBounds(47, 95, 250, 20);
                JButton education = new JButton("Faculty of Education");
                education.setBounds(75, 145, 200, 20);
                faculty.add(fset);  
                faculty.add(comment);
                faculty.add(law);
                faculty.add(nursing);
                faculty.add(education);
                faculty.setVisible(true);
            }
        });

               
        notification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try (Connection connecting = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connecting.createStatement();
                   ResultSet result= statement.executeQuery("SELECT notification  FROM notifyadmin")){
                       int columnCount = result.getMetaData().getColumnCount();
                       StringBuilder data = new StringBuilder();
                       for (int i = 1; i<=columnCount; i++){
                           data.append(result.getMetaData().getColumnName(i)).append("\t");
                       }
                       data.append("\n");
                       while (result.next()) {
                           for(int i = 1; i<=columnCount; i++){
                               data.append(result.getString(i)).append("\t");
                           }
                           data.append("\n");
                       }
                       area.setText(data.toString());
                   } catch (Exception j){
                       j.printStackTrace();
                       JOptionPane.showMessageDialog(null, "Error loading data from database:" +j.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                   }
            } 
         });
        
                                exitpage.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        System.exit(0);
                                    }
                                });
                                logout.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JOptionPane.showMessageDialog(login, "Are you sure you want to logout?", "Error", JOptionPane.ERROR_MESSAGE);
                                        //JOptionPane.showConfirmDialog(example, "DO YOU WANT TO CLOSE THE CONVERSATION ? ", "CLOSE CONVERSATION", JOptionPane.YES_NO_OPTION) == 0
                                        login.dispose();
                                        JFrame openPage = new JFrame();
                                        
                                    }
                                });
                        
                                help.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        JFrame suggestion = new JFrame("Help and suggestions");
                                        suggestion.setSize(360, 300);
                                        suggestion.setLayout(null);
                                        suggestion.setLocationRelativeTo(null);
                                        suggestion.setResizable(false);
                                        suggestion.getContentPane().setBackground(Color.LIGHT_GRAY);
                                        JLabel help = new JLabel("Hello, Put down your suggestions Here!"); 
                                        help.setFont(new Font("Times New Roman", Font.BOLD,14));
                                        help.setBounds(40,20,300,40);
                                        JLabel usernameLabel = new JLabel("UserName");
                                        JTextField usernameField = new JTextField();
                                        suggestion.add(usernameLabel);
                                        usernameLabel.setBounds(60,5,100,20);
                                        usernameField.setBounds(130,5,90,20);
                                        suggestion.add(usernameField);
                                        JTextArea text = new JTextArea();
                                        text.setBounds(40,70,200,170);
                                        text.setLineWrap(true);
                                        text.setFont(new Font("Times New Roman",Font.PLAIN, 16));
                                        text.setWrapStyleWord(true);
                                        suggestion.add(text);
                                        JButton submit = new JButton("Submit");
                                        submit.setBounds(250,110,80,25);
                                        suggestion.add(submit);
                                        submit.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

                                                        String username=usernameField.getText();
                                                        String textArea=text.getText();
                                                        String query2="SELECT user_id FROM project WHERE username='"+username+"'";
                                                        Statement statement = connection.createStatement();
                                                        ResultSet resultSet = statement.executeQuery(query2);
                                                        if (resultSet.next()) {
                                                        int userId=resultSet.getInt("user_id");
                                                        String query="INSERT INTO suggestion (report_id,report) VALUES ('"+userId+"','"+textArea+"')";
                                                        PreparedStatement pstatement = connection.prepareStatement(query);
                                                        pstatement.execute();
                                                        
                                                        pstatement.close();
                                                        }
                                                        resultSet.close();
                                                        statement.close();
                                                        connection.close();
                                                        text.setText(null);
                                                        //label6.setText(null);
                                                        JOptionPane.showMessageDialog(null, "REPORT SUBMITTED SUCCESSFULLY", "SUBMISSION", JOptionPane.INFORMATION_MESSAGE);
                                                        text.setEditable(true);
                                                        suggestion.dispose();
                                                        JFrame login = new JFrame(); 
                                                    }
                                                    catch(SQLException e1) {
                                                        JOptionPane.showMessageDialog(null, "AN ERROR HAS OCCURED PLEASE TRY AGAIN", "SUBMIT ERROR", JOptionPane.ERROR_MESSAGE);
                                                    } 

                                                JFrame login = new JFrame();
                                            }
                                    });
                                        JButton refresh = new JButton("Refresh");
                                        refresh.setBounds(250,160,80,25);
                                        suggestion.add(refresh);
                                        refresh.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                text.setText(null);
                                            }
                                        });
                                        suggestion.add(help);
                                        //JFileChooser
                                    suggestion.setVisible(true);
                                    }
                                });
                                login.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(example, "You Entered Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(example, "Username Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton exit = new JButton("Exit");
        example.add(exit);
        exit.setSize(100, 20);
        exit.setLocation(225, 335);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

          // Password Reset Button
          JButton resetPasswordButton = new JButton("Forgot Password?");
          resetPasswordButton.setBounds(195, 280, 150, 25);
          resetPasswordButton.setForeground(Color.BLUE);
          example.add(resetPasswordButton);
  
          resetPasswordButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  JFrame resetPasswordFrame = new JFrame("Reset Password");
                  resetPasswordFrame.setSize(400, 300);
                  resetPasswordFrame.setLocationRelativeTo(null);
                  resetPasswordFrame.setLayout(null);
                  resetPasswordFrame.setResizable(false);
                  resetPasswordFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
  
                  JLabel emailLabel = new JLabel("Email:");
                  JTextField emailField = new JTextField();
                  emailLabel.setBounds(50, 50, 100, 25);
                  emailField.setBounds(150, 50, 150, 25);
                  resetPasswordFrame.add(emailLabel);
                  resetPasswordFrame.add(emailField);
  
                  JLabel newPasswordLabel = new JLabel("New Password:");
                  JPasswordField newPasswordField = new JPasswordField();
                  newPasswordLabel.setBounds(50, 100, 100, 25);
                  newPasswordField.setBounds(150, 100, 150, 25);
                  resetPasswordFrame.add(newPasswordLabel);
                  resetPasswordFrame.add(newPasswordField);
  
                  JButton resetButton = new JButton("Reset Password");
                  resetButton.setBounds(100, 200, 150, 25);
                  resetPasswordFrame.add(resetButton);
  
                  resetButton.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          String email = emailField.getText();
                          String newPassword = new String(newPasswordField.getPassword());
  
                          if (!isValid(EMAIL_PATTERN, email)) {
                              JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                              return;
                          }
                          if (!isValid(PASSWORD_PATTERN, newPassword)) {
                              JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                              return;
                          }
  
                          String updatePasswordQuery = "UPDATE project SET password = ? WHERE email = ?";
  
                          try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                               PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
  
                              preparedStatement.setString(1, newPassword);
                              preparedStatement.setString(2, email);
  
                              int rowUpdated = preparedStatement.executeUpdate();
                              if (rowUpdated > 0) {
                                  JOptionPane.showMessageDialog(resetPasswordFrame, "Password reset successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                                  resetPasswordFrame.dispose();
                              } else {
                                  JOptionPane.showMessageDialog(resetPasswordFrame, "Email not found", "Error", JOptionPane.ERROR_MESSAGE);
                              }
                          } catch (SQLException ex) {
                              ex.printStackTrace();
                          }
                      }
                  });
  
                  resetPasswordFrame.setVisible(true);
              }
          });
  
        example.setVisible(true);
    
    }
});

/*****************************************************************ADMIN***************************************/
admin.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){

        JFrame account = new JFrame("WELCOME DEAR ADMIN");
        account.setLayout(null);
        account.setSize(600, 500);
        account.setLocationRelativeTo(null);
        account.getContentPane().setBackground(Color.red);
        account.setResizable(false);

        JOptionPane.showMessageDialog(admin, "Welcome to user's account!", "User account", JOptionPane.INFORMATION_MESSAGE);
          
        JLabel usernLabel = new JLabel("UserName");
        JTextField userField = new JTextField();
        usernLabel.setBounds(50,40,150,20);
        usernLabel.setFont(new Font("Times New Roman", Font.PLAIN,15));
        userField.setBounds(30,60,120,25);
        account.add(usernLabel);
        account.add(userField);

        JLabel passLabel = new JLabel("Password");
        JPasswordField passField = new JPasswordField();
        passLabel.setBounds(50,130,150,20);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN,15));
        passField.setBounds(30,150,120,25);
        account.add(passLabel);
        account.add(passField);

        
        JTextArea textField = new JTextArea();
        textField.setBounds(200,1,385,455);
        textField.setEditable(false);
        account.add(textField);

        JButton back =new JButton("<====");
        back.setBounds(2, 2,130,20);
        back.setFont(new Font("Arial", Font.ITALIC, 30));
        back.setBackground(Color.GRAY);
        account.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                account.dispose();
                JFrame openPage = new JFrame();
            }
            
        });

        JCheckBox showPassword = new JCheckBox("Show password");
        showPassword.setBounds(30, 180, 120, 25);
        showPassword.setForeground(Color.BLUE);
        showPassword.setBackground(Color.red);
        account.add(showPassword);
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (showPassword.isSelected()){
                passField.setEchoChar((char) 0);
            } else {
                passField.setEchoChar('*');
            }
        }
        });


        JButton login = new JButton("Login");
        login.setBounds(40,240,100,20);
        account.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
         
                String enteredUsername = userField.getText();
                String enteredPassword = new String(passField.getPassword());

                if (!isValid(USERNAME_PATTERN, enteredUsername)) {
                    JOptionPane.showMessageDialog(null, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
              
                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                    String checkUserQuery = "SELECT password FROM myadmin WHERE userName = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(checkUserQuery)) {
                        preparedStatement.setString(1, enteredUsername);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            String storedPassword = resultSet.getString("password");
                            if (storedPassword.equals(enteredPassword)) {
            
     JOptionPane.showMessageDialog(null, "Login successfull! ", "SUBMISSION", JOptionPane.INFORMATION_MESSAGE);

        JFrame admin = new JFrame("Welcome to login page");
        admin.setLayout(null);
        admin.setSize(600, 500);
        admin.setLocationRelativeTo(null);
        admin.getContentPane().setBackground(Color.red);
        admin.setResizable(false);
      
        JTextArea area = new JTextArea();
        area.setBounds(150, 1, 433, 459);
        area.setEditable(false);
        area.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        admin.add(area);

        JButton welfare = new JButton("Welfare");
        welfare.setBounds(20,200,110,30);
        admin.add(welfare);
        welfare.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame student = new JFrame("Student's Welfare");
                student.setSize(358, 339);
                student.setLayout(null);
                student.setLocationRelativeTo(null);
                student.setResizable(false);
                student.getContentPane().setBackground(Color.red);
                
                JTextArea text =new JTextArea();
                text.setEditable(false);
                text.setBounds(130,1,228,297);
                student.add(text);

                JButton suggestion = new JButton("Suggestions");
                suggestion.setBounds(20,20,110,30);
                student.add(suggestion);
                suggestion.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){ 
        
                            try (Connection connecting = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                            Statement statement = connecting.createStatement();
                               ResultSet result= statement.executeQuery("SELECT *  FROM suggestion")){
                                   int columnCount = result.getMetaData().getColumnCount();
                                   StringBuilder data = new StringBuilder();
                                   for (int i = 1; i<=columnCount; i++){
                                       data.append(result.getMetaData().getColumnName(i)).append("\t");
                                   }
                                   data.append("\n");
                                   while (result.next()) {
                                       for(int i = 1; i<=columnCount; i++){
                                           data.append(result.getString(i)).append("\t");
                                       }
                                       data.append("\n");
                                   }
                                   area.setText(data.toString());
                               } catch (Exception j){
                                   j.printStackTrace();
                                   JOptionPane.showMessageDialog(null, "Error loading data from database:" +j.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                               }
                        }
                    });
        
                    JButton assignment = new JButton("Assignment");
                    assignment.setBounds(20, 80, 110, 30);
                    student.add(assignment);
                    assignment.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String username = JOptionPane.showInputDialog("Enter username:");
                            if (username != null && !username.trim().isEmpty()) {
                                displayImageFromDatabase(username);
                            } else {
                                JOptionPane.showMessageDialog(null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });  
                    student.setVisible(true);      
        }
    });
        
    JButton exit = new JButton("Exit");
    exit.setBounds( 20, 380, 110, 30);
    admin.add(exit);
    exit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });
  
            JButton logoutAdmin = new JButton("Logout");
            logoutAdmin.setBounds(20,320,110,30);
            admin.add(logoutAdmin);
            logoutAdmin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showConfirmDialog(login, "Are you sure you want to logout?", "Error", JOptionPane.ERROR_MESSAGE);
                    //JOptionPane.showConfirmDialog(example, "DO YOU WANT TO CLOSE THE CONVERSATION ? ", "CLOSE CONVERSATION", JOptionPane.YES_NO_OPTION) == 0
                    admin.dispose();
                    JFrame openPage = new JFrame();
                    
                }
            });

            JButton fee = new JButton("Fee");
            fee.setBounds(20,260,110,30);
            admin.add(fee);
            fee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath().replace("\\", "\\\\");
    
                        String username = userField.getText();
                        String userQuery = "SELECT id_number FROM myadmin WHERE userName = ?";
                        String insertQuery = "INSERT INTO reports (report_id, image) SELECT ?, load_file(?) FROM DUAL " +
                                "WHERE NOT EXISTS (SELECT 1 FROM reports WHERE report_id = ?)";
    
                        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                             PreparedStatement userStatement = connection.prepareStatement(userQuery);
                             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                            // Retrieve the user_id based on the username
                            userStatement.setString(1, username);
                            ResultSet rs = userStatement.executeQuery();
    
                            if (rs.next()) {
                                int userId = rs.getInt("id_number");
    
                                // Insert or update the reports table with the file path
                                insertStatement.setInt(1, userId);
                                insertStatement.setString(2, filePath);
                                insertStatement.setInt(3, userId);
                                int rowsAffected = insertStatement.executeUpdate();
    
                                if (rowsAffected > 0) {
                                    JOptionPane.showMessageDialog(null, "Image stored successfully", "Success message", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Image already exists for this user", "Information message", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "User not found", "Error message", JOptionPane.ERROR_MESSAGE);
                            }
    
                            rs.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error storing the image: " + e1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

            JButton transcript = new JButton("Transcript");
            transcript.setBounds(20,20,110,30);
            admin.add(transcript);
            transcript.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath().replace("\\", "\\\\");
    
                        String username = userField.getText();
                        String userQuery = "SELECT id_number FROM myadmin WHERE userName = ?";
                        String insertQuery = "INSERT INTO reports (report_id, image) SELECT ?, load_file(?) FROM DUAL " +
                                "WHERE NOT EXISTS (SELECT 1 FROM reports WHERE report_id = ?)";
    
                        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                             PreparedStatement userStatement = connection.prepareStatement(userQuery);
                             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                            // Retrieve the user_id based on the username
                            userStatement.setString(1, username);
                            ResultSet rs = userStatement.executeQuery();
    
                            if (rs.next()) {
                                int userId = rs.getInt("id_number");
    
                                // Insert or update the reports table with the file path
                                insertStatement.setInt(1, userId);
                                insertStatement.setString(2, filePath);
                                insertStatement.setInt(3, userId);
                                int rowsAffected = insertStatement.executeUpdate();
    
                                if (rowsAffected > 0) {
                                    JOptionPane.showMessageDialog(null, "Image stored successfully", "Success message", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Image already exists for this user", "Information message", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "User not found", "Error message", JOptionPane.ERROR_MESSAGE);
                            }
    
                            rs.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error storing the image: " + e1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
    JButton accounts = new JButton("Accounts");
    accounts.setBounds(20,80,110,30);
    admin.add(accounts);
    accounts.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            JFrame newAdmin = new JFrame("New ADMINS");
            newAdmin.setSize(358, 339);
            newAdmin.setLayout(null);
            newAdmin.setLocationRelativeTo(null);
            newAdmin.setResizable(false);
            newAdmin.getContentPane().setBackground(Color.red);
            
            JTextArea text =new JTextArea();
            text.setEditable(false);
            text.setBounds(130,1,228,297);
            newAdmin.add(text);

            JButton update = new JButton("Update");
            update.setBounds(5,40,110,25);
            newAdmin.add(update);
            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame profile = new JFrame("Updating your account");
                    profile.setSize(400, 340);
                    profile.setLocationRelativeTo(null);
                    profile.setLayout(null);
                    profile.setResizable(false);
                    profile.getContentPane().setBackground(Color.white);
        
                    JLabel userNameLabel = new JLabel("UserName");
                    JTextField userNameField = new JTextField();
                    profile.add(userNameLabel);
                    profile.add(userNameField);
                    userNameLabel.setSize(100, 20);
                    userNameLabel.setLocation(120, 25);
                    userNameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    userNameField.setSize(140, 20);
                    userNameField.setLocation(210, 25);
        
                    JLabel emailLabel = new JLabel("Email");
                    JTextField emailField = new JTextField();
                    profile.add(emailLabel);
                    profile.add(emailField);
                    emailLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    emailLabel.setSize(100, 20);
                    emailLabel.setLocation(120, 110);
                    emailField.setSize(140, 20);
                    emailField.setLocation(210, 110);
        
                    JLabel idLabel = new JLabel("ID No");
                    JTextField idField = new JTextField();
                    profile.add(idLabel);
                    profile.add(idField);
                    idLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    idLabel.setSize(100, 20);
                    idLabel.setLocation(120, 80);
                    idField.setSize(140, 20);
                    idField.setLocation(210, 80);
        
                   JTextArea area = new JTextArea();
                   area.setEditable(false);
                   area.setBounds(1,1,110,338);
                   area.setBackground(Color.RED);
                   profile.add(area);

                    JLabel passLabel = new JLabel("Password");
                    JTextField passField = new JTextField();
                    profile.add(passLabel);
                    profile.add(passField);
                    passLabel.setSize(100, 20);
                    passLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    passLabel.setLocation(120, 140);
                    passField.setSize(140, 20);
                    passField.setLocation(210, 140);
        
                    JLabel passwordLabel = new JLabel("Verify Password:");
                    JPasswordField passwordField = new JPasswordField();
                    profile.add(passwordLabel);
                    profile.add(passwordField);
                    passwordLabel.setFont(new Font("Times New Roman",Font.BOLD,13));
                    passwordLabel.setSize(200, 20);
                    passwordLabel.setLocation(120, 205);
                    passwordField.setSize(140, 20);
                    passwordField.setLocation(210, 205);
        
                    JButton update = new JButton("Udate");
                    update.setSize(100, 20);
                    update.setLocation(200, 250);
                    profile.add(update);
        
                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            String newuserName = userNameField.getText();
                            String newpassword = passField.getText();
                            String newuser_id = idField.getText();
                            String newemail = emailField.getText();
                            String password = new String(passwordField.getPassword());
        
                            if (!isValid(EMAIL_PATTERN, newemail)) {
                                JOptionPane.showMessageDialog(profile, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (!isValid(NAME_PATTERN, newuserName)) {
                                JOptionPane.showMessageDialog(profile, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                           
                            if (!isValid(PASSWORD_PATTERN, newpassword)) {
                                JOptionPane.showMessageDialog(profile, "Put a strong password", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
        
                            String updatePasswordQuery = "UPDATE myadmin SET  userName = ?, password = ?, id_number = ?, email = ? WHERE password = ?";
        
                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                            PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
        
                                preparedStatement.setString(1, newuserName);
                                preparedStatement.setString(2, newpassword);
                                preparedStatement.setString(3, newuser_id);
                                preparedStatement.setString(4, newemail);
                                preparedStatement.setString(5, password);
                                int rowUpdated = preparedStatement.executeUpdate();
        
                                if (rowUpdated > 0) {
              JOptionPane.showMessageDialog(profile, "Profile Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
              profile.dispose();
          } else {
              JOptionPane.showMessageDialog(profile, "You Entered Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
          }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        }
        });
        
                    profile.setVisible(true);
                }
            });
            /*******************************CREATE*****************************************************/
            JButton create = new JButton("Create");
            create.setBounds(5,120,110,25);
            newAdmin.add(create);
            create.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame profile = new JFrame("Creating another account");
                    profile.setSize(400, 340);
                    profile.setLocationRelativeTo(null);
                    profile.setLayout(null);
                    profile.setResizable(false);
                    profile.getContentPane().setBackground(Color.white);
        
                    JLabel userNameLabel = new JLabel("UserName");
                    JTextField userNameField = new JTextField();
                    profile.add(userNameLabel);
                    profile.add(userNameField);
                    userNameLabel.setSize(100, 20);
                    userNameLabel.setLocation(120, 25);
                    userNameLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    userNameField.setSize(140, 20);
                    userNameField.setLocation(210, 25);
        
                    JLabel emailLabel = new JLabel("Email");
                    JTextField emailField = new JTextField();
                    profile.add(emailLabel);
                    profile.add(emailField);
                    emailLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    emailLabel.setSize(100, 20);
                    emailLabel.setLocation(120, 110);
                    emailField.setSize(140, 20);
                    emailField.setLocation(210, 110);
        
                    JTextArea area = new JTextArea();
                    area.setEditable(false);
                    area.setBounds(1,1,110,338);
                    area.setBackground(Color.RED);
                    profile.add(area);
 
        
                    JLabel idLabel = new JLabel("ID No");
                    JTextField idField = new JTextField();
                    profile.add(idLabel);
                    profile.add(idField);
                    idLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    idLabel.setSize(100, 20);
                    idLabel.setLocation(120, 80);
                    idField.setSize(140, 20);
                    idField.setLocation(210, 80);
        
                   
                    JLabel passLabel = new JLabel("Password");
                    JTextField passField = new JTextField();
                    profile.add(passLabel);
                    profile.add(passField);
                    passLabel.setSize(100, 20);
                    passLabel.setFont(new Font("Times New Roman",Font.BOLD,16));
                    passLabel.setLocation(120, 140);
                    passField.setSize(140, 20);
                    passField.setLocation(210, 140);
        
                    JLabel passwordLabel = new JLabel("Verify Password:");
                    JPasswordField passwordField = new JPasswordField();
                    profile.add(passwordLabel);
                    profile.add(passwordField);
                    passwordLabel.setFont(new Font("Times New Roman",Font.BOLD,13));
                    passwordLabel.setSize(100, 20);
                    passwordLabel.setLocation(120, 205);
                    passwordField.setSize(140, 20);
                    passwordField.setLocation(210, 205);
        
                    JButton update = new JButton("Create");
                    update.setSize(100, 20);
                    update.setLocation(200, 250);
                    profile.add(update);
        
                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            String newuserName = userNameField.getText();
                            String newpassword = passField.getText();
                            String newuser_id = idField.getText();
                            String newemail = emailField.getText();
                       //     String password = new String(passwordField.getPassword());
        
                            if (!isValid(EMAIL_PATTERN, newemail)) {
                                JOptionPane.showMessageDialog(profile, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (!isValid(NAME_PATTERN, newuserName)) {
                                JOptionPane.showMessageDialog(profile, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                           
                            if (!isValid(PASSWORD_PATTERN, newpassword)) {
                                JOptionPane.showMessageDialog(profile, "Put a strong password", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
        
                            String updatePasswordQuery = "INSERT INTO myadmin  (userName, password, id_number, email) VALUES(?,?,?,?)";
        
                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                            PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
        
                                preparedStatement.setString(1, newuserName);
                                preparedStatement.setString(2, newpassword);
                                preparedStatement.setString(3, newuser_id);
                                preparedStatement.setString(4, newemail);
                              //  preparedStatement.setString(5, password);
                                int rowUpdated = preparedStatement.executeUpdate();
        
                                if (rowUpdated > 0) {
              JOptionPane.showMessageDialog(profile, "Profile Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
              profile.dispose();
          } else {
              JOptionPane.showMessageDialog(profile, "You Entered Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
          }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        }
        });
        
                    profile.setVisible(true);
                }
            });
        


            newAdmin.setVisible(true);
        }
    });

            JButton notification = new JButton("Nofication");
            notification.setBounds(20,140,110,30);
            admin.add(notification);
            notification.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    
                    JFrame note = new JFrame("WELCOME DEAR ADMIN");
                    note.setLayout(null);
                    note.setSize(600, 500);
                    note.setLocationRelativeTo(null);
                    note.getContentPane().setBackground(Color.red);
                    note.setResizable(false);

                    JLabel user = new JLabel("Username");
                    JTextField userField = new JTextField();
                    user.setBounds(200, 434,100,20);
                    userField.setBounds(280,434,100,20);
                    note.add(user);
                    note.add(userField);

                    JTextArea textArea1 = new JTextArea();
                    textArea1.setBounds(150, 1, 433, 429);
                    textArea1.setLineWrap(true);
                    textArea1.setWrapStyleWord(true);
                    textArea1.setFont(new Font("Times New Roman", Font.PLAIN,15));
                    note.add(textArea1);
                    JButton notify = new JButton("Send");
                    notify.setBounds(490,434,100,20);
                    note.add(notify);
                    notify.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

                                String username=userField.getText();
                                String textArea=textArea1.getText();
                                String query2="SELECT id_number FROM myadmin WHERE userName='"+username+"'";
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery(query2);
                                if (resultSet.next()) {
                                int userId=resultSet.getInt("id_number");
                                String query="INSERT INTO notifyadmin (notification_id, notification) VALUES ('"+userId+"','"+textArea+"')";
                                PreparedStatement pstatement = connection.prepareStatement(query);
                                pstatement.execute();
                                
                                pstatement.close();
                                }
                                resultSet.close();
                                statement.close();
                                connection.close();
                                textArea1.setText(null);
                                JOptionPane.showMessageDialog(null, "REPORT SUBMITTED SUCCESSFULLY", "SUBMISSION", JOptionPane.INFORMATION_MESSAGE);
                                textArea1.setEditable(true);
                                note.dispose();
                                JFrame admin = new JFrame(); 
                            }
                            catch(SQLException e1) {
                                JOptionPane.showMessageDialog(null, "AN ERROR HAS OCCURED PLEASE TRY AGAIN", "SUBMIT ERROR", JOptionPane.ERROR_MESSAGE);
                            } 

                        }
                    });

                    note.setVisible(true);
                }
            });

            admin.setVisible(true);
    //    JOptionPane.showConfirmDialog(admin, "Welcome to admin's account", "Admin account", JOptionPane.INFORMATION_MESSAGE);
} else {
    // Wrong password
    JOptionPane.showMessageDialog(null, "You Entered Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
}
} else {
// Username not found
JOptionPane.showMessageDialog(null, "Username Not Registered", "Error", JOptionPane.ERROR_MESSAGE);
}
}
} catch (SQLException ex) {
ex.printStackTrace();
}

    }
});

JButton resetPasswordButton = new JButton("Forgot Password?");
resetPasswordButton.setBounds(20, 370, 150, 25);
resetPasswordButton.setForeground(Color.BLUE);
resetPasswordButton.setBackground(Color.red);
account.add(resetPasswordButton);

resetPasswordButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame resetPasswordFrame = new JFrame("Reset Password");
        resetPasswordFrame.setSize(400, 300);
        resetPasswordFrame.setLocationRelativeTo(null);
        resetPasswordFrame.setLayout(null);
        resetPasswordFrame.setResizable(false);
        resetPasswordFrame.getContentPane().setBackground(Color.gray);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        emailLabel.setBounds(50, 50, 100, 25);
        emailField.setBounds(150, 50, 150, 25);
        resetPasswordFrame.add(emailLabel);
        resetPasswordFrame.add(emailField);

        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField();
        newPasswordLabel.setBounds(50, 100, 100, 25);
        newPasswordField.setBounds(150, 100, 150, 25);
        resetPasswordFrame.add(newPasswordLabel);
        resetPasswordFrame.add(newPasswordField);

        JButton resetButton = new JButton("Reset Password");
        resetButton.setBounds(100, 200, 150, 25);
        resetPasswordFrame.add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String newPassword = new String(newPasswordField.getPassword());

                if (!isValid(EMAIL_PATTERN, email)) {
                    JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!isValid(PASSWORD_PATTERN, newPassword)) {
                    JOptionPane.showMessageDialog(resetPasswordFrame, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String updatePasswordQuery = "UPDATE myadmin SET password = ? WHERE email = ?";

                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                     PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {

                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, email);

                    int rowUpdated = preparedStatement.executeUpdate();
                    if (rowUpdated > 0) {
                        JOptionPane.showMessageDialog(resetPasswordFrame, "Password reset successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        resetPasswordFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(resetPasswordFrame, "Email not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        resetPasswordFrame.setVisible(true);
    }
});


account.setVisible(true);

}
});

openPage.setVisible(true);
        
    }

    private boolean isValid(String pattern, String input) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);
        return matcher.matches();
        
    }
        public static void main(String[] args) {
        ChroneApp n = new ChroneApp() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Not supported yet.
            }
        };
    }
    private static void displayImageFromDatabase(String username) {
        String query = "SELECT r.image FROM project p JOIN reports r ON p.user_id = r.report_id WHERE p.userName = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("image");
                if (blob != null) {
                    byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                    ImageIcon imageIcon = new ImageIcon(imageBytes);

                    JLabel imageLabel = new JLabel(imageIcon);
                    JOptionPane.showMessageDialog(null, imageLabel, "Image", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No image found for this user", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No records found for this username", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving the image: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /****************************************************SCHOOL FEE*********************************************************/
    private static void displayFeeFromDatabase(String username) {
        String query = "SELECT r.image FROM myadmin p JOIN reports r ON p.id_number = r.report_id WHERE p.userName = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("image");
                if (blob != null) {
                    byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                    ImageIcon imageIcon = new ImageIcon(imageBytes);

                    JLabel imageLabel = new JLabel(imageIcon);

                    JOptionPane.showMessageDialog(null, imageLabel, "Image", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No image found for this user", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No records found for this username", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving the image: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

