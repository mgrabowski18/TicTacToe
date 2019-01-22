import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private int[][] field;
    private int player;
    private boolean win;
    private int counter;
    Model m;


    public Controller() {
        m = new Model();
        field = new int[m.getField().length][m.getField().length];
        player = 0;
        win = false;
        counter = 0;
    }

    public int getPlayer() {
        return this.player = m.getPlayer();
    }

    public void incPlayer() {
        if(m.getPlayer()==2)
            m.setPlayer(1);
        else if (m.getPlayer()==1)
            m.setPlayer(2);
        this.player=m.getPlayer();
    }

    public void resetPlayer(){
        if(m.getPlayer()==2)
            m.setPlayer(1);
        this.player=m.getPlayer();
    }


    public int[][] getField() {
        return this.field = m.getField();
    }

    public void setField(int row, int col, int Value) {
        m.setField(row, col, Value);
        this.field = m.getField();
    }

    public void resetField()
    {
        for(int row=0; row<field.length; row++)
            for(int col=0; col<field[row].length; col++)
            {
                m.setField(row,col,0);
                this.field[row][col]=0;
            }
    }

    public boolean getWin()
    {
        return this.win=m.getWin();
    }

    public void setWin(boolean value)
    {
        m.setWin(value);
        this.win=m.getWin();
    }

    public int getCounter()
    {
        return  this.counter=m.getCounter();
    }

    public void resetCounter()
    {
        m.setCounter(0);
        this.counter=0;
    }

    public void incCounter()
    {
        m.setCounter(m.getCounter()+1);
        this.counter=m.getCounter();

    }

    public int checkStatus() {
        getField();
        getPlayer();
        getCounter();
        int result = -1;


        if ((field[0][0] == player && field[0][1] == player && field[0][2] == player)) {
            result = 0;
            setWin(true);
        } else if ((field[1][0] == player && field[1][1] == player && field[1][2] == player)) {
            result = 1;
            setWin(true);
        } else if ((field[2][0] == player && field[2][1] == player && field[2][2] == player)) {
            result = 2;
            setWin(true);
        } else if ((field[0][0] == player && field[1][0] == player && field[2][0] == player)) {
            result = 3;
            setWin(true);
        } else if ((field[0][1] == player && field[1][1] == player && field[2][1] == player)) {
            result = 4;
            setWin(true);
        } else if ((field[0][2] == player && field[1][2] == player && field[2][2] == player)) {
            result = 5;
            setWin(true);
        } else if ((field[0][0] == player && field[1][1] == player && field[2][2] == player)) {
            result = 6;
            setWin(true);
        } else if ((field[0][2] == player && field[1][1] == player && field[2][0] == player)) {
            result = 7;
            setWin(true);
        } else if(counter>=9){
            result = -2;
        }
        return result;
    }
}

