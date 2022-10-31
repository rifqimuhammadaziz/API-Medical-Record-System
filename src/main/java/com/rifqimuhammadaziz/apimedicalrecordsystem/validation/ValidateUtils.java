package com.rifqimuhammadaziz.apimedicalrecordsystem.validation;

import lombok.Builder;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
public class ValidateUtils {
    private String fieldName;
    private Object value;
    private boolean required;
    private Integer maxLength;
    private String regex;
    private boolean onlyNumber;
    private boolean isInteger;
    private boolean isDate;
    private Long max;
    private Long min;
    private String message;

    private final String ONLY_NUMBER = "[0-9]+";

    public Map validate() {
        Map<String, String> errors = new HashMap<>();

        // CHECK FIELD IS REQUIRED
        if (required && ObjectUtils.isEmpty(value) && !ObjectUtils.isEmpty(fieldName)) {
            errors.put(fieldName, fieldName + " is required");
        }

        // CHECK MAX LENGTH VALUE OF FIELD
        if (!ObjectUtils.isEmpty(maxLength) &&
                !ObjectUtils.isEmpty(value) &&
                value.toString().length() > maxLength.intValue() &&
                !ObjectUtils.isEmpty(fieldName)) {
            errors.put(fieldName, fieldName + " must has 1 - " + maxLength + " characters");
        }

        // CHECK VALUE OF FIELD IS ONLY NUMBER
        if (onlyNumber &&
                !ObjectUtils.isEmpty(value) &&
                !ObjectUtils.isEmpty(fieldName)) {
            Pattern numberOnlyPattern = Pattern.compile(ONLY_NUMBER);
            Matcher matcher = numberOnlyPattern.matcher(value.toString());
            if (!matcher.matches()) {
                errors.put(fieldName, fieldName + " must contains number only");
            }
        }

        // CHECK VALUE OF FIELD IS INTEGER
        if (isInteger && !ObjectUtils.isEmpty(value) && !ObjectUtils.isEmpty(fieldName)) {
            try {
                Integer.parseInt(value.toString());
            } catch (Exception e) {
                errors.put(fieldName, fieldName + " must integer number");
            }
        }

        // CHECK MAX & MIN OF FIELD VALUE
        if (!ObjectUtils.isEmpty(max) &&
                !ObjectUtils.isEmpty(value) &&
                !ObjectUtils.isEmpty(min) &&
                !ObjectUtils.isEmpty(fieldName)) {
            try {
                Long valueCheck = Long.valueOf(value.toString());
                if (valueCheck < min || valueCheck > max) {
                    errors.put(fieldName, fieldName + " must range from " + min + " to " + max);
                }
            } catch (Exception e) {
                errors.put(fieldName, fieldName + " is invalid data type");
            }
        }

        // CHECK DATE OF FIELD VALUE

        return errors;
    }
}
