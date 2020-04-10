package controller;

import java.util.Arrays;

public enum Command {
    ORDER(1),
    PAY(2),
    END(3);

    private int number;

    Command(int number) {
        this.number = number;
    }

    public static Command findByNumber(int number) {
        return Arrays.stream(values())
                .filter(command -> command.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 명령이 없습니다."));
    }

    public boolean isOrder() {
        return this == ORDER;
    }

    public boolean isPay() {
        return this == PAY;
    }

    public boolean isEnd() {
        return this == END;
    }
}
