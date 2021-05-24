public class StateCensusAnalyserException extends Exception {

    enum ExceptionType {
        INCORRECT_FILE_PATH, INCORRECT_FILE_TYPE
    }
    ExceptionType type;

    public StateCensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}