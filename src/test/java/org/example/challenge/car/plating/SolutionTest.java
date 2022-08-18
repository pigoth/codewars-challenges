package org.example.challenge.car.plating;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.challenge.car.plating.Solution.findTheNumberPlate;

class SolutionTest {

    @Test
    void should_start_whit_aaa_when_customer_id_is_under_999() {
        assertThat(findTheNumberPlate(0)).isEqualTo("aaa001");
        assertThat(findTheNumberPlate(3)).isEqualTo("aaa004");
        assertThat(findTheNumberPlate(998)).isEqualTo("aaa999");
    }

    @Test
    void should_move_first_char_to_next_when_customer_id_is_equal_or_over_999() {
        assertThat(findTheNumberPlate(999)).isEqualTo("baa001");
        assertThat(findTheNumberPlate(1487)).isEqualTo("baa489");
        assertThat(findTheNumberPlate(1998)).isEqualTo("caa001");
        assertThat(findTheNumberPlate(24975)).isEqualTo("zaa001");
        assertThat(findTheNumberPlate(24975 + 998)).isEqualTo("zaa999");
    }

    @Test
    void should_move_second_char_to_next_when_first_char_is_over() {
        assertThat(findTheNumberPlate(24975 + 999)).isEqualTo("aba001");
      //  assertThat(findTheNumberPlate(40000)).isEqualTo("oba041"); //(prima lettera 25 + o 14) + b1

        for (int i = 0; i < 26; i++)
        {
            char lower = (char) ('a' + i);
            System.out.println(lower + " - " + i);
        }
    }

    @Test
    @Disabled
    public void test() {

        assertThat(findTheNumberPlate(17558423)).isEqualTo("zzz999");
        assertThat(findTheNumberPlate(234567)).isEqualTo("aja802");
    }

}
