package applications;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aniruddha Dutta Chowdhury
 * @googleProfile http://www.google.com/profiles/a.d.chowdhury
 * @blog http://adchowdhury.blogspot.com/
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@ @@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@ @@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@ @ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@ @@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@ @ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@ @@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@ @ @@@@@@@@@ @@ @@@@@@@ @@@@@ @ @@@@@ @@@@@@ @@@@@@@@ @@ @@@@@@@@ @@
 * @@@@@ @@ @@@@@@@@@@ @@@@@@
 * @@@@@@ @@@ @@@@@@@@@ @ @@@@@@ @@@@@ @@@@@ @@@@@@ @@@@@@@ @@@@@@@ @@@@@ @
 * @@@@@@@ @@@@@
 * @@@@@@ @@@ @@@@@@@@@ @@@ @@@@@ @@@@@ @@@@@@@@ @@@@@@ @@@@@@ @@@ @@@@@@ @@@
 * @@@@@ @@@ @@@@@ @@@@ @@@@
 * @@@@@ @@@@@ @@@@@@@@ @@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@@ @@@@@ @@@@@@
 * @@@@@ @@@@@ @@@@@ @@@@@ @@@@@@ @@@@
 * @@@@@ @@@@@ @@@@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@ @@@@@@@ @@@@@
 * @@@@@@@ @@@@@ @@@@@@ @@@@@@@@@@@@@ @@@@
 * @@@@@ @@@@@ @@@@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@ @@@@@@@ @@@@@
 * @@@@@@@ @@@@@ @@@@@@ @@@@@@@@@@ @@@@
 * @@@@ @@@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@ @@@@@@@ @@@@@ @@@@@@@
 * @@@@@ @@@@@@ @@@@@@@ @@@@
 * @@@@ @@@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@ @@@@@@@ @@@@@ @@@@@@@
 * @@@@@ @@@@@@ @@@@@@ @@@ @@@@
 * @@@ @@@@@@@ @@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@@ @@@@@ @@@@@@@ @@@@@
 * @@@@@@@ @@@@@ @@@@@@ @@@@@ @@@@@@ @@@@
 * @@@ @@@@@@@@@ @@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@@@ @@@@@@ @@@@@ @@@@@@
 * @@@@@ @@@@@ @@@@@@ @@@@@ @@@@@@ @@@@
 * @@@ @@@@@@@@@ @@@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@ @@@ @@@@@@ @@@ @@@@@@ @@@
 * @@@@@ @@@@@@ @@@@@ @@@ @@@@
 * @@ @@@@@@@@@@@ @@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@@ @ @@@@@@@ @ @@@@@@@ @
 * @@@@@ @@@@@@ @@@@@@ @@@@
 * @@ @@@@@@@@@@@ @@@@@ @@@@@@ @@@@@ @@@@@ @@@@@@@@@@@ @@ @@@@@@@@ @@ @@@@@@@@
 * @@ @@@@@ @@@@@@ @@@@@@@ @@@ @@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *
 */
public class MineSweeper extends JPanel implements AWTEventListener, ActionListener {

    public static enum State {
        Clicked, Marked, Initial, WrongMarked
    }

    public static enum GameState {
        NotStarted, Playing, Finished
    }

    private static final int MAX_BOMB_COUNT = 10;
    private int ROWS = 9, COLUMNS = 9, TOTAL = ROWS * COLUMNS;
    private JPanel pnlMain = new JPanel(new GridLayout(ROWS, COLUMNS));
    private JLabel lblBombCount = new JLabel(MAX_BOMB_COUNT + "");
    private JLabel lblTimer = new JLabel("0");
    private boolean isColorCheatOn = false;
    private JButton btnReset = new JButton("Reset");

    private void startThread() {
        Thread th = new Thread(new Runnable() {
            public void run() {
                while (state == GameState.Playing) {
                    lblTimer.setText((Long.parseLong(lblTimer.getText()) + 1) + "");
                    lblTimer.updateUI();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.start();
    }

    private GameState state = GameState.NotStarted;

    public MineSweeper() {
        setLayout(new BorderLayout());
        add(pnlMain, BorderLayout.CENTER);
        createButtons();
        addControlPanel();
        Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "<html>Author : Aniruddha Dutta Chowdhury <br>Version : 1.0</html>", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void restartGame() {
        state = GameState.NotStarted;
        lblTimer.setText("0");
        pnlMain.removeAll();
        createButtons();
        pnlMain.updateUI();
        lblBombCount.setText("" + MAX_BOMB_COUNT);
        lblBombCount.updateUI();
    }

    private void addControlPanel() {
        JPanel pnlTimer = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        pnlTimer.add(lblTimer);

        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnReset.setToolTipText("<HTML>Press <B>F2</B> to reset the current game</HTML>");
        pnl.add(lblBombCount);
        pnl.add(btnReset);
        JPanel pnlN = new JPanel(new GridLayout(1, 3));

        pnlN.add(lblBombCount);
        pnlN.add(pnl);
        pnlN.add(pnlTimer);
        add(pnlN, BorderLayout.NORTH);
        btnReset.addActionListener(this);
    }

    private void createButtons() {
        List<Point> lstBombsLocation = new ArrayList<Point>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                JButton btn = getButton(lstBombsLocation, TOTAL, new Point(row, col) {
                    @Override
                    public String toString() {
                        return (int) getX() + ", " + (int) getY();
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return ((Point) obj).getX() == getX() && ((Point) obj).getY() == getY();
                    }
                });
                pnlMain.add(btn);
            }
        }
        while (lstBombsLocation.size() < MAX_BOMB_COUNT) {
            updateBomds(lstBombsLocation, pnlMain.getComponents());
        }
        for (Component c : pnlMain.getComponents()) {
            updateBombCount((GameButton) c, pnlMain.getComponents());
        }
        // System.out.println("Total Bomb Count: " + lstBombsLocation.size());
    }

    private void updateBomds(List<Point> lstBombsLocation, Component[] components) {
        // int currentPosition = new Double(((location.x) * COLUMNS ) +
        // location.getY()).intValue();
        Random r = new Random();
        for (Component c : components) {
            Point location = ((GameButton) c).getPosition();
            int currentPosition = new Double(((location.x) * COLUMNS) + location.getY()).intValue();
            int bombLocation = r.nextInt(TOTAL);
            if (bombLocation == currentPosition) {
                ((GameButton) c).setBomb(true);
                lstBombsLocation.add(((GameButton) c).getPosition());
                return;
            }
        }
    }

    private GameButton getButton(List<Point> lstBombsLocation, int totalLocations, Point location) {
        GameButton btn = new GameButton(location);
        btn.setMargin(new Insets(0, 0, 0, 0));
        btn.setFocusable(false);
        if (lstBombsLocation.size() < MAX_BOMB_COUNT) {
            if (isBomb()) {
                btn.setBomb(true);
                lstBombsLocation.add(location);
            }
        }
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (state != GameState.Playing) {
                    state = GameState.Playing;
                    startThread();
                }
                if (((GameButton) mouseEvent.getSource()).isEnabled() == false) {
                    return;
                }
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    if (((GameButton) mouseEvent.getSource()).getState() == State.Marked) {
                        ((GameButton) mouseEvent.getSource()).setState(State.Initial);
                        lblBombCount.setText((Long.parseLong(lblBombCount.getText()) + 1) + "");
                        ((GameButton) mouseEvent.getSource()).updateUI();
                        return;
                    }
                    ((GameButton) mouseEvent.getSource()).setState(State.Clicked);
                    if (((GameButton) mouseEvent.getSource()).isBomb()) {
                        blastBombs();
                        return;
                    } else {
                        if (((GameButton) mouseEvent.getSource()).getBombCount() == 0) {
                            updateSurroundingZeros(((GameButton) mouseEvent.getSource()).getPosition());
                        }
                    }
                    if (!checkGameState()) {
                        ((GameButton) mouseEvent.getSource()).setEnabled(false);
                    }
                } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    if (((GameButton) mouseEvent.getSource()).getState() == State.Marked) {
                        ((GameButton) mouseEvent.getSource()).setState(State.Initial);
                        lblBombCount.setText((Long.parseLong(lblBombCount.getText()) + 1) + "");
                    } else {
                        ((GameButton) mouseEvent.getSource()).setState(State.Marked);
                        lblBombCount.setText((Long.parseLong(lblBombCount.getText()) - 1) + "");
                    }
                }
                ((GameButton) mouseEvent.getSource()).updateUI();
            }
        });
        return btn;
    }

    private boolean checkGameState() {
        boolean isWin = false;
        for (Component c : pnlMain.getComponents()) {
            GameButton b = (GameButton) c;
            if (b.getState() != State.Clicked) {
                if (b.isBomb()) {
                    isWin = true;
                } else {
                    return false;
                }
            }
        }
        if (isWin) {
            state = GameState.Finished;
            for (Component c : pnlMain.getComponents()) {
                GameButton b = (GameButton) c;
                if (b.isBomb()) {
                    b.setState(State.Marked);
                }
                b.setEnabled(false);

            }
            JOptionPane.showMessageDialog(this, "You win the game :D", "Congrats", JOptionPane.INFORMATION_MESSAGE, null);
        }
        return isWin;
    }

    private void updateSurroundingZeros(Point currentPoint) {
        Point[] points = getSurroundings(currentPoint);

        for (Point p : points) {
            GameButton b = getButtonAt(pnlMain.getComponents(), p);
            if (b != null && b.getBombCount() == 0 && b.getState() != State.Clicked && b.getState() != State.Marked && b.isBomb() == false) {
                b.setState(State.Clicked);
                updateSurroundingZeros(b.getPosition());
                b.updateUI();
            }
            if (b != null && b.getBombCount() > 0 && b.getState() != State.Clicked && b.getState() != State.Marked && b.isBomb() == false) {
                b.setEnabled(false);
                b.setState(State.Clicked);
                b.updateUI();
            }
        }
    }

    private void blastBombs() {
        int blastCount = 0;
        for (Component c : pnlMain.getComponents()) {
            ((GameButton) c).setEnabled(false);
            ((GameButton) c).transferFocus();
            if (((GameButton) c).isBomb() && ((GameButton) c).getState() != State.Marked) {
                ((GameButton) c).setState(State.Clicked);
                ((GameButton) c).updateUI();
                blastCount++;
            }
            if (((GameButton) c).isBomb() == false && ((GameButton) c).getState() == State.Marked) {
                ((GameButton) c).setState(State.WrongMarked);
            }
        }
        lblBombCount.setText("" + blastCount);
        lblBombCount.updateUI();
        state = GameState.Finished;
        JOptionPane.showMessageDialog(this, "You loose the game :(", "Game Over", JOptionPane.ERROR_MESSAGE, null);
        for (Component c : pnlMain.getComponents()) {
            GameButton b = (GameButton) c;
            b.setEnabled(false);
        }
    }

    private boolean isBomb() {
        Random r = new Random();
        return r.nextInt(ROWS) == 1;
    }

    public static JInternalFrame Init() {
        JInternalFrame fr = new JInternalFrame("MineSweeper");

        fr.setLayout(new BorderLayout());
        fr.add(new MineSweeper());
        fr.setResizable(false);
        fr.setSize(250, 350);
        fr.setResizable(true);
        fr.setClosable(true);
        fr.setVisible(true);
        fr.setLocation(new java.awt.Point(500, 150));
        return fr;
    }

    class GameButton extends JButton {

        private boolean isBomb = false;
        private Point position = null;
        private int bombCount = 0;
        private State state = State.Initial;

        public void setState(State state) {
            this.state = state;
            if (getBombCount() == 0 && !isBomb) {
                setEnabled(false);
            }
        }

        public State getState() {
            return state;
        }

        public int getBombCount() {
            return bombCount;
        }

        public void setBombCount(int bombCount) {
            this.bombCount = bombCount;
        }

        public GameButton(Point position) {
            setPosition(position);
            setText(position.toString());
        }

        public Point getPosition() {
            return position;
        }

        public void setPosition(Point position) {
            this.position = position;
        }

        public boolean isBomb() {
            return isBomb;
        }

        public void setBomb(boolean isBomb) {
            this.isBomb = isBomb;
        }

        @Override
        public String getText() {
            if (state == State.Initial) {
                return "";
            }
            if (state == State.Marked) {
                return "\u00B6";
            }
            if (state == State.Clicked) {
                if (isBomb) {
                    return "<html><font size='16'><b>*</b></font></html>";
                } else {
                    if (getBombCount() > 0) {
                        return getBombCount() + "";
                    } else {
                        return "";
                    }
                }
            }
            if (state == State.WrongMarked) {
                return "X";
            }
            return super.getText();
        }

        @Override
        public Color getBackground() {
            if (isColorCheatOn && isBomb) {
                return Color.MAGENTA;
            }
            if (state == State.Clicked) {
                if (isBomb) {
                    return Color.RED;
                }
                if (getBombCount() > 0) {
                    return Color.GREEN;
                }
            }
            if (isEnabled()) {
                return Color.YELLOW.brighter();
            } else {
                return super.getBackground();
            }
        }
    }

    private Point[] getSurroundings(Point cPoint) {
        int cX = (int) cPoint.getX();
        int cY = (int) cPoint.getY();
        Point[] points = {new Point(cX - 1, cY - 1), new Point(cX - 1, cY), new Point(cX - 1, cY + 1), new Point(cX, cY - 1), new Point(cX, cY + 1), new Point(cX + 1, cY - 1), new Point(cX + 1, cY), new Point(cX + 1, cY + 1)};
        return points;
    }

    private void updateBombCount(GameButton btn, Component[] components) {
        Point[] points = getSurroundings(btn.getPosition());

        for (Point p : points) {
            GameButton b = getButtonAt(components, p);
            if (b != null && b.isBomb()) {
                btn.setBombCount(btn.getBombCount() + 1);
            }
        }
        btn.setText(btn.getBombCount() + "");
    }

    private GameButton getButtonAt(Component[] components, Point position) {
        for (Component btn : components) {
            if ((((GameButton) btn).getPosition().equals(position))) {
                return (GameButton) btn;
            }
        }
        return null;
    }

    public void eventDispatched(AWTEvent event) {
        if (KeyEvent.class.isInstance(event) && ((KeyEvent) (event)).getID() == KeyEvent.KEY_RELEASED) {
            if (((KeyEvent) (event)).getKeyCode() == KeyEvent.VK_F1) {
                showAbout();
            }
            if (((KeyEvent) (event)).getKeyCode() == KeyEvent.VK_F2) {
                restartGame();
            }
            if (((KeyEvent) (event)).getKeyCode() == KeyEvent.VK_F3) {
                isColorCheatOn = !isColorCheatOn;
                if (state == GameState.Playing) {
                    pnlMain.updateUI();
                }
            }

            if (((KeyEvent) (event)).getKeyCode() == KeyEvent.VK_F12) {
                for (Component c : pnlMain.getComponents()) {
                    GameButton b = (GameButton) c;
                    if (b.isBomb() == false) {
                        b.setState(State.Clicked);
                    } else {
                        b.setState(State.Marked);
                    }
                    b.setEnabled(false);
                }
                checkGameState();
            }
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnReset) {
            restartGame();
        }
    }
}
