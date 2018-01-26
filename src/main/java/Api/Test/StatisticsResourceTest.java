package Api.Test;

import Api.persistence.DatabaseConnector;
import Api.resource.StatisticResource;
import Api.service.StatisticService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StatisticsResourceTest {

    @Test
    public void makeStatistic(){
        DatabaseConnector db = new DatabaseConnector();
        StatisticResource statisticResource = new StatisticResource(new StatisticService());
        assertEquals("TEST TEST",statisticResource.makeStatistic("TEST TEST","TESTPROJECT","TESTSUBPROJECT").getEmployee());
    }
}
