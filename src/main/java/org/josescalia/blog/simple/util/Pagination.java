package org.josescalia.blog.simple.util;

/**
 * Created by josescalia on 21/02/16.
 */
public class Pagination {
    private Integer page;
    private Integer totalPage;
    private Integer totalRow;
    private Integer totalDisplay;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getTotalDisplay() {
        return totalDisplay;
    }

    public void setTotalDisplay(Integer totalDisplay) {
        this.totalDisplay = totalDisplay;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", totalPage=" + totalPage +
                ", totalRow=" + totalRow +
                ", totalDisplay=" + totalDisplay +
                '}';
    }


    public static int getStartRowFromStartAndLength(int iDisplayStart, int iDisplayLength) {
        int expectedCalc = 0;
        if (iDisplayStart > 1) {
            expectedCalc = (iDisplayStart / iDisplayLength);
        }
        return expectedCalc;
    }
}
