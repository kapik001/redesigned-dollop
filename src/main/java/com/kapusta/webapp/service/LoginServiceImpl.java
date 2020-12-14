package com.kapusta.webapp.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class LoginServiceImpl implements LoginService {
    @Override
    public void login(String login, String password) {
        Client client = ClientBuilder.newClient();
        client.target("http://localhost:8082/" + login + "/" + password)
                .request(MediaType.APPLICATION_JSON)
                .get(Object.class);
    }
}
