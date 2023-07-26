import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TicTacToeTest extends TicTacToe {


    @Test
    void testChekWinner() {
        playerPos.add(1);
        playerPos.add(2);
        playerPos.add(3);
        cpuPos.add(5);
        cpuPos.add(9);
        cpuPos.add(6);

        String result = "Player won";

        Assertions.assertEquals(result, chekWinner());
        playerPos.clear();
        cpuPos.clear();

        cpuPos.add(1);
        cpuPos.add(5);
        cpuPos.add(9);
        playerPos.add(6);
        playerPos.add(8);
        playerPos.add(7);

        result = "CPU won";

        Assertions.assertEquals(result, chekWinner());
    }
}