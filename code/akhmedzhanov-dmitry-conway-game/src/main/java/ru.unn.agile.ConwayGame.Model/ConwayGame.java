package ru.unn.agile.ConwayGame.Model;

public class ConwayGame {
    private int rowsNumber;
    private int columnsNumber;
    private boolean[] lifeGeneration;
    private boolean[] nextGeneration;

    public static final int MIN_NEIGHBORS = 2;
    public static final int MAX_NEIGHBORS = 3;

    public ConwayGame(final int rows, final int columns) {
        if (rows > 0) {
            this.rowsNumber = rows;
        } else {
            this.rowsNumber = rows * (-1);
        }
        if (columns > 0) {
            this.columnsNumber = columns;
        } else {
            this.columnsNumber = columns * (-1);
        }
        this.lifeGeneration = new boolean[rowsNumber * columnsNumber];
        this.nextGeneration = new boolean[rowsNumber * columnsNumber];
    }

    // count the number of neighbors
    private int countNeighbors(final int i) {
        int count = 0;
        int x = i % columnsNumber;
        int y = i / columnsNumber;
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                int nX = x + dx;
                int nY = y + dy;
                if (nX < 0 || nX > columnsNumber - 1) {
                    continue;
                }
                if (nY < 0 || nY > rowsNumber - 1) {
                    continue;
                }
                count += (lifeGeneration[nY * columnsNumber + nX]) ? 1 : 0;
            }
        }
        if (lifeGeneration[y * columnsNumber + x]) {
            count--;
        }
        return count;
    }

    public void moveToNextGeneration() {
        for (int i = 0; i < rowsNumber * columnsNumber; i++) {
            int count = countNeighbors(i);
            nextGeneration[i] = lifeGeneration[i];
            // if are 3 live neighbors around empty cells - the cell becomes alive
            nextGeneration[i] = (count == MAX_NEIGHBORS || nextGeneration[i]);
            // if cell has less than 2 or greater than 3 neighbors - it will die
            nextGeneration[i] = !((count < MIN_NEIGHBORS) || (count > MAX_NEIGHBORS))
                    && nextGeneration[i];
        }
    }

    public int getPlaygroundRowsNumber() {
        return rowsNumber;
    }

    public int getPlaygroundColumnsNumber() {
        return columnsNumber;
    }

    public void readGeneration(final String generation) {
        if (generation.length() != rowsNumber * columnsNumber) {
            return;
        }
        for (int i = 0; i < generation.length(); i++) {
            if (generation.charAt(i) == '*') {
                lifeGeneration[i] = true;
            } else {
                lifeGeneration[i] = false;
            }
        }
    }

    public String getCurrentGeneration() {
        String currentGeneration = "";
        for (int i = 0; i < rowsNumber * columnsNumber; i++) {
            if (lifeGeneration[i]) {
                currentGeneration += '*';
            } else {
                currentGeneration += '.';
            }
            if (i % columnsNumber == columnsNumber - 1) {
                currentGeneration += '\n';
            }
        }
        return currentGeneration;
    }

    public String getNextGeneration() {
        String nextGeneration = "";
        for (int i = 0; i < rowsNumber * columnsNumber; i++) {
            if (this.nextGeneration[i]) {
                nextGeneration += '*';
            } else {
                nextGeneration += '.';
            }
            if (i % columnsNumber == columnsNumber - 1) {
                nextGeneration += '\n';
            }
        }
        return nextGeneration;
    }
}
