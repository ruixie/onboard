package com.onboard.service.index.model;

/**
 * 分页辅助类
 *
 * @author lvyiqiang, yewei
 */
public class Page {
    private long sum;
    private int currentPageNumber;
    private int pageSize;
    private boolean hasRead = false;

    public Page(int pageSize) {
        sum = 0;
        currentPageNumber = 0;
        this.pageSize = pageSize;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void nextPage() {
        hasRead = true;
        currentPageNumber++;
    }

    public boolean hasNext() {
        if (!hasRead) {
            return true;
        }
        if (currentPageNumber * pageSize >= sum) {
            return false;
        }

        return true;
    }
}
