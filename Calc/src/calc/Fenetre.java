/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author kingdragon
 */
public class Fenetre extends JFrame{
    
   // private JPanel pan = new JPanel();
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonV = new JButton(".");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonProd = new JButton("*");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonEq = new JButton("=");
    
    private JTextField textfield = new JTextField();
    public Fenetre()
    {
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pan.setLayout(new GridLayout(ERROR, ABORT));
       setLayout(null);
        add(buttonV);
        buttonV.setBounds(90, 230, 60, 31);
        add(textfield);
        textfield.setBounds(120, 30, 220, 29);
        
        add(button7);
        button7.setBounds(20, 100, 60, 31);

      
        getContentPane().add(button8);
        button8.setBounds(90, 100, 60, 31);

      
        getContentPane().add(button5);
        button5.setBounds(90, 150, 60, 31);

      
        getContentPane().add(button6);
        button6.setBounds(160, 150, 60, 31);

      
        getContentPane().add(button1);
        button1.setBounds(20, 190, 60, 31);

        
        getContentPane().add(buttonDiv);
        buttonDiv.setBounds(240, 100, 60, 31);

      
        add(button2);
        button2.setBounds(90, 190, 60, 31);

        
        getContentPane().add(buttonProd);
        buttonProd.setBounds(240, 150, 60, 31);

     
        getContentPane().add(button9);
        button9.setBounds(160, 100, 60, 31);

        
        getContentPane().add(buttonMinus);
        buttonMinus.setBounds(240, 190, 60, 31);

     
        getContentPane().add(button0);
        button0.setBounds(20, 230, 60, 31);

     
        getContentPane().add(button4);
        button4.setBounds(20, 150, 60, 31);

      
        getContentPane().add(buttonEq);
        buttonEq.setBounds(160, 230, 60, 31);

        buttonPlus.setText("+");
        getContentPane().add(buttonPlus);
        buttonPlus.setBounds(240, 230, 60, 31);

        button3.setText("3");
        getContentPane().add(button3);
        button3.setBounds(160, 190, 60, 31);
        
        Controller c = new Controller(this);
        
        
        button0.addActionListener(c);
        button1.addActionListener(c);
        button2.addActionListener(c);
        button3.addActionListener(c);
        button4.addActionListener(c);
        button5.addActionListener(c);
        button6.addActionListener(c);
        button7.addActionListener(c);
        button8.addActionListener(c);
        button9.addActionListener(c);
        buttonPlus.addActionListener(c);
        buttonMinus.addActionListener(c);
        buttonProd.addActionListener(c);
        buttonDiv.addActionListener(c);
        buttonEq.addActionListener(c);
        buttonV.addActionListener(c);
        
        
    }

    public JButton getButton0() {
        return button0;
    }

    public void setButton0(JButton button0) {
        this.button0 = button0;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public void setButton4(JButton button4) {
        this.button4 = button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public void setButton5(JButton button5) {
        this.button5 = button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public void setButton6(JButton button6) {
        this.button6 = button6;
    }

    public JButton getButton7() {
        return button7;
    }

    public void setButton7(JButton button7) {
        this.button7 = button7;
    }

    public JButton getButton8() {
        return button8;
    }

    public void setButton8(JButton button8) {
        this.button8 = button8;
    }

    public JButton getButton9() {
        return button9;
    }

    public void setButton9(JButton button9) {
        this.button9 = button9;
    }

    public JButton getButtonV() {
        return buttonV;
    }

    public void setButtonV(JButton buttonV) {
        this.buttonV = buttonV;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public void setButtonMinus(JButton buttonMinus) {
        this.buttonMinus = buttonMinus;
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public void setButtonPlus(JButton buttonPlus) {
        this.buttonPlus = buttonPlus;
    }

    public JButton getButtonProd() {
        return buttonProd;
    }

    public void setButtonProd(JButton buttonProd) {
        this.buttonProd = buttonProd;
    }

    public JButton getButtonDiv() {
        return buttonDiv;
    }

    public void setButtonDiv(JButton buttonDiv) {
        this.buttonDiv = buttonDiv;
    }

    public JButton getButtonEq() {
        return buttonEq;
    }

    public void setButtonEq(JButton buttonEq) {
        this.buttonEq = buttonEq;
    }

    public JTextField getTextfield() {
        return textfield;
    }

    public void setTextfield(JTextField textfield) {
        this.textfield = textfield;
    }
    
}
