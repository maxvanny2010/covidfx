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
    private final File SETTINGS_FILE = new File("settings.json");
    private final Gson gson = new GsonBuilder().create();

    public ConfigModel getConfiguration() throws Exception {
        if (!SETTINGS_FILE.exists()) {
            createSettingsFile();
        }
        return getConfigurationFromFile();
    }

    private ConfigModel getConfigurationFromFile() throws IOException {
        try (Reader reader = new FileReader(SETTINGS_FILE)) {
            return this.gson.fromJson(reader, ConfigModel.class);
        }
    }

    private void createSettingsFile() throws IOException {
        ConfigModel configModel = new ConfigModel();
        try (Writer writer = new FileWriter(SETTINGS_FILE, false)) {
            this.gson.toJson(configModel, writer);
        }
    }
}
