package com.missyou.service;

import com.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {

    public List<Theme> findByNames(List<String> names);

    public Optional<Theme> findByName(String name);

}
