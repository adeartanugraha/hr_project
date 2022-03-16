package com.dimata.demo.hr_project.core.search;

public interface JoinOperationStep {
    JoinQueryStep on(WhereQueryStep operationStep);
}
