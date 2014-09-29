package com.company;

public class Main {

    public static void main(String[] args) {
        boolean [][] world = new boolean[100][100];
        Display d = new Display();

        world[15][34] = true;
        world[15][35] = true;
        world[15][36] = true;
        world[15][36] = true;
        world[13][35] = true;

        d.setMask(world);
        while (true) {
            boolean[][] world1 = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    int neighbors = 0;
                    if (i != 0 && j != 0 && world[i - 1][j - 1]) neighbors++;
                    if (i != 0 && world[i - 1][j]) neighbors++;
                    if (i != 0 && j != 99 && world[i - 1][j + 1]) neighbors++;

                    if (i != 99 && j!= 0 && world[i + 1][j - 1]) neighbors++;
                    if (i != 99 && world[i + 1][j]) neighbors++;
                    if (i != 99 && j != 99 && world[i + 1][j + 1]) neighbors++;

                    if (j != 0 && world[i][j - 1]) neighbors++;
                    if (j != 99 && world[i][j + 1]) neighbors++;
                    if (!world[i][j] && neighbors == 3) world1[i][j] = true;
                    if (world[i][j] && (neighbors == 2 || neighbors == 3)) world1[i][j] = world[i][j];
                    if (world[i][j] && !(neighbors == 2 || neighbors == 3)) world1[i][j] = false;

                }
            }
            d.setMask(world1);
            world = world1;
        }
    }
}