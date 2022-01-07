package org.example.challenge.pagination;

import java.util.List;

public class PaginationHelper<I> {

    private final List<I> items;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> items, int itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return items.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int) Math.ceil(itemCount() / (double) itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        boolean pageNotExist = pageIndex < 0 || pageIndex > pageCount() - 1;
        boolean isLastPage = pageIndex == pageCount() - 1;
        boolean lastPageIsFull = itemCount() % itemsPerPage == 0;

        if (pageNotExist) return -1;
        else if (isLastPage && !lastPageIsFull) return itemCount() % itemsPerPage;
        else return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        boolean itemNotExist = itemIndex < 0 || itemIndex > itemCount() - 1;
        return itemNotExist ? -1 : itemIndex / itemsPerPage;
    }
}
