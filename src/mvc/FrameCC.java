package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCC extends JFrame implements ActionListener{

    private JPanel centerPanel,buttonPanel;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9,newGame;
    private JLabel whoPlay;
    private String whoPlays="O";

    public FrameCC(){
        super("Gra kółko-krzyżyk"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wyłączanie krzyżykiem
        setVisible(true); // widocznosc
        setLocationRelativeTo(null); // wyswietla sie na srodku ekranu
        setSize(400,300); // wielkosc okna
        setLayout(new FlowLayout());

        // Panel pomocniczy do wysrodkowania wszystkiego
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        // ktory gracz?
        whoPlay = new JLabel("Teraz tura: "+whoPlays,SwingConstants.CENTER);

        // tworze panel z przyciskami
        buttonPanel = new JPanel();

        // tworze przyciski
        b1 = new JButton("");
        b2 = new JButton("");
        b3 = new JButton("");
        b4 = new JButton("");
        b5 = new JButton("");
        b6 = new JButton("");
        b7 = new JButton("");
        b8 = new JButton("");
        b9 = new JButton("");

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setPreferredSize(new Dimension(210, 210));

        // dodaje sluchaczy
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        // dodaje do panelu
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);

        // przycisk do wlaczania nowej gry
        newGame = new JButton("New Game");
        newGame.addActionListener(this);

        // dodanie wszystkiego do panelu centrujacego
        centerPanel.add(whoPlay, BorderLayout.PAGE_START);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(newGame, BorderLayout.PAGE_END);

        // dodanie do glownego panelu
        this.add(centerPanel);

        //pack();



    }

    private void change(){
        if(whoPlays.equals("O")){
            whoPlays="X";
            whoPlay.setText("Teraz tura: "+whoPlays);
        }
        else if(whoPlays.equals("X")){
            whoPlays="O";
            whoPlay.setText("Teraz tura: "+whoPlays);
        }
    }


    private void resetCC(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

    private void checkResult(){
        // poziom X
        if( ((b1.getText().equals("X")&&b2.getText().equals("X"))&&b3.getText().equals("X"))    ||
                ((b4.getText().equals("X")&&b5.getText().equals("X"))&&b6.getText().equals("X")) ||
                ((b7.getText().equals("X")&&b8.getText().equals("X"))&&b9.getText().equals("X"))) {
            JOptionPane.showMessageDialog(null,"Wygrał X");
            resetCC();
            change();
        }
        // poziom O
        else if( ((b1.getText().equals("O")&&b2.getText().equals("O"))&&b3.getText().equals("O"))    ||
                ((b4.getText().equals("O")&&b5.getText().equals("O"))&&b6.getText().equals("O")) ||
                ((b7.getText().equals("O")&&b8.getText().equals("O"))&&b9.getText().equals("O"))) {
            JOptionPane.showMessageDialog(null,"Wygrał O");
            resetCC();
            change();
        }
        // pion X
        else if( ((b1.getText().equals("X")&&b4.getText().equals("X"))&&b7.getText().equals("X"))    ||
                ((b2.getText().equals("X")&&b5.getText().equals("X"))&&b8.getText().equals("X")) ||
                ((b3.getText().equals("X")&&b6.getText().equals("X"))&&b9.getText().equals("X"))) {
            JOptionPane.showMessageDialog(null,"Wygrał X");
            resetCC();
            change();
        }
        // pion O
        else if( ((b1.getText().equals("O")&&b4.getText().equals("O"))&&b7.getText().equals("O"))    ||
                ((b2.getText().equals("O")&&b5.getText().equals("O"))&&b8.getText().equals("O")) ||
                ((b3.getText().equals("O")&&b6.getText().equals("O"))&&b9.getText().equals("O"))) {
            JOptionPane.showMessageDialog(null,"Wygrał O");
            resetCC();
            change();
        }
        // ukos X
        else if( ((b1.getText().equals("X")&&b5.getText().equals("X"))&&b9.getText().equals("X"))    ||
                ((b3.getText().equals("X")&&b5.getText().equals("X"))&&b7.getText().equals("X")) ) {
            JOptionPane.showMessageDialog(null,"Wygrał X");
            resetCC();
            change();
        }
        // ukos O
        else if( ((b1.getText().equals("O")&&b5.getText().equals("O"))&&b9.getText().equals("O"))    ||
                ((b3.getText().equals("O")&&b5.getText().equals("O"))&&b7.getText().equals("O")) ) {
            JOptionPane.showMessageDialog(null,"Wygrał O");
            resetCC();
            change();
        }



    }

    public void actionPerformed(ActionEvent e) { // obsluga zdarzen
        Object source = e.getSource();

        if(e.getSource()==b1){
            b1.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b2){
            b2.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b3){
            b3.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b4){
            b4.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b5){
            b5.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b6){
            b6.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b7){
            b7.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b8){
            b8.setText(whoPlays);
            change();
        }
        else if(e.getSource()==b9){
            b9.setText(whoPlays);
            change();
        }
        else if(e.getSource()==newGame){
           resetCC();
           change();
        }

        checkResult();
    }


}
