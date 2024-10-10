
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TugOfWarGame extends JPanel implements KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int PULL_DISTANCE = 10;
    private boolean release = true;

    private int ropePosition; // Position of the center of the rope
    private boolean gameWon; // Track if the game has been won
    private String winner; // Track the winner

    public TugOfWarGame() {
        setupGame();
    }

    private void setupGame() {
        ropePosition = WIDTH / 2; // Starting position of the rope center
        gameWon = false;
        winner = null;

        repaint(); // Refresh the panel to show initial state
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw player labels
        g.setColor(Color.BLACK);
        g.drawString("Player 1 (Press 'F')", WIDTH / 2 - 150, 50);
        g.drawString("Player 2 (Press 'J')", WIDTH / 2 + 50, 50);

        // Draw the left half of the rope (blue)
        g.setColor(Color.BLUE);
        g.fillRect(ropePosition - 100, HEIGHT / 2 - 25, 100, 50); // Player 1 side

        // Draw the right half of the rope (red)
        g.setColor(Color.RED);
        g.fillRect(ropePosition, HEIGHT / 2 - 25, 100, 50); // Player 2 side

        // Draw center line
        g.setColor(Color.BLACK);
        g.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT); // Center line

        // Check if a player has won and display the result
        if (gameWon) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString(winner + " Wins!", WIDTH / 2 - 75, HEIGHT / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press 'R' to Restart or 'Q' to Quit", WIDTH / 2 - 150, HEIGHT /
                    2 + 30);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (gameWon) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                setupGame(); // Restart the game
            } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                System.exit(0); // Quit the game
            }
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_F && release) {
            ropePosition -= PULL_DISTANCE; // Move rope left
            release = false;

        } else if (e.getKeyCode() == KeyEvent.VK_J && release) {
            ropePosition += PULL_DISTANCE; // Move rope right
            release = false;
        }

        // Check for win conditions
        if (ropePosition <= WIDTH / 2 - 100) {
            gameWon = true;
            winner = "Player 1";
        } else if (ropePosition >= WIDTH / 2 + 100) {
            gameWon = true;
            winner = "Player 2";
        }

        repaint(); // Refresh the panel to show changes
    }

    @Override
    public void keyReleased(KeyEvent e) {
        release = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tug of War");
        TugOfWarGame game = new TugOfWarGame();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setFocusable(true);
        frame.setVisible(true);
        game.requestFocusInWindow(); // Request focus for the panel
        game.addKeyListener(game);
    }
}
