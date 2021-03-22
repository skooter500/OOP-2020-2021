package ie.tudublin;

import processing.core.PApplet;

public class ColorfulLife extends PApplet {

    int size = 200;
    float cellSize;
    float[][] board = new float[size][size];
    float[][] next = new float[size][size];

    public void clear()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                setCell(board, row, col, -1);
            }
        }
    }

    public int countNeighbours(int row, int col)
    {
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c) > 0)
                    {
                        count ++;
                    }
                }
            }
        }

        // OR Use 8 if statements
        /*
        if (getCell(board, row-1, col-1))
        {
            count ++;
        }
        if (getCell(board, row-1, col))
        {
            count ++;
        }
        if (getCell(board, row-1, col+1))
        {
            count ++;
        }
        if (getCell(board, row, col-1))
        {
            count ++;
        }
        if (getCell(board, row, col+1))
        {
            count ++;
        }
        if (getCell(board, row+1, col-1))
        {
            count ++;
        }
        if (getCell(board, row+1, col))
        {
            count ++;
        }
        if (getCell(board, row+1, col+1))
        {
            count ++;
        }
        */
        
        return count;
    }

    public void setCell(float[][] board, int row, int col, float b)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            board[row][col] = b;
        }
    }

    public float getCell(float[][] board, int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return 0;
        }        
    }

    public void drawBoard(float[][] board)
    {
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                float c = getCell(board, row, col);
                if (c > 0 )
                {
                    noStroke();
                    fill(c, 255, 255);
                    rect(x, y, cellSize, cellSize);
                }
            }
        }

    }

    private void printBoard(boolean[][] board)
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }        
    }

    public void randomize()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = random(0.0f, 1.0f);
                /*
                if (dice < 0.5)
                {
                    board[row][col] = true;
                }
                else
                {
                    board[row][col] = false;
                }
                */
                board[row][col] = (dice < 0.5f) ? random(255) : -1;
            }
        }
    }

    public void settings()
    {
        size(800, 800);
    }
    
    int mode = 0;
    boolean paused = false;
    public void keyPressed() {
        if (keyCode == ' ')
        {
            paused = ! paused;
        }
        
        if (keyCode == '1')
        {
            randomize();
        }
        if (keyCode == '2')
        {
            clear();
        }
        if (keyCode == '3')
        {
            drawCross();
        }            
    }

    public void drawCross()
    {
        for(int i = 0 ; i < size ; i ++)
        {
            setCell(board, size / 2, i, random(255));
            setCell(board, i, size / 2, random(255));
        }
    }

    public float averageAround(float[][] board, int row, int col)
    {
        float xsum = 0;
        float ysum = 0;
        for(int r = row - 1; r <= row + 1 ; r ++)
        {
            for(int c = col - 1 ; c <= col + 1 ; c++)
            {
                float color = getCell(board, r, c);
                if (!(r == row && c == col) && color != -1)
                {
                    
                    float angle = map(color , 0, 255, -PI, PI);
                    xsum += cos(angle);
                    ysum += sin(angle);
                }
            }
        }

        xsum /= 3.0f;
        ysum /= 3.0f;

        return map(atan2(ysum, xsum), -PI, PI, 0, 255);
    }

    public void setup() {
        colorMode(HSB);
        randomize();
        
        /*
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        */
        println(countNeighbours(0, 2));

        cellSize = width / (size);

        frameRate(20);
        
        //printBoard(board);        
    }

    private void updateBoard()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for(int col = 0 ; col < size ; col ++)
            {
                int count = countNeighbours(row, col);
                float c = getCell(board, row, col);
                if (c >= 0)
                {
                    if (count == 2 || count == 3)
                    {
                        setCell(next, row, col, c);
                    }
                    else
                    {
                        setCell(next, row, col, -1);
                    }
                }
                else
                {
                    if (count == 3)
                    {
                        setCell(next, row, col, averageAround(board, row, col));
                    }
                    else
                    {
                        setCell(next, row, col, -1);
                    }
                }
            }
        }

        
        // Swap board and next
        float[][] temp = board;
        board = next;
        next = temp;
    }

    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
        int row = (int) map(mouseY, 0, height, 0, size);
        int col = (int) map(mouseX, 0, width, 0, size);
        setCell(board, row, col, random(255));
    }

    public void draw() {
        background(0);
        drawBoard(board);        
        if (! paused)
        {
            updateBoard();
        }
    }
}
