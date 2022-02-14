package com.lspoke.determinant;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
Написать программу, которая бы просила пользователя
ввести с консоли матрицу размером 3 * 3 (сохраняла в двумерный массив),
считала и печатала ее определитель на экран.
 */

/*
1)
{1, -2, 3},
{4, 0, 6},
{-7, 8, 9}
answer = 204;
2)
{7, -3, 5},
{1, 4, -1},
{3, -4, -2}
answer = -161;
3)
{5, 3, 1},
{2, 4, 6},
{-1, -2, -3}
answer = 0;
*/
public class Determinant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMatrix = 3;

        int[][] matrix = new int[countMatrix][countMatrix];

        System.out.println("Enter the matrix(3 x 3) :");
        for (int i = 0; i < countMatrix; i++){
            for (int j = 0; j < countMatrix; j++){
                try {
                    matrix[i][j] = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Input Mismatch!");
                    break;
                }
            }
        }

        int determinant = 0;
        int multiplier = 1;

        for (int count = 0; count < countMatrix; count++){
            int i = 0;
            int j = count;
            for(int k = 0; k < countMatrix; k++){
                if(j > 2){
                    j = 0;
                }
                multiplier *= matrix[i][j];
                i++;
                j++;
            }
            determinant += multiplier;
            multiplier = 1;
        }

        for (int count = 0; count < countMatrix; count++){
            int i = 0;
            int j = count;
            for(int k = 0; k < countMatrix; k++){
                if(j < 0){
                    j = 2;
                }
                multiplier *= matrix[i][j];
                i++;
                j--;
            }
            determinant -= multiplier;
            multiplier = 1;
        }

        System.out.println("Determinant = " + determinant);
    }
}
