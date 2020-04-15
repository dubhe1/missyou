package com.missyou.service;

import com.missyou.dto.TokenGetDTO;

public interface AuthenticationService {

    public void getTokenByEmail(TokenGetDTO userData);

    public void validateByWx(TokenGetDTO userData);

    public void register();
}
