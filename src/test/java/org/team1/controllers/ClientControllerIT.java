package org.team1.controllers;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.team1.InsApp;
import org.team1.models.Client;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        deleteClient();
    }


    @Test
    public void testGetAllClients() throws JSONException {
        ResponseEntity<String> response =
                restTemplate.getForEntity(createURLWithPort("/clients"), String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        String expected = " [\n" +
                            "    {\n" +
                            "        \"amka\": 123456780,\n" +
                            "        \"firstName\": \"clientFirst\",\n" +
                            "        \"lastName\": \"ClientLast\",\n" +
                            "        \"username\": \"client\",\n" +
                            "        \"phone\": 1234567890,\n" +
                            "        \"email\": \"client@gmail.com\"\n" +
                            "    }\n" +
                            "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testGetClientById() {
        long clientId = 123456780l;
        ResponseEntity<Client> response = restTemplate.getForEntity(createURLWithPort("/clients/{id}"), Client.class, clientId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getAmka()).isEqualTo(123456780);
    }

    @Test
    public void testRegister() {
        Client newClient = new Client();

        newClient.setAmka(123456782);
        newClient.setFirstName("MpampisFirst");
        newClient.setLastName("MpampisLast");
        newClient.setUsername("Mpampis");
        newClient.setPassword("Mpampis");
        newClient.setPhone(675439872);
        newClient.setEmail("mpampis@gmail.com");

//TODO: it doesn't be saved
        ResponseEntity<Client> response =
                restTemplate.postForEntity(createURLWithPort("/register"), newClient, Client.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getAmka()).isEqualTo(123456782);
        assertThat(response.getBody().getFirstName()).isEqualTo("MpampisFirst");
        assertThat(response.getBody().getLastName()).isEqualTo("MpampisLast");
    }

    @Test
    public void deleteClient() {
        Long clientId = 123456782l;
        restTemplate.delete(createURLWithPort("/clients/{id}"), clientId, Void.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
