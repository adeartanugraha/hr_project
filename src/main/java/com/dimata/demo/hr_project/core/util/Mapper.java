package com.dimata.demo.hr_project.core.util;

@FunctionalInterface
public interface Mapper<T> {
    T mapping();
}
