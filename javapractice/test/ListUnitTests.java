import diiv.javapractice.util.collections.DiivArrayList;
import diiv.javapractice.util.collections.DiivList;
import diiv.javapractice.util.collections.DiivLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ListUnitTests {

    private int _numItems;

    public ListUnitTests(int numItems) {
        _numItems = numItems;
    }

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object> data() {
        Object[] data = new Object[] {1, 2, 3, 10, 15};
        return Arrays.asList(data);
    }


    @Test
    public void testArrayListOps() {
        DiivList<Long> list = new DiivArrayList<Long>();
        testListOps(list);
    }

    @Test
    public void testLinkedListOps() {
        DiivList<Long> list = new DiivLinkedList<Long>();
        testListOps(list);
    }

    private void testListOps(DiivList<Long> list)
    {
        Long[] correctNumbers = new Long[_numItems];
        for (int i = 0; i < _numItems; i++) {
            Long number = Math.round(Math.random()*1000);
            list.insert(number);
            Assert.assertTrue(list.contains(number));
            correctNumbers[i] = number;
        }

        Assert.assertEquals("Is the list of the right size after insert?", _numItems, list.size());

        int i = 0;
        for (Long numInArray : list)
        {
            Assert.assertEquals("Are the values in the list correct and in the right order?", correctNumbers[i], numInArray);
            i++;
        }

        for (int j = 0; j < _numItems; j++) {
            list.remove(correctNumbers[j]);
            Assert.assertFalse(list.contains(correctNumbers[j]));
        }

        Assert.assertEquals("Is the list empty after removing all the items?", 0, list.size());
    }
}
