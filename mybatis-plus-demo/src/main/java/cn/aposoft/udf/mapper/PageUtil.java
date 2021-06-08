package cn.aposoft.udf.mapper;

import com.github.pagehelper.IPage;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * safe execute the PageHelper .select operation
 */
public class PageUtil {

    private ISelect selection;

    private PageUtil(ISelect selection) {
        this.selection = selection;
    }

    private static PageUtil of(@NonNull ISelect selection) {
        return new PageUtil(selection);
    }

    public <T> List<T> select(@NonNull PageParams page) {
        try {
            return PageMethod.startPage(page.getPageNum(), page.getPageSize(), page.isCount(), page.getReasonable(), page.getPageSizeZero())
                    .setOrderBy(page.getOrderBy()).doSelectPage(this.selection);
        } finally {
            PageMethod.clearPage();
        }
    }

    public static class PageParams implements IPage {
        /**
         * 页码，从1开始
         */
        private int pageNum;
        /**
         * 页面大小
         */
        private int pageSize;
        /**
         * 包含count查询
         */
        private boolean count = true;
        /**
         * 排序
         */
        private String orderBy;
        /**
         * 进行count查询的列名
         */
        private String countColumn;
        /**
         * 只增加排序
         */
        private boolean orderByOnly;
        /**
         * 分页合理化
         */
        private Boolean reasonable;
        /**
         * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
         */
        private Boolean pageSizeZero;

        public Integer getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public boolean isCount() {
            return count;
        }

        public void setCount(boolean count) {
            this.count = count;
        }

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

        public String getCountColumn() {
            return countColumn;
        }

        public void setCountColumn(String countColumn) {
            this.countColumn = countColumn;
        }

        public boolean isOrderByOnly() {
            return orderByOnly;
        }

        public void setOrderByOnly(boolean orderByOnly) {
            this.orderByOnly = orderByOnly;
        }

        public Boolean getReasonable() {
            return reasonable;
        }

        public void setReasonable(Boolean reasonable) {
            this.reasonable = reasonable;
        }

        public Boolean getPageSizeZero() {
            return pageSizeZero;
        }

        public void setPageSizeZero(Boolean pageSizeZero) {
            this.pageSizeZero = pageSizeZero;
        }
    }
}
