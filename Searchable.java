package edu.ccrm.domain;

@FunctionalInterface
public interface Searchable<T> {
    boolean matches(T other);
}
