package moe.zaun.prismriver.minor;

import moe.zaun.prismriver.minor.dto.RequestSongDTOTest;
import moe.zaun.prismriver.minor.service.aws.AwsSongTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
        AwsSongTest.class,
        RequestSongDTOTest.class
})
public class AllTests {

}

