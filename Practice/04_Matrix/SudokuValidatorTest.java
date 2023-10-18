import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuValidatorTest {
    @Test
    void isListValidReturnsTrue() {
        List<Integer> numbers1 = Arrays.asList(2, 3, 4, 1, 5, 6, 8, 9, 7);
        boolean result = SudokuValidator.isListValid(numbers1);
        assertTrue(result);
    }

    @Test
    void isListValidReturnsFalse() {
        List<Integer> numbers2 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        assertFalse(SudokuValidator.isListValid(numbers2));
    }
}