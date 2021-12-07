import java.util.Arrays;
import java.util.Scanner;

public class Challenge {

    static Scanner sc = new Scanner(System.in);

    static char playerX = 'X';
    static char playerO = 'O';
    static char currentPlayer = playerO;
    static char defaultChar = '*';

    static int changePosX;
    static int changePosY;
    static char[][] grid = new char[3][3];

    static boolean win = false;

    public static void main(String[] args) {
        createGrid();
        while (!win) {
            getPlayer();
            getInput();
            updateGrid();
            winCondition();
        }

        System.out.println("Player" + currentPlayer + " won!");
    }

    public static void getInput() {
        System.out.println("It is Player" + currentPlayer + "'s turn(X - Y):");
        changePosX = sc.nextInt();
        changePosY = sc.nextInt();
        boolean inBounds = (changePosX >= 0) && (changePosX < grid.length) && (changePosY >= 0) && (changePosY < grid.length);
        if (inBounds) {
            if(grid[changePosX][changePosY] == playerO || grid[changePosX][changePosY] == playerX){
                System.out.println("This cell is already in use. Choose another cell");
                getInput();
            }
        } else {
            System.out.println("Out of bounds, please keep between (0, 2)");
            getInput();
        }
    }

    public static void createGrid() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                grid[x][y] = defaultChar;
            }
        }
    }

    public static void updateGrid() {
        grid[changePosX][changePosY] = currentPlayer;
        printBoard();
    }

    public static void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] gridRow : grid) {
            int i = 0;
            for (char gridCel : gridRow) {
                if (i > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(gridCel);
                i++;
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void getPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else if (currentPlayer == playerO) {
            currentPlayer = playerX;
        } else {
            System.out.println("An error occurred");
        }
    }

    public static void winCondition() {
        if (grid[0][0] == currentPlayer && grid[0][1] == currentPlayer && grid[0][2] == currentPlayer) {
            win = true;
        }
        else if (grid[1][0] == currentPlayer && grid[1][1] == currentPlayer && grid[1][2] == currentPlayer) {
            win = true;
        }
        else if (grid[2][0] == currentPlayer && grid[2][1] == currentPlayer && grid[2][2] == currentPlayer) {
            win = true;
        }
        else if (grid[0][0] == currentPlayer && grid[1][1] == currentPlayer && grid[2][2] == currentPlayer) {
            win = true;
        }
        else if (grid[2][0] == currentPlayer && grid[1][1] == currentPlayer && grid[0][2] == currentPlayer) {
            win = true;
        }
        else if (grid[0][1] == currentPlayer && grid[1][1] == currentPlayer && grid[2][1] == currentPlayer) {
            win = true;
        }
    }
}