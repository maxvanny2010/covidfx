package com.covid.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ConfigurationService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class ConfigurationService {
    private File SETTING_FILE;
    private final Gson gson = new GsonBuilder().create();

    public ConfigurationService() throws IOException {
        try {
            final String file = this.getClass().getResource("/settings.json").getPath();
            SETTING_FILE = new File(file);
        } catch (Exception e) {
            this.createSettingFile();
        }

    }

    public ConfigModel getConfiguration() throws Exception {
        return this.getConfigurationFromFile();
    }

    private ConfigModel getConfigurationFromFile() throws IOException {
        try (final Reader reader = new FileReader(SETTING_FILE)) {
            return this.gson.fromJson(reader, ConfigModel.class);
        }
    }

    private void createSettingFile() throws IOException {
        final ConfigModel configModel = new ConfigModel();
        SETTING_FILE = new File("../resources/settings.json");
        try (final Writer writer = new FileWriter(SETTING_FILE, false)) {
            this.gson.toJson(configModel, writer);
        }
    }
}
