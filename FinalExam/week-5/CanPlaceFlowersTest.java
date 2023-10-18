import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    @org.junit.jupiter.api.Test
    void canPlaceFlowers_canPlaceOneFlower() {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        boolean result = CanPlaceFlowers.canPlaceFlowers(flowerbed, 1);
        assertEquals(result, true);
    }
}