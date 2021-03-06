import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {
    public int loadCensusData(String filePath) throws StateCensusAnalyserException {
        int count = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> CsvStateCensusIterator = csvToBean.iterator();
            Iterable<CSVStateCensus> censusCSVIterable = () -> CsvStateCensusIterator;
            count = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (RuntimeException r) {
            throw new StateCensusAnalyserException("wrong delimitation", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_CONTENT);
        }catch (NoSuchFileException n) {
            throw new StateCensusAnalyserException("file type is wrong", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int loadIncorrectCensusData(String filePath) throws StateCensusAnalyserException {
        int count = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> CsvStateCensusIterator = csvToBean.iterator();
            Iterable<CSVStateCensus> censusCSVIterable = () -> CsvStateCensusIterator;
            count = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (NoSuchFileException n) {
            throw new StateCensusAnalyserException("wrong header", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_HEADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int loadStateCodeData(String filePath) throws StateCensusAnalyserException {
        int count = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader).withType(CSVStateCode.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCode> CsvStateCensusIterator = csvToBean.iterator();
            Iterable<CSVStateCode> censusCSVIterable = () -> CsvStateCensusIterator;
            count = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (RuntimeException r) {
            throw new StateCensusAnalyserException("wrong delimitation", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_CONTENT);
        } catch (NoSuchFileException n) {
            throw new StateCensusAnalyserException("file dose not exist", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int loadStateCodeIncorrectData(String filePath) throws StateCensusAnalyserException {
        int count = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader).withType(CSVStateCode.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCode> CsvStateCensusIterator = csvToBean.iterator();
            Iterable<CSVStateCode> censusCSVIterable = () -> CsvStateCensusIterator;
            count = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (NoSuchFileException n) {
            throw new StateCensusAnalyserException("wrong header", StateCensusAnalyserException.ExceptionType.INCORRECT_FILE_HEADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
