package org.example.challenge.car.plating;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.challenge.car.plating.Solution.findTheNumberPlate;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void should_start_whit_aaa_when_customer_id_is_under_999() {
        assertThat(findTheNumberPlate(0)).isEqualTo("aaa001");
        assertThat(findTheNumberPlate(3)).isEqualTo("aaa004");
        assertThat(findTheNumberPlate(998)).isEqualTo("aaa999");
    }

    @Test
    public void test() {
        assertThat(findTheNumberPlate(1487)).isEqualTo("baa489");
        assertThat(findTheNumberPlate(40000)).isEqualTo("oba041");
        assertThat(findTheNumberPlate(17558423)).isEqualTo("zzz999");
        assertThat(findTheNumberPlate(234567)).isEqualTo("aja802");
    }

}