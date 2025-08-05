import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {
    @Test
    public void testGreet() {
        assertEquals("Hello from DevOps!", Hello.greet());
    }
}
