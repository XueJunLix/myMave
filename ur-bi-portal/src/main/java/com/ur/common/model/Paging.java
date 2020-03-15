package com.ur.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Paging<T> implements Serializable {
    private Long total;
    private List<T> data;

    public Paging(Long total, List<T> data) {
        this.data = data;
        this.total = total;
    }

    public Boolean isEmpty() {
        return Boolean.valueOf(Objects.equals(Long.valueOf(0L), this.total) || this.data == null || this.data.isEmpty());
    }

    public static <T> Paging<T> empty(Class<T> clazz) {
        List emptyList = Collections.emptyList();
        return new Paging(Long.valueOf(0L), emptyList);
    }

    public static <T> Paging<T> empty() {
        return new Paging(Long.valueOf(0L), Collections.emptyList());
    }
}
