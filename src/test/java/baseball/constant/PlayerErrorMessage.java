package baseball.constant;

public enum PlayerErrorMessage {

    NUMBER_RANGE_OUT("[ERROR] 숫자는 1~9 사이만 가능합니다."),
    NOT_NUMBER("[ERROR] 문자는 입력이 불가능 합니다."),
    DIGIT_RANGE_OUT("[ERROR] 3자리만 입력가능 합니다."),
    DUPLICATE_NUMBER("[ERROR] 동일한 숫자는 입력이 불가능 합니다.");

    private String errorMessage;

    PlayerErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

