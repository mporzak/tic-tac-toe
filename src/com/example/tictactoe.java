//TODO:
//  divide into more methods
//  after game is finshed give user option to play again
package com.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class tictactoe {
    public static void main(String[] args) {

        char playerChar;
        char[][] board = new char[3][3];
        int movesCounter = 0;

        //fill the board with -
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        drawBoard(board); //display a board at the beginning of the game

        while (movesCounter < 9) {
            if (movesCounter % 2 == 0) {
                playerChar = 'X';
            } else {
                playerChar = 'O';
            }
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter row number 0, 1 or 2: ");
                int row = scanner.nextInt();
                System.out.println("Enter column number 0, 1 or 2: ");
                int col = scanner.nextInt();
                if (board[row][col] == '-') {
                    board[row][col] = playerChar;
                    drawBoard(board);
                } else if (board[row][col] != '-') {
                    System.out.println("This field is taken, please pick another field");
                    movesCounter--;
                }
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException exception) {
                System.out.println("Incorrect number, please choose a number between 0-2!");
                movesCounter--;
            }
            //check for winning
            if (isWon(board) == 'X') {
                System.out.println("X has won!");
                break;
            } else if (isWon(board) == 'O') {
                System.out.println("O has won!");
                break;
            }
            //if no one won continue playing
            else {
                movesCounter++;
            }
            //check for a draw
            if (movesCounter > 8 && isWon(board) != 'X' && isWon(board) != 'O') {
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    //method for drawing a board
    public static void drawBoard(char board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    //checking rows, columns and diagonals for the same chars
    public static char isWon(char board[][]) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-')
                return board[i][0];
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-')
                return board[0][j];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
                    return board[1][1];
                } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '-') {
                    return board[1][1];
                }
            }
        }
        return ' ';
    }
}
