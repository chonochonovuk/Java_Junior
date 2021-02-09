import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomQueueTest {
    private CustomQueue<String> testQueue;

    @Before
    public void init(){
        testQueue = new CustomQueue<>();
    }

    @Test
    public void testOffer(){
        testQueue.offer("1");
        testQueue.offer("2");
        testQueue.offer("3");
        Assert.assertEquals("1",testQueue.peek());
    }

    @Test
    public void testPoll(){
        testQueue.offer("1");
        testQueue.offer("2");
        testQueue.offer("3");
        Assert.assertEquals("1",testQueue.poll());
        Assert.assertEquals("2",testQueue.poll());
        Assert.assertEquals("3",testQueue.poll());
    }

    @Test
    public void testIterator(){
        testQueue.offer("1");
        testQueue.offer("2");
        testQueue.offer("3");

        int check = 1;
        for (String s:testQueue) {
            Assert.assertEquals(String.valueOf(check++),s);
        }
    }

}
