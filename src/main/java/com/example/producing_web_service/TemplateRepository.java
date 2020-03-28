package com.example.producing_web_service;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateRepository {
    private static final Map<String, DateFormatTemplate> templates = new HashMap<>();

    @PostConstruct
    public void initData() {

        DateFormatTemplate template = new DateFormatTemplate();
        template.setAvailable(true);
        template.setName("simple");
        template.setDescription("Description");
        template.setFormat("To jest twoja data ${data}");
    }

    public DateFormatTemplate findTemplate(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return templates.get(name);
    }
}
