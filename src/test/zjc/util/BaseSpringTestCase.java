package zjc.util; /**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2016/1/5-17:17
 */


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/28-10:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:dispatcher-servlet.xml"})
public class BaseSpringTestCase {

}