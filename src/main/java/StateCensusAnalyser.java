import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {
    public int loadCensusData(String filePath) {
        int count = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> CsvStateCensusIterator = csvToBean.iterator();
            Iterable<CSVStateCensus> censusCSVIterable = () -> CsvStateCensusIterator;
            count = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
