import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {
    MathUtil mu;
    @BeforeEach
    public void setUp(){
         mu = new MathUtil();
    }

    @Test
    public void addShouldAddTwoNumbersCorrectly() {
        // given
        int expected = 3;

        // when
        int actual = mu.add(1, 2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should not add two ints correctly")
    public void addShouldNotAddTwoNumbersCorrectly(){
        assertNotEquals(-1, mu.add(1, 2));

    }

    @Test
    public void addShouldOverflow(){
        //System.out.println(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, mu.add(Integer.MAX_VALUE, 1));
    }

    @Test
    public void addShouldThrowExceptionWithNullAsArgument(){
        assertThrows(IllegalArgumentException.class, () -> mu.add(null, 1));
    }

}