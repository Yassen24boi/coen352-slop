package Q1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class LCFTest {

    @Test
    void ordinaryPair() {
        assertEquals(7, LCF.lcf(48, 18));
    }

    @Test
    void coprimePair() {
        assertEquals(1, LCF.lcf(8, 15));
    }

    @Test
    void onePair() {
        assertEquals(1, LCF.lcf(100, 1));
    }

    @Test
    void invalidInput() {
        assertThrows(
            IllegalArgumentException.class,
            () -> LCF.lcf(0, 0)
        );
    }
}