public class Model {

    private int[][] field;
    private int player;
    private boolean win;
    private int counter;

    public Model(){
        field = new int[3][3];
        player = 1;
        win=false;
        counter = 0;
    }

    public int[][] getField()
    {
        return field;
    }

    public void setField(int row, int col, int Value)
    {
        field[row][col]=Value;
    }

    public int getPlayer()
    {
        return player;
    }

    public void setPlayer (int value)
    {
        this.player=value;
    }

    public boolean getWin()
    {
        return win;
    }

    public void setWin(boolean value)
    {
        win=value;
    }

    public int getCounter(){return  counter;}
    public void setCounter(int value){this.counter=value;}


}
