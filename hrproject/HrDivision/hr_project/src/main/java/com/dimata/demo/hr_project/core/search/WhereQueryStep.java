package com.dimata.demo.hr_project.core.search;

public interface WhereQueryStep {
    String result();
    WhereQueryStep and(WhereQueryStep step);
    WhereQueryStep or(WhereQueryStep step);
    WhereQueryStep not(WhereQueryStep step);
}
