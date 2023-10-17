package com.shopecommerce.utils.constants;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
public enum EActiveStatus {
    ACTIVE(1, "Hoạt động", "Active"),
    INACTIVE(0, "Khoá", "Lock");
    private final Integer value;
    private final String nameVi;
    private final String nameEn;

    EActiveStatus(Integer value, String nameVi, String nameEn) {
        this.value = value;
        this.nameVi = nameVi;
        this.nameEn = nameEn;
    }

    public String getText() {
        return this.nameVi;
    }

    public static EActiveStatus findByValue(Integer value) {
        EActiveStatus[] statuses = EActiveStatus.values();
        for (EActiveStatus status : statuses) {
            if (Objects.equals(status.getValue(), value)) {
                return status;
            }
        }
        return null;
    }

    public static String getName(Integer value, String lang) {
        if(StringUtils.hasText(lang) && lang.length() == 2) {
            if(lang.toLowerCase().equals("vn")) {
                lang = "Vi";
            }
        }
        return null;
    }

}
