import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomStackTest {
    private CustomStack<String> stack;

    @Before
    public void init(){
        stack = new CustomStack<>();
    }

    @Test
    public void testPush(){
         this.stack.push("one");
         this.stack.push("two");
         this.stack.push("three");
        Assert.assertEquals("three",this.stack.peek());
        Assert.assertEquals(3,this.stack.getSize());
    }

    @Test
    public void testPop(){
        this.stack.push("one");
        this.stack.push("two");
        this.stack.push("three");
        Assert.assertEquals("three",this.stack.peek());
        Assert.assertEquals(3,this.stack.getSize());
        String removedElement = this.stack.pop();

        Assert.assertEquals("three",removedElement);
        Assert.assertEquals("two",this.stack.peek());
        Assert.assertEquals(2,this.stack.getSize());
    }

    @Test
    public void testIterator() {
        this.stack.push("3");
        this.stack.push("2");
        this.stack.push("1");
        int check = 1;
        for (String s:this.stack) {
            Assert.assertEquals(s,String.valueOf(check++));
        }
    }

}
