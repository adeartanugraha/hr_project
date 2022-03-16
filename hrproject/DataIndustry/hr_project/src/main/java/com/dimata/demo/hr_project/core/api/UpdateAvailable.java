package com.dimata.demo.hr_project.core.api;

/**
 * Menandakan bahwa tabel bisa di update. <br>
 * Digunain nanti pada {@link DbHandlerBase}
 * @param <T> Kelas tabel
 */
public interface UpdateAvailable<T> {
    T update(T newData);
}
