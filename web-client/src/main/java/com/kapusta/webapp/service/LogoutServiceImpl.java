package com.kapusta.webapp.service;

import com.google.inject.Inject;
import javafx.application.Platform;

public class LogoutServiceImpl implements LogoutService{

    @Inject
    private TokenRepositoryService tokenRepositoryService;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private LoginSceneFactory loginSceneFactory;

    public void logout(){
        //TODO logout on server
        tokenRepositoryService.removeToken();
        Platform.runLater(() -> mainStageHolder.changeRoot(loginSceneFactory.factorLoginRoot()));
    }
}