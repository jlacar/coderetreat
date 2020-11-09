package first.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MyListTest {

    @Nested
    class When_Writable {
        MyList aList = new MyList();

        @Test
        void it_should_have_initial_capacity_of_10() {
            assertEquals(10, aList.getCapacity());
        }

        @Test
        void it_should_accept_new_elements() {
            aList.add("Something");

            assertEquals(1, aList.getSize());
        }

        @Test
        void it_should_increase_capacity_in_increments_of_10() {
            int expectedCapacity = 20;

            for (int i = 0; i < 5; i++) {
                forceResize();
                assertEquals(expectedCapacity, aList.getCapacity());
                expectedCapacity += 10;
            }
        }

        private void forceResize() {
            int howManyMore = aList.getSize() / 10 * 10 + 11;
            for (int i = aList.getSize(); i < howManyMore; i++) {
                aList.add("foo");
            }
        }
    }

}