package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ObserverTest {

    @Test
    void testAddObserver() {
        Position position = new Position(new int[]{1, 1});
        Observer mockObserver = new MockObserver();
        position.addObserver(mockObserver);

        position.moveCol(1); // Trigger a change
        assertEquals(1, ((MockObserver) mockObserver).getUpdateCount());
    }

    @Test
    void testNotifyObservers() {
        Position position = new Position(new int[]{1, 1});
        MockObserver observer1 = new MockObserver();
        MockObserver observer2 = new MockObserver();

        position.addObserver(observer1);
        position.addObserver(observer2);

        position.moveRow(1); // Trigger a change
        assertEquals(1, observer1.getUpdateCount());
        assertEquals(1, observer2.getUpdateCount());
    }

    @Test
    void testRemoveObserver() {
        Position position = new Position(new int[]{1, 1});
        MockObserver observer = new MockObserver();

        position.addObserver(observer);
        position.moveCol(1); // Trigger a change
        assertEquals(1, observer.getUpdateCount());

        position.removeObserver(observer);
        position.moveRow(1); // Trigger another change
        assertEquals(1, observer.getUpdateCount()); // Should not increase
    }

    // Mock implementation of Observer for testing
    private static class MockObserver implements Observer {
        private int updateCount = 0;

        @Override
        public void updateValues(Position position) {
            updateCount++;
        }

        public int getUpdateCount() {
            return updateCount;
        }
    }
}
