package ie.tudublin;

import processing.core.PApplet;

public class Life1 extends PApplet {
    int size = 100;
    float cellSize;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];
    boolean isRunning = true;

    public void setCell(boolean arr[][], int row, int col, boolean b) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            arr[row][col] = b;
        }
    }

    public boolean getCell(boolean board[][], int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        } else {
            return false;
        }
    }

    public int countCellsAround(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (!(i == row && j == col)) {
                    if(getCell(board, i, j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;

    }
    public void updateBoard(boolean[][] board){
        for(int row = 0; row<size; row++){
            for(int col = 0; col<size; col++){
                int c = countCellsAround(row, col);
                if(getCell(board, row, col))
                {
                    if(c == 2 || c == 3)
                    {
                        setCell(next, row, col, true);
                    }
                    else
                    {
                        setCell(next, row, col, false);
                    }
                }
                else
                {
                    if(c == 3)
                    {
                        setCell(next, row, col, true);
                    }
                    else
                    {
                        setCell(next, row, col, false);
                    }
                }

            }
        }
        //swap next and board...
        boolean[][] temp = board;
        board = next;
        next = temp;
    }


    public void drawBoard(boolean[][] board) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                if (board[row][col]) {
                    
                    rect(x, y, cellSize, cellSize);
                }

            }
        }
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!

    }

    private void printBoard(boolean[][] board) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }
    }

    public void randomize() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float dice = random(0.0f, 1.0f);

                board[row][col] = (dice < 0.3f) ? true : false;
            }
        }
    }

    public void settings() {
        size(500, 500);
    }

    int mode = 0;

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
        
        switch(mode){
            case 1:
            randomize();
            break;
            case 2:
            for(int row = 0; row<size; row++){
                for(int col = 0; col<size; col++){
                    board[row][col] = false;
                }
            }
            break;
            case 3:
            for(int row = 0; row<size; row++){
                for(int col = 0; col<size; col++){
                    if(row>=(size/2)-3 && row<=(size/2)+3){
                        board[row][col] = true;
                    }else if(col>=(size/2)-3 && col<=(size/2)+3){
                        board[row][col] = true;
                    }else{
                        board[row][col] = false;
                    }
                }
            }
        }

        if(key==' ')
        {
            if(isRunning){
                noLoop();
                isRunning = false;
            }else{
                loop();
                isRunning = true;
            }
        }

    }

    public void setup() {
        colorMode(RGB);
        randomize();
        cellSize = width / (size);

        // printBoard(board);

    }

    public void draw() {
        background(0);
        drawBoard(board);
        updateBoard(board);
    }
}