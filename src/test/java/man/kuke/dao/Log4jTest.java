package man.kuke.dao;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @author: kuke
 * @date: 2020/11/30 - 12:02
 * @description:
 */
public class Log4jTest {

    static Logger logger = Logger.getLogger(Log4jTest.class);
    @Test
    public void log4jDemo() {
        logger.info("info test");
        logger.debug("debug test");
        logger.error("error test", new Exception("false"));
    }
}
