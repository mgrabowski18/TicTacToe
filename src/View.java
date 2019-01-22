import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View  extends JFrame implements ActionListener{
    Controller controller;


    private JFrame frame;
    private JLayeredPane mainPanel;
    private JPanel appPanel;
    private JLabel label;
    private JButton[][] fields;
    private JButton newGame;
    private JToolBar toolBar;


    private JOptionPane winner = new JOptionPane();

    private final String path = new File("").getAbsolutePath();
    private final String pathX = path.concat("\\src\\resources\\x.png");
    private final String pathXCross = path.concat("\\src\\resources\\xcross.png");
    private final String pathXCross2 = path.concat("\\src\\resources\\xcross2.png");
    private final String pathXHorizontal = path.concat("\\src\\resources\\xhorizontal.png");
    private final String pathXVertical = path.concat("\\src\\resources\\xvertical.png");
    private final String pathO = path.concat("\\src\\resources\\o.png");
    private final String pathOCross = path.concat("\\src\\resources\\ocross.png");
    private final String pathOCross2 = path.concat("\\src\\resources\\ocross2.png");
    private final String pathOVertical = path.concat("\\src\\resources\\overtical.png");
    private final String pathOHorizontal = path.concat("\\src\\resources\\ohorizontal.png");

        public View()
        {
            controller = new Controller();

            // frame implementation
            frame=new JFrame();
            frame.setPreferredSize(new Dimension(506, 559));
            frame.setLayout(new BorderLayout());
            frame.setResizable(false);

            // main panel implementation
            mainPanel= new JLayeredPane();
            mainPanel.setBackground(new Color(0,0,153));
            mainPanel.setPreferredSize(new Dimension(506, 559));
            frame.add(mainPanel, BorderLayout.CENTER);
            mainPanel.setBounds(0,0,500,600);

            // application panel implementation
            appPanel =new JPanel();
            appPanel.setBounds(0, 30, 500, 500);
            appPanel.setBackground(new Color(0,0,153));
            TitledBorder title;
            title=(BorderFactory.createTitledBorder(
                    null,
                    "Tic Tac Toe",
                    TitledBorder.CENTER,
                    TitledBorder.ABOVE_TOP,
                    new Font("SansSerif Bold", Font.PLAIN, 15),
                    new Color(255,255,255))
            );
            appPanel.setPreferredSize(new Dimension(500,500));
            appPanel.setLayout(null);
            appPanel.setBorder(title);
            appPanel.setOpaque(true);
            mainPanel.add(appPanel, 1, 0);

            // New Game button implementation
            newGame = new JButton("New Game");
            newGame.addActionListener(this);


            // toolbar implementation
            toolBar= new JToolBar();
            toolBar.setFloatable(false);
            toolBar.setRollover(true);
            toolBar.add(this.newGame);
            this.newGame.addActionListener(this);
            toolBar.setAlignmentX(0);
            mainPanel.add(toolBar,BorderLayout.NORTH);
            toolBar.setBounds(0,1, 500, 30);

            // dynamic label implementation
            label = new JLabel();
            appPanel.add(this.label);
            label.setFont(new Font("Sanserif", Font.PLAIN, 15));
            label.setForeground(new Color(255,255,255));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setText("<html>Current Player:<br>Player "+controller.getPlayer()+"</html>");
            this.label.setVisible(true);
            label.setBounds(-30,220, 200, 60);


            // board implementation
            JPanel board = new JPanel(new GridLayout(3, 3));
            appPanel.add(board);
            Dimension size = board.getPreferredSize();
            board.setBounds(150, 100, 300, 300);

            // game fields implementation
            fields = new JButton[3][3];
            board.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    this.fields[row][column] = new JButton();
                    this.fields[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    this.fields[row][column].setPreferredSize(new Dimension(100,100));
                    this.fields[row][column].addActionListener(this);
                    board.add(this.fields[row][column]);
                }
            }

            frame.setTitle("Tic Tac Toe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

        private void setButton(int row, int col, int player)
        {
            if (player==1) {
                this.fields[row][col].setIcon(new ImageIcon(pathX));
                this.fields[row][col].setDisabledIcon(new ImageIcon(pathX));
                this.fields[row][col].setEnabled(false);
            }
            else if (player==2){
                this.fields[row][col].setIcon(new ImageIcon(pathO));
                this.fields[row][col].setDisabledIcon(new ImageIcon(pathO));
                this.fields[row][col].setEnabled(false);
            }
        }
        private void setWinner(int variant, int player)
        {
            ImageIcon temp = new ImageIcon();
            if(variant>=0 && variant<=2){
                if(player==1)
                    temp=new ImageIcon(pathXHorizontal);
                else if(player==2)
                    temp=new ImageIcon(pathOHorizontal);
            }
            else if(variant>=3 && variant<=5){
                if(player==1)
                    temp=new ImageIcon(pathXVertical);
                else if(player==2)
                    temp=new ImageIcon(pathOVertical);
            }
            else if(variant==6){
                if(player==1)
                    temp=new ImageIcon(pathXCross);
                else if(player==2)
                    temp=new ImageIcon(pathOCross);
            }
            else if(variant==7){
                if(player==1)
                    temp=new ImageIcon(pathXCross2);
                else if(player==2)
                    temp=new ImageIcon(pathOCross2);
            }

            switch (variant) {
                case 0:
                    this.fields[0][0].setDisabledIcon(temp);
                    this.fields[0][1].setDisabledIcon(temp);
                    this.fields[0][2].setDisabledIcon(temp);
                    break;
                case 1:
                    this.fields[1][0].setDisabledIcon(temp);
                    this.fields[1][1].setDisabledIcon(temp);
                    this.fields[1][2].setDisabledIcon(temp);
                    break;
                case 2:
                    this.fields[2][0].setDisabledIcon(temp);
                    this.fields[2][1].setDisabledIcon(temp);
                    this.fields[2][2].setDisabledIcon(temp);
                    break;
                case 3:
                    this.fields[0][0].setDisabledIcon(temp);
                    this.fields[1][0].setDisabledIcon(temp);
                    this.fields[2][0].setDisabledIcon(temp);
                    break;
                case 4:
                    this.fields[0][1].setDisabledIcon(temp);
                    this.fields[1][1].setDisabledIcon(temp);
                    this.fields[2][1].setDisabledIcon(temp);
                    break;
                case 5:
                    this.fields[0][2].setDisabledIcon(temp);
                    this.fields[1][2].setDisabledIcon(temp);
                    this.fields[2][2].setDisabledIcon(temp);
                    break;
                case 6:
                    this.fields[0][0].setDisabledIcon(temp);
                    this.fields[1][1].setDisabledIcon(temp);
                    this.fields[2][2].setDisabledIcon(temp);
                    break;
                case 7:
                    this.fields[0][2].setDisabledIcon(temp);
                    this.fields[1][1].setDisabledIcon(temp);
                    this.fields[2][0].setDisabledIcon(temp);
                    break;
                default:
                    break;
            }

            if(variant>=0) {
                winner.showMessageDialog(null, new String("Player " + player + " win!"));

                for(int row=0; row<fields.length; row++)
                    for(int col=0; col<fields[row].length;col++)
                    {
                        this.fields[row][col].setEnabled(false);
                    }
            }
            else if(variant==-2)
                winner.showMessageDialog(null, new String("No one won!"));

        }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (newGame.equals(e.getSource()))
        {
            controller.resetField();
            controller.resetPlayer();
            controller.setWin(false);
            controller.resetCounter();
            label.setText("<html>Current Player:<br>Player "+controller.getPlayer()+"</html>");
            for (int row=0; row<fields.length; row++)
                for (int col=0; col<fields[row].length; col++) {
                    fields[row][col].setIcon(null);
                    fields[row][col].setEnabled(true);
                }
        }

        for (int row=0; row<fields.length; row++)
            for (int col=0; col<fields[row].length; col++) {
                if (fields[row][col].equals(e.getSource())) {
                    controller.incCounter();
                    controller.setField(row, col, controller.getPlayer());
                    setButton(row,col,controller.getPlayer());
                    setWinner(controller.checkStatus(), controller.getPlayer());
                    controller.incPlayer();
                    if(controller.getWin()!=true)
                        label.setText("<html>Current Player:<br>Player "+controller.getPlayer()+"</html>");
                }
            }

    }
}
