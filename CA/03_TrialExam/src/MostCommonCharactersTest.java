import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MostCommonCharactersTest {
    @Test
    void getTwoMostCommonCharactersReturnsEandL() throws Exception {
        Map<Character, Integer> result = MostCommonCharacters.getTwoMostCommonCharacters("countchar.txt");
        assertEquals(2, result.size());

        assertTrue(result.containsKey('e'));
        assertEquals(6, result.get('e'));

        assertTrue(result.containsKey('l'));
        assertEquals(4, result.get('l'));
    }
}
