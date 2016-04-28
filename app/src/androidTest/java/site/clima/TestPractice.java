package site.clima;

/**
 * Created by lleon on 4/28/16.
 */
import android.test.AndroidTestCase;

public class TestPractice extends AndroidTestCase {

    // Se ejecuta al inicio del test
    @Override
    protected void setUp() throws Exception{
        super.setUp();
    }

    public void testThatDemostratesAssertations() throws Throwable{

        int a = 5;
        int b = 3;
        int c = 5;
        int d = 10;

        //Condiciones que debe pasar

        assertEquals("X should be equal", a, c); // Sino muestra el mensaje
        assertTrue("Y should be true", d > a);
        assertFalse("Z should be false", a==b);

        if(b>d)
            fail("XX should never happen");
    }

    // Se ejecuta al final del test
    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
    }
}
