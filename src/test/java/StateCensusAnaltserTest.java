import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateCensusAnalyserTest {
    private static final String INDIA_CENSUS_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_INDIA_CENSUS_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_STATE_CODE_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIA_CENSUS_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.py";
    private static final String INDIA_STATE_CODE_FILE_TYPE = "./src/test/resources/IndiaStateCode.py";
    private static final String INDIA_CENSUS_FILE_CONTENT = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_FILE_CONTENT = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIA_CENSUS_FILE_HEADER = "./src/test/resources/IndiaStateCensusDataHeader.csv";
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    @Test
    public void givenCsvDataCountWhenEqualShouldReturnTrue() {
        try {
            Assertions.assertEquals(29, stateCensusAnalyser.loadCensusData(INDIA_CENSUS_FILE_PATH));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TC-2.1
    @Test
    public void givenCsvDataCountOfStateCodeWhenEqualShouldReturnTrue() {
        try {
            Assertions.assertEquals(37, stateCensusAnalyser.loadStateCodeData(INDIA_STATE_CODE_FILE_PATH));
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

    //TC-2.2
    @Test
    public void givenWrongStateCodeCsvFileShouldReturnException() {
        try {
            stateCensusAnalyser.loadStateCodeData(WRONG_INDIA_STATE_CODE_FILE_PATH);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("file dose not exist", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongStateCsvFileTypeShouldReturnException() {
        try {
            stateCensusAnalyser.loadCensusData(INDIA_CENSUS_FILE_TYPE);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("file type is wrong", e.getMessage());
            e.printStackTrace();
        }
    }
    //TC-.2.3
    @Test
    public void givenWrongStateCodeCsvFileTypeShouldReturnException() {
        try {
            stateCensusAnalyser.loadStateCodeData(INDIA_STATE_CODE_FILE_TYPE);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("file type is wrong", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongStateCsvFileContentShouldReturnException() {
        try {
            stateCensusAnalyser.loadCensusData(INDIA_CENSUS_FILE_CONTENT);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("wrong delimitation", e.getMessage());
            e.printStackTrace();
        }
    }
    //TC-2.4
    @Test
    public void givenWrongStateCodeCsvFileContentShouldReturnException() {
        try {
            stateCensusAnalyser.loadStateCodeData(INDIA_STATE_CODE_FILE_CONTENT);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("wrong delimitation", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongStateCsvFileHeaderShouldReturnException() {
        try {
            stateCensusAnalyser.loadIncorrectCensusData(INDIA_CENSUS_FILE_HEADER);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals("wrong filename", e.getMessage());
            e.printStackTrace();
        }
    }
}
