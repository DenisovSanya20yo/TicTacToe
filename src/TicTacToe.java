import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPos = new ArrayList<Integer>();


    public static void main (String[] args)
    {
        char[][] gBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGBoard(gBoard);

        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number placement (1-9):");
            int pos = sc.nextInt();
            while (playerPos.contains(pos) || cpuPos.contains(pos))
            {
                System.out.println("Incorrect position, try again:");
                pos = sc.nextInt();
            }

            PlacePiece(pos, gBoard, "player");

            String result = chekWinner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }
            Random rand = new Random();
            int cPos = rand.nextInt(9) + 1;
            while (playerPos.contains(cPos) || cpuPos.contains(cPos))
            {
                cPos = rand.nextInt(9) + 1;
            }

            PlacePiece(cPos, gBoard, "cpu");
            printGBoard(gBoard);
            result = chekWinner();
            if(result.length() > 0)
            {
                System.out.println(result);
                break;
            }
        }
        printGBoard(gBoard);
    }
    public static void printGBoard(char[][] gBoard)
    {
        for(char[] row : gBoard)
        {
            for(char c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void PlacePiece(int pos, char[][] gBoard, String user)
    {
        char symbol = ' ';

        if (user.equals("player"))
        {
            symbol = 'X';
            playerPos.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPos.add(pos);
        }

        switch (pos)
        {
            case 1:
                gBoard[0][0] = symbol;
                break;
            case 2:
                gBoard[0][2] = symbol;
                break;
            case 3:
                gBoard[0][4] = symbol;
                break;
            case 4:
                gBoard[2][0] = symbol;
                break;
            case 5:
                gBoard[2][2] = symbol;
                break;
            case 6:
                gBoard[2][4] = symbol;
                break;
            case 7:
                gBoard[4][0] = symbol;
                break;
            case 8:
                gBoard[4][2] = symbol;
                break;
            case 9:
                gBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String chekWinner()
    {
        List topR = Arrays.asList(1, 2, 3);
        List midR = Arrays.asList(4, 5, 6);
        List botR = Arrays.asList(7, 8, 9);

        List leftC = Arrays.asList(1, 4, 7);
        List midC = Arrays.asList(2, 5, 8);
        List rightC = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winState = new ArrayList<List>();
        winState.add(topR);
        winState.add(midR);
        winState.add(botR);
        winState.add(leftC);
        winState.add(midC);
        winState.add(rightC);
        winState.add(cross1);
        winState.add(cross2);

        for (List l : winState)
        {
            if (playerPos.containsAll(l))
            {
                return "Player won";
            }
            else if (cpuPos.containsAll(l))
            {
                return "CPU won";
            }
            else if (playerPos.size() + cpuPos.size() == 9)
            {
                return "FuckUP";
            }
        }

        return "";
    }
}
