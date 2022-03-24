package com.dimata.demo.hr_project.core.search;

public interface LimitQueryStep {
    String result();
    long getPage();
    long getLimit();
    long getOffset();
    void setPage(long page);
    void setLimit(long limit);
}
