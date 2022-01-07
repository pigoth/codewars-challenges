package org.example.challenge.pagination;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaginationHelperTest {

    @Test
    void should_return_0_page_count_when_collection_is_empty() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 1);

        assertThat(helper.pageCount()).isEqualTo(0);
    }

    @Test
    void should_return_page_count_when_collection_is_not_empty_and_single_item_per_page() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(1, 2, 3), 1);

        assertThat(helper.pageCount()).isEqualTo(3);
    }

    @Test
    void should_return_page_count_when_collection_is_not_empty_and_n_items_per_page() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(1, 2, 3), 2);

        assertThat(helper.pageCount()).isEqualTo(2);
    }

    @Test
    void should_return_0_item_count_when_collection_is_empty() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 2);

        assertThat(helper.itemCount()).isEqualTo(0);
    }

    @Test
    void should_return_how_many_items_in_collection() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(1, 2, 3), 2);

        assertThat(helper.itemCount()).isEqualTo(3);
    }

    @Test
    void should_return_page_item_count_as_negative_when_page_index_is_negative() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 2);

        assertThat(helper.pageItemCount(-100)).isEqualTo(-1);
    }

    @Test
    void should_return_page_item_count_as_negative_when_page_index_is_out_of_range() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 2);

        assertThat(helper.pageItemCount(0)).isEqualTo(-1);
    }

    @Test
    void should_return_page_item_count_when_page_is_fully() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(0, 1), 1);

        assertThat(helper.pageItemCount(0)).isEqualTo(1);
    }

    @Test
    void should_return_page_item_count_when_page_is_last_and_fully() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(0), 1);

        assertThat(helper.pageItemCount(0)).isEqualTo(1);
    }

    @Test
    void should_return_page_item_count_when_page_is_not_full() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(0, 1, 2), 2);

        assertThat(helper.pageItemCount(1)).isEqualTo(1);
    }

    @Test
    void should_return_page_index_as_negative_when_item_index_is_negative() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 2);

        assertThat(helper.pageIndex(-100)).isEqualTo(-1);
    }

    @Test
    void should_return_page_index_as_negative_when_item_index_is_out_of_range() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(), 2);

        assertThat(helper.pageIndex(0)).isEqualTo(-1);
    }

    @Test
    void should_return_page_index_as_0_when_is_in_first_page() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(0, 1, 2), 2);

        assertThat(helper.pageIndex(1)).isEqualTo(0);
    }

    @Test
    void should_return_page_index_when_is_in_other_page() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(asList(0, 1, 2), 2);

        assertThat(helper.pageIndex(2)).isEqualTo(1);
    }

}

