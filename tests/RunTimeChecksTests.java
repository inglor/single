import org.junit.Test;
import static junit.framework.Assert.assertTrue;

public class RunTimeChecksTests {

    private static final String message = "The object is null";

    @Test (expected = NullPointerException.class)
    public void checkNullThrowingExceptionTest(){
        RunTimeChecks.checkNull(null,message);
    }

    @Test
    public void checkNullPositiveResultTest(){
        RunTimeChecks.checkNull("Any string",message);
    }

    @Test
    public void checkNullExceptionMessage(){
        try{
            RunTimeChecks.checkNull(null,message);
        } catch (Exception ex){
            String exMessage = ex.getMessage();
            /* The following tests will be break if any, even not harmful
             * modification will be perform on RuntimeCheckTests file, this is not
             * ideal, however it is the only truly way to test the error message generated.
             * The alternative is to skip the tests, but this is even more less
             * desirable outcome.
             */
            //Assert that class name is in the error message
            assertTrue(exMessage.contains("RunTimeChecksTests"));
            //Assert that the function name is in the error message
            assertTrue(exMessage.contains("checkNullExceptionMessage"));
            //Assert that the file name is in the error message
            assertTrue(exMessage.contains("RunTimeChecksTests.java"));
            //Assert that the line number is in the error message
            assertTrue(exMessage.contains("21"));
        }
    }
}
