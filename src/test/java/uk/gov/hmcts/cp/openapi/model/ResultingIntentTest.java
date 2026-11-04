package uk.gov.hmcts.cp.openapi.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultingIntentTest {

    @Test
    void enum_contains_grant_adjourn_and_withdraw() {
        assertThat(ResultingIntent.values()).containsExactly(ResultingIntent.GRANT, ResultingIntent.ADJOURN, ResultingIntent.WITHDRAW);
    }

    @Test
    void from_value_grant() {
        assertThat(ResultingIntent.fromValue("GRANT")).isEqualTo(ResultingIntent.GRANT);
    }

    @Test
    void from_value_adjourn() {
        assertThat(ResultingIntent.fromValue("ADJOURN")).isEqualTo(ResultingIntent.ADJOURN);
    }

    @Test
    void from_value_withdraw() {
        assertThat(ResultingIntent.fromValue("WITHDRAW")).isEqualTo(ResultingIntent.WITHDRAW);
    }

    @ParameterizedTest
    @ValueSource(strings = {"grant", "adjourn", "Withdraw", "", "UNKNOWN"})
    void from_unknown_value_throws_illegal_argument_exception(String value) {
        assertThatThrownBy(() -> ResultingIntent.fromValue(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(value);
    }

    @Test
    void get_value_returns_string() {
        assertThat(ResultingIntent.GRANT.getValue()).isEqualTo("GRANT");
        assertThat(ResultingIntent.ADJOURN.getValue()).isEqualTo("ADJOURN");
        assertThat(ResultingIntent.WITHDRAW.getValue()).isEqualTo("WITHDRAW");
    }
}
