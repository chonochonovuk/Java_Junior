import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomArrayListTest {
    private CustomArrayList<String> testArray;

    @Before
    public void initArray(){
        testArray = new CustomArrayList<>();
    }

    @Test
    public void testAddWorkProperly(){
        testArray.add("one");
        testArray.add("two");

        Assert.assertEquals("one",testArray.get(0));
        Assert.assertEquals("two",testArray.get(1));
    }

    @Test
    public void testAddIncreaseCapacityWorksProperly(){
        testArray.add("one");
        testArray.add("two");
        testArray.add("three");
        testArray.add("four");
        testArray.add("five");

        Assert.assertEquals("five",testArray.get(4));

    }

    @Test
    public void testAddAtIndexWorkProperly(){
        testArray.add("one");
        testArray.add("two");
        testArray.add("three");
        testArray.add("four");
        testArray.add("five");

        testArray.add(1,"2");

        Assert.assertEquals("one",testArray.get(0));
        Assert.assertEquals("2",testArray.get(1));
        Assert.assertEquals("two",testArray.get(2));

    }

    @Test
    public void testSize(){
        testArray.add("one");
        testArray.add("two");
        testArray.add("three");
        testArray.add("four");
        testArray.add("five");

        Assert.assertEquals(5, testArray.size());
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(testArray.isEmpty());
    }

    @Test
    public void testContains(){
        testArray.add("one");
        testArray.add("two");
        testArray.add("three");

        Assert.assertTrue(this.testArray.contains("two"));
        Assert.assertFalse(this.testArray.contains("six"));
    }

    @Test
    public void testIterator(){
        testArray.add("0");
        testArray.add("1");
        testArray.add("2");
        testArray.add("3");
        testArray.add("4");
        int value = 0;
        for (Object element: this.testArray ) {
            Assert.assertEquals(element,String.valueOf(value++));
        }
    }

    @Test
    public void testIndexOf(){
        testArray.add("0");
        testArray.add("1");
        testArray.add("2");
        testArray.add("3");
        testArray.add("4");

        Assert.assertEquals(2,this.testArray.indexOf("2"));
    }
}
