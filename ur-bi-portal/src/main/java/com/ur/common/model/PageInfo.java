package com.ur.common.model;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
public class PageInfo {
    public static final String LIMIT = "limit";
    public static final String OFFSET = "offset";
    private Integer offset;
    private Integer limit;

    public static PageInfo of(Integer pageNo, Integer size) {
        return new PageInfo(pageNo, size);
    }

    public PageInfo(Integer pageNo, Integer size) {
        pageNo = pageNo != null ? pageNo : Integer.valueOf(1);
        size = size != null ? size : Integer.valueOf(20);
        this.limit = Integer.valueOf(size.intValue() > 0?size.intValue():20);
        this.offset = Integer.valueOf((pageNo.intValue() - 1) * size.intValue());
        this.offset = Integer.valueOf(this.offset.intValue() > 0?this.offset.intValue():0);
    }

    public Map<String, Object> toMap() {
        return this.toMap((String)null, (String)null);
    }

    public Map<String, Object> toMap(String key1, String key2) {
        HashMap param = Maps.newHashMapWithExpectedSize(2);
        param.put(Strings.isNullOrEmpty(key1)?"offset":key1, this.offset);
        param.put(Strings.isNullOrEmpty(key2)?"limit":key2, this.limit);
        return param;
    }
}
