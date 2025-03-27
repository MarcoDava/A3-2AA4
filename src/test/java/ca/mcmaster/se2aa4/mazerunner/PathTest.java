package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void testAddPath() {
        Path path = new Path();
        path.addPath("F");
        path.addPath("R");
        assertEquals("FR", path.getCanonizedPath());
    }

    @Test
    void testFactorizedPath() {
        Path path = new Path();
        path.addPath("FFF");
        path.addPath("RR");
        assertEquals("3F2R", path.getFactorizedPath());
    }
}
