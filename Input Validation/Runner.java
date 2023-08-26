
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * A class that validates user input, used as part of an input form
 */
public class ValidateForm
{
    public ValidateForm() {
    }

    boolean isAllAlpha(String str){
        boolean alpha = true;
        for(int i = 0; i < str.length(); i++){

            if(!Character.isLetter(str.charAt(i))){
                alpha = false;
            }
        }
        return alpha;
    }

    boolean isNumeric(String str){
        boolean num = true;

        for(int i = 0; i < str.length(); i++){

            if(!Character.isDigit(str.charAt(i))){

                num = false;
            }
        }
        return num;
    }

    /** validate the user's entered name */
    public String checkName(String name) {

        boolean CheckName = true;
        if(!isAllAlpha(name)) {

            CheckName = false;
        }
        int letCount = 0;
        for(int i = 0; i < name.length(); i++){

            letCount += 1;
        }
        if(letCount < 2){

            CheckName = false;
        }
        if(CheckName){

            return "";
        }
        else{

            return "Input invalid! \n";
        }

    }

    /** validate the user's entered email */
    public String checkEmail(String email) {
        boolean a = false;

        boolean b = false;

        boolean c = false;

        boolean d = false;

        boolean e = false;

        int letCount = -1;

        for(int i = 0; i < email.length(); i++){

            if(email.charAt(i) == '@'){

                b = true;
            }
            if(b && email.charAt(i) == '.'){

                c = true;
            }
            if(c){

                letCount += 1;
            }
        }

        if(email.charAt(0) != '@'){

            d = true;
        }
        if(letCount >= 2){

            e = true;
        }
        if(b && c && d && e ){

            a = true;
        }

        if(a){
            return "";
        }
        else {

            return "Input invalid! \n";

        }
    }

    /** validate the user's enter password */
    public String checkPW(String pw) {
        boolean f = true;

        boolean g = false;

        boolean h = false;

        boolean j = false;

        for(int i = 0; i < pw.length(); i++){

            if(Character.isUpperCase(pw.charAt(i))){
                g = true;
            }

            if(Character.isLowerCase(pw.charAt(i))){

                h = true;
            }
            if(Character.isDigit(pw.charAt(i))){

                j = true;
            }
        }

        int k = 0;
        for(int i = 0; i < pw.length(); i++){

            k += 1;
        }
        if(k < 4){

            f = false;
        }
        if(f == true){

            return "";
        }
        else{

            return "Input invalid! \n";
        }

    }

    /** validate the user's entered zipcode */
    public String checkZip(String zip) {
        if (zip.length() >=3 && zip.length() <=5) {

            return "";
        }
        else{
            return "Input invalid! \n";
        }
    }

    /** validate the user's entered birth year */
    public String checkBirth(String date) {
        int l = 0;

        try{

            l = Integer.parseInt(date);
        }
        catch(NumberFormatException ex) {

            l = 0;
        }
        if(l >= 1925 && l <= Calendar.getInstance().get(Calendar.YEAR) - 10){

            return "";
        }
        else{

            return "Input invalid! \n";
        }
    }

    /** validate the user's entered phone number */
    public String checkPhone(String p) {
        boolean m = false;

        boolean n = false;
        boolean o = false;
        String placeHolder = p.replaceAll("-", "");
        if(placeHolder.length() == 10){

            n = true;
        }
        if(isNumeric(placeHolder)){

            o = true;
        }
        if(n && o){

            m = true;
        }
        if(m){

            return "";
        }
        else{

            return "Input invalid! \n";
        }

    }


    /** main method for testing / setting up the GUI */
    public static void main(String[] args)
    {
        /*
         * you can add other method calls here for testing
         */

        //set up the GUI, you don't need to understand this code
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //the frame is the GUI, it uses a ValidateForm object
                TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
                frame.setVisible(true);
            }
        });
    }
}

/**
 * A frame (GUI) with simple text components to simulate a web form
 */
class TextComponentFrame extends JFrame {
    static final int DEFAULT_WIDTH = 300;
    static final int DEFAULT_HEIGHT = 400;

    ValidateForm validater;

    public TextComponentFrame(ValidateForm v) {
        validater = v;

        initGUI();

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null); //center on screen
    }

    /**
     * initialize the GUI components, e.g. buttons and text fields
     */
    private void initGUI() {
        setTitle("Subscription Form");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField personName = new JTextField();
        final JTextField emailField = new JTextField();
        final JTextField zipCode = new JTextField();
        final JTextField birthDate = new JTextField();

        MaskFormatter q = null;
        try {
            q = new MaskFormatter("###-###-####"); //for the phone number field
        } catch (ParseException e) {
        }

        final JFormattedTextField phoneNumber = new JFormattedTextField(q);
        final JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
        northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
        northPanel.add(personName);
        northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
        northPanel.add(emailField);
        northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
        northPanel.add(zipCode);
        northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
        northPanel.add(birthDate);
        northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
        northPanel.add(phoneNumber);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // add button to listen for events, append text into the text area

        JPanel southPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() //make anonymous action listener
        {
            /** this method is called in response to an event, in this case the "Submit" button pressed */
            public void actionPerformed(ActionEvent event) {
                String name = personName.getText();
                String email = emailField.getText();
                String zip = zipCode.getText();
                String birth = birthDate.getText();
                String phone = phoneNumber.getText();
                String password = new String(passwordField.getPassword());

                String result = "";

                result += validater.checkName(name);
                result += validater.checkPW(password);
                result += validater.checkEmail(email);
                result += validater.checkZip(zip);
                result += validater.checkBirth(birth);
                result += validater.checkPhone(phone);

                if (result.length() == 0)
                    result = "Input accepted!";

                textArea.setText(result);
            }
        });

        add(southPanel, BorderLayout.SOUTH);
    }
}
