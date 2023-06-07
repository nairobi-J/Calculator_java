import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Math.sqrt;
import static javax.swing.text.StyleConstants.setBackground;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];
    JButton addButton, subButton, divButton, mulButton;
    JButton decButton, equButton, delButton, clrButton, negButton,perButton,  sqrtButton, squareButton, lala_land;
    JPanel panel; //space
    Font myFont = new Font("Ink free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    String operator;
    Calculator()
    {
        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 730);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);

        textfield = new JTextField();
        textfield.setBounds(55, 25, 400, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false); //cant write anymore
        textfield.setBackground(Color.white);

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("x");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<-");
        clrButton = new JButton("clear");
        negButton = new JButton("(-)");
        sqrtButton = new JButton("root");
        perButton = new JButton("%");
        squareButton = new JButton("SQR");
        lala_land = new JButton("~");


        addButton.setBackground(Color.cyan);
        subButton.setBackground(Color.cyan);
        divButton.setBackground(Color.cyan);
        mulButton.setBackground(Color.cyan
        );
        negButton.setBackground(Color.gray);
        delButton.setBackground(Color.gray);
        clrButton.setBackground(Color.gray);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = perButton;
        functionButtons[10] = sqrtButton;
        functionButtons[11] = squareButton;
        functionButtons[12] = lala_land;
        perButton.setBackground(Color.yellow);
        sqrtButton.setBackground(Color.yellow);
        squareButton.setBackground(Color.yellow);
        lala_land.setBackground(Color.yellow);
        equButton.setBackground(Color.CYAN);
        decButton.setBackground(Color.CYAN);


       // functionButtons[0] = addButton;
        for(int i = 0; i < 13; i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }
        for(int i = 0; i < 10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.pink);

        }
        negButton.setBounds(55,600,120,50);
        delButton.setBounds(190,600,120,50);
        clrButton.setBounds(330,600,120,50);

        panel = new JPanel();

        panel.setBounds(55, 80, 400, 450);
        panel.setLayout(new GridLayout(5, 5, 5, 5));
        panel.setBackground(Color.black);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(mulButton);
        panel.add(perButton);
        panel.add(sqrtButton);
        panel.add(squareButton);
        panel.add(lala_land);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setBackground(Color.black);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

       for(int i = 0; i < 10; i++) {
           if (e.getSource() == numberButtons[i]) {
               textfield.setText(textfield.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource() == decButton)
           textfield.setText(textfield.getText().concat("."));
        if(e.getSource() == addButton)
        {num1 = Double.parseDouble(textfield.getText());
        operator = "+";
        textfield.setText("");}

        if(e.getSource() == subButton)
        {
                num1 = Double.parseDouble(textfield.getText());
                operator = "-";
                textfield.setText("");
        }

        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = "x";
            textfield.setText("");
        }
        if(e.getSource() == perButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = "%";
            textfield.setText("");
        }
        if(e.getSource() == sqrtButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = "root";
            textfield.setText("");
        }
        if(e.getSource() == squareButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = "SQR";
            textfield.setText("");
        }

        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());

            operator = "/";
            textfield.setText("");
        }

        if(e.getSource() == equButton)
        {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator)
            {
                case"+":
                    result = num1 + num2;
                    break;
                case"-":
                    result = num1 - num2;
                    break;
                case"/":
                    result = num1 / num2;
                    break;
                case"x":
                    result = num1*num2;
                    break;


            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == lala_land) {

            switch(operator)
            {
                case"%":
                {
                    result = num1/100;
                    textfield.setText(String.valueOf(result) + "%");
                    break;
                }
                case"root":
                {

                    result = sqrt(num1);
                    textfield.setText(String.valueOf(result));
                    break;
                }
                case"SQR":
                    result = num1*num1;
                    textfield.setText(String.valueOf(result));
                    break;

            }

            num1 = result;

        }

        if(e.getSource() == clrButton) {

            textfield.setText("");
        }
        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i <  string.length() - 1; i++)
                textfield.setText(textfield.getText() + string.charAt(i));
        }
        if(e.getSource() == negButton) {
           double temp = Double.parseDouble(textfield.getText());
           temp *= -1;
           textfield.setText(String.valueOf(temp));
        }

        }

        }


