package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private final String name = "벤츠";
    private final Car benz = Car.from(name);
    private static final int notMovedBenzProgress = 0;

    @Test
    void move_4이상_전진() {
        final int moveNumber = 5;
        final Car movedBenz = benz.move(moveNumber);
        final int movedBenzProgress = 1;

        assertAll(
            () -> assertThat(benz.getProgress()).isEqualTo(notMovedBenzProgress),
            () -> assertThat(movedBenz.getProgress()).isEqualTo(movedBenzProgress),
            () -> assertThat(benz).isNotSameAs(movedBenz)
        );
    }

    @Test
    void move_4미만_정지() {
        final int notMoveNumber = 2;
        final Car notMovedBenz = benz.move(notMoveNumber);

        assertAll(
            () -> assertThat(benz.getProgress()).isEqualTo(notMovedBenzProgress),
            () -> assertThat(notMovedBenz.getProgress()).isEqualTo(notMovedBenzProgress),
            () -> assertThat(benz).isNotSameAs(notMovedBenz)
        );
    }

    @Test
    void move_0보다_작은_숫자인_경우_예외_발생() {
        final int negativeNumber = -1;

        assertThatIllegalArgumentException().isThrownBy(() -> benz.move(negativeNumber));
    }

    @Test
    void move_9보다_큰_숫자인_경우_예외_발생() {
        final int overRangeNumber = 10;

        assertThatIllegalArgumentException().isThrownBy(() -> benz.move(overRangeNumber));
    }
}