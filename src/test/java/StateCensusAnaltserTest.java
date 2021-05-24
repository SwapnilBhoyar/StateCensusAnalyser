import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateSensusAnalyserTest {
    private static final String INDIA_CENSUS_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";

    @Test
    public void givenCsvDataCountWhenEqualShouldReturnTrue() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assertions.assertEquals(29,stateCensusAnalyser.loadCensusData(INDIA_CENSUS_FILE_PATH));
    }
}
