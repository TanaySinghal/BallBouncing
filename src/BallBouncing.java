import java.util.Scanner;

/**
 * Created by tanaysinghal on 4/28/15.
 */
public class BallBouncing {

    public static void main(String args[]) {
        new BallBouncing();
    }

    BallBouncing() {
        //Getting input
        System.out.println("Please enter the amount of columns");
        int sizeX = new Scanner(System.in).nextInt();
        System.out.println("Please enter the amount of rows");
        int sizeY= new Scanner(System.in).nextInt();
        int [][] array = new int[sizeX][sizeY];

        System.out.println("Please enter X starting position from 0 to " + (sizeX - 1) + ":");
        int startingBallX= new Scanner(System.in).nextInt();
        System.out.println("Please enter Y starting position from 0 to " + (sizeY - 1) + ":");
        int startingBallY= new Scanner(System.in).nextInt();

        //Using input
        int ballX = startingBallX;
        int ballY = startingBallY;
        int speedX = 1, speedY = -1;

        array[ballX][ballY] = 1;

        int i = 0;

        while(!(ballX == startingBallX && ballY == startingBallY && i > 1)) {
            array[ballX][ballY] = i+1;

            if((ballY == sizeY-1  && speedY > 0) || (ballY == 0 && speedY < 0)) {
                speedY = -speedY;
            }
            if((ballX == sizeX-1 && speedX > 0) || (ballX == 0 && speedX < 0)) {
                speedX = -speedX;
            }
            ballX += speedX;
            ballY += speedY;

            i++;
        }

        printIt(sizeX, sizeY, array);
        System.out.println("\n\nWe moved " + i + " spaces");
    }

    void printIt(int sizeX, int sizeY, int[][]array) {
        //print
        for(int y = 0; y < sizeY; y ++) {
            System.out.println();
            for(int x = 0; x < sizeX; x ++) {
                if(array[x][y] != 0)
                    System.out.printf("%-5s", array[x][y]);
                else
                    System.out.printf("%-5s", "-");
            }
        }
    }

}
