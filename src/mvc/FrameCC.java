package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCC extends JFrame implements ActionListener{

    private JPanel centerPanel,buttonPanel;
    private JButton newGame;
    private JButton[] buttonT = new JButton[9];
    private JLabel topLabel;
    private String whoPlays="O";

    public FrameCC(){
        // ustawienia okna
        super("Gra kółko-krzyżyk"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // wyłączanie krzyżykiem
        setVisible(true); // widocznosc
        setLocationRelativeTo(null); // wyswietla sie na srodku ekranu
        setSize(400,300); // wielkosc okna
        setLayout(new FlowLayout()); // glowny layout

        // Panel pomocniczy do wysrodkowania wszystkiego
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        // ktory gracz?

        topLabel = new JLabel("Teraz tura: "+whoPlays,SwingConstants.CENTER);

        // tworze panel z przyciskami
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setPreferredSize(new Dimension(210, 210));

        // tworze przyciski, sluchaczy i dodaje do paneluPrzyciskow
        for(int i=0;i<9;i++){
            buttonT[i]= new JButton(" "+i);
            buttonT[i].addActionListener(this);
            buttonPanel.add(buttonT[i]);
        }

        // przycisk do wlaczania nowej gry
        newGame = new JButton("New Game");
        newGame.addActionListener(this);

        // dodanie wszystkiego do panelu centrujacego
        centerPanel.add(topLabel, BorderLayout.PAGE_START);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(newGame, BorderLayout.PAGE_END);

        // dodanie do glownego panelu
        this.add(centerPanel);

    }

    // zmiana gracza X / O
    private void change(){
        if(whoPlays.equals("O")){
            whoPlays="X";
            topLabel.setText("Teraz tura: "+whoPlays);
        }
        else {
            whoPlays = "O";
            topLabel.setText("Teraz tura: " + whoPlays);
        }
    }

    // reset gry
    private void resetCC(){
        // for each z listy przyciskow
        for(JButton x:buttonT){
            x.setText("");
        }

    }

    private void checkResult(){

        String x = "X",o = "O";

        if(
            // poziom
            x.equals(buttonT[0].getText()) && x.equals(buttonT[1].getText()) && x.equals(buttonT[2].getText()) ||
            x.equals(buttonT[3].getText()) && x.equals(buttonT[4].getText()) && x.equals(buttonT[5].getText()) ||
            x.equals(buttonT[6].getText()) && x.equals(buttonT[7].getText()) && x.equals(buttonT[8].getText()) ||
            // pion
            x.equals(buttonT[0].getText()) && x.equals(buttonT[3].getText()) && x.equals(buttonT[6].getText()) ||
            x.equals(buttonT[1].getText()) && x.equals(buttonT[4].getText()) && x.equals(buttonT[7].getText()) ||
            x.equals(buttonT[2].getText()) && x.equals(buttonT[5].getText()) && x.equals(buttonT[8].getText()) ||
            // ukos
            x.equals(buttonT[0].getText()) && x.equals(buttonT[4].getText()) && x.equals(buttonT[8].getText()) ||
            x.equals(buttonT[2].getText()) && x.equals(buttonT[4].getText()) && x.equals(buttonT[6].getText()))
        {
            JOptionPane.showMessageDialog(null,"Wygrał "+x);
            resetCC();
            change();
        }

        else if(
                // poziom
                o.equals(buttonT[0].getText()) && o.equals(buttonT[1].getText()) && o.equals(buttonT[2].getText()) ||
                o.equals(buttonT[3].getText()) && o.equals(buttonT[4].getText()) && o.equals(buttonT[5].getText()) ||
                o.equals(buttonT[6].getText()) && o.equals(buttonT[7].getText()) && o.equals(buttonT[8].getText()) ||
                // pion
                o.equals(buttonT[0].getText()) && o.equals(buttonT[3].getText()) && o.equals(buttonT[6].getText()) ||
                o.equals(buttonT[1].getText()) && o.equals(buttonT[4].getText()) && o.equals(buttonT[7].getText()) ||
                o.equals(buttonT[2].getText()) && o.equals(buttonT[5].getText()) && o.equals(buttonT[8].getText()) ||
                // ukos
                o.equals(buttonT[0].getText()) && o.equals(buttonT[4].getText()) && o.equals(buttonT[8].getText()) ||
                o.equals(buttonT[2].getText()) && o.equals(buttonT[4].getText()) && o.equals(buttonT[6].getText()))
        {
            JOptionPane.showMessageDialog(null,"Wygrał "+o);
            resetCC();
            change();
        }

    }

    public void actionPerformed(ActionEvent e) { // obsluga zdarzen

        JButton button = (JButton)(e.getSource());
        if (button.equals(newGame)) {
            resetCC();
            change();
        }
        else
            button.setText(whoPlays);
            change();

        checkResult();
    }


}
