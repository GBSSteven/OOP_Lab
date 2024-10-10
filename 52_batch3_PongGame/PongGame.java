import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongGame extends Application {

    private static final int width = 800;
    private static final int height = 600;
    private static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_WIDTH = 15;
    private static final double BALL_R = 15;

    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = height / 2;
    private double playerTwoYPos = height / 2;
    private double ballXPos = width / 2;
    private double ballYPos = height / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private boolean gameStarted;
    private int playerOneXPos = 0;
    private double playerTwoXPos = width - PLAYER_WIDTH;

    private boolean wPressed = false;
    private boolean sPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("P O N G");

        // Create the canvas and get the GraphicsContext
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a Timeline to repeatedly call the run() method every 10 milliseconds
        KeyFrame frame = new KeyFrame(Duration.millis(10), event -> run(gc));
        Timeline tl = new Timeline(frame);
        tl.setCycleCount(Timeline.INDEFINITE);

        // Set up the scene and key controls
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));
        scene.setOnKeyReleased(event -> handleKeyRelease(event.getCode()));

        // Start the game when the canvas is clicked
        canvas.setOnMouseClicked(event -> gameStarted = true);

        // Set the scene and start the animation
        stage.setScene(scene);
        stage.show();
        tl.play();
    }

    private void handleKeyPress(KeyCode code) {
        // Handle key presses
        if (code == KeyCode.W) {
            wPressed = true;
        } else if (code == KeyCode.S) {
            sPressed = true;
        } else if (code == KeyCode.UP) {
            upPressed = true;
        } else if (code == KeyCode.DOWN) {
            downPressed = true;
        }
    }

    private void handleKeyRelease(KeyCode code) {
        // Handle key releases
        if (code == KeyCode.W) {
            wPressed = false;
        } else if (code == KeyCode.S) {
            sPressed = false;
        } else if (code == KeyCode.UP) {
            upPressed = false;
        } else if (code == KeyCode.DOWN) {
            downPressed = false;
        }
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        // Set text properties for the score display
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        // Update player positions based on key presses
        updatePlayerPositions();

        if (gameStarted) {
            // Update ball position and check for collisions
            updateBallPosition();

            // Draw the ball
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
        } else {
            // Display the start message
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Click to Start", width / 2, height / 2);

            // Reset the ball position and speed
            resetBall();
        }

        // Draw the scores and players
        drawScoresAndPlayers(gc);
    }

    private void updatePlayerPositions() {
        // Update player positions based on key states
        if (wPressed && playerOneYPos > 0) {
            playerOneYPos -= 5;
        }
        if (sPressed && playerOneYPos < height - PLAYER_HEIGHT) {
            playerOneYPos += 5;
        }
        if (upPressed && playerTwoYPos > 0) {
            playerTwoYPos -= 5;
        }
        if (downPressed && playerTwoYPos < height - PLAYER_HEIGHT) {
            playerTwoYPos += 5;
        }
    }

    private void updateBallPosition() {
        // Move the ball
        ballXPos += ballXSpeed;
        ballYPos += ballYSpeed;

        // Bounce the ball off the top and bottom walls
        if (ballYPos > height || ballYPos < 0) {
            ballYSpeed *= -1;
        }

        // Check for scoring
        checkForScoring();

        // Check for ball collisions with players
        handleBallPlayerCollision();
    }

    private void resetBall() {
        // Reset the ball position and speed
        ballXPos = width / 2;
        ballYPos = height / 2;
        ballXSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
        ballYSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
    }

    private void checkForScoring() {
        // Check if the ball has gone past a player's paddle
        if (ballXPos < playerOneXPos - PLAYER_WIDTH) {
            scoreP2++;
            gameStarted = false;
        }
        if (ballXPos > playerTwoXPos + PLAYER_WIDTH) {
            scoreP1++;
            gameStarted = false;
        }
    }

    private void handleBallPlayerCollision() {
        // Check for ball collisions with the players and reverse ball direction
        if (checkPlayerTwoCollision() || checkPlayerOneCollision()) {
            reverseBallDirection();
        }
    }

    private boolean checkPlayerTwoCollision() {
        return (ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos
                && ballYPos <= playerTwoYPos + PLAYER_HEIGHT;
    }

    private boolean checkPlayerOneCollision() {
        return (ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos
                && ballYPos <= playerOneYPos + PLAYER_HEIGHT;
    }

    private void reverseBallDirection() {
        ballYSpeed += 1 * Math.signum(ballYSpeed);
        ballXSpeed += 1 * Math.signum(ballXSpeed);
        ballXSpeed *= -1;
        ballYSpeed *= -1;
    }

    private void drawScoresAndPlayers(GraphicsContext gc) {
        // Draw the scores
        gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);

        // Draw the players
        gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    // Start the application
    public static void main(String[] args) {
        launch(args);
    }
}
