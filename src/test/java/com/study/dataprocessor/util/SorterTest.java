package com.study.dataprocessor.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SorterTest {

    private Sorter sorter = new Sorter();

    @DisplayName("영어일 경우 AaBb 순으로 오름차순 정렬한다")
    @Test
    void stringSortTest() {
        final String result = sorter.sort("zZzAAbBccDDEEe");
        assertThat(result).isEqualTo("AABbccDDEEeZzz");
    }

    @DisplayName("숫자일 경우 0~9 순으로 오름차순 정렬한다")
    @Test
    void numberSortTest() {
        final String result = sorter.sort("12738906587190234");
        assertThat(result).isEqualTo("00112233456778899");
    }

}
