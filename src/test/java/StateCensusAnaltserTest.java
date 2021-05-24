import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateSensusAnalyserTest {
    private static final String INDIA_CENSUS_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    @Test
    public void givenCsvDataCountWhenEqualShouldReturnTrue() {
        try {
            Assertions.assertEquals(29, stateCensusAnalyser.loadCensusData(INDIA_CENSUS_FILE_PATH));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongStateCsvFileShouldReturnException() {
        try {
            stateCensusAnalyser.loadCensusData(WRONG_INDIA_CENSUS_FILE_PATH);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("file dose not exist", e.getMessage());
            e.printStackTrace();
        }
    }
}
