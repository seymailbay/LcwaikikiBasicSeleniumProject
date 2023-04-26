package testLogger;

import logger.Log;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.Optional;

/**
 TestResultLogger is a class that implements the TestWatcher interface and is used to log the results of JUnit tests.
 */
public class TestResultLogger implements TestWatcher {
    Log log = new Log();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + " PASSED");
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage() ;
        log.error(testName + " FAILED with cause : " + testFailCause);
    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }
}