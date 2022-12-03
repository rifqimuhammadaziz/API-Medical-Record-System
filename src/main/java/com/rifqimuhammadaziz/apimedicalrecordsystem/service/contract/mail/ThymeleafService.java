package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail;

import java.util.Map;

public interface ThymeleafService {
    String createContent(String template, Map<String, Object> variables);
}
