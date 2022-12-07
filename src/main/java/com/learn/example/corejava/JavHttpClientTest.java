package com.learn.example.corejava;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavHttpClientTest {
    public static void main(String[] args) {

        {
            URI uri = null;
            try {
                uri = new URI("https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9I9urWjeUW05sHPHvYPZgYyWiOFtd9RKkmsaUeW.xYm2f16Ek_nFZvUW4WxFB5ukVwGCioB8jl4OAHCvX&client_secret=18743928EC9A5AA4E284F38A083F4AC3F99F4CBEDACFDE208E8C9E3886243DEF&username=kamalan@intervest.lk&password=1nterve$T");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            try {
                HttpResponse<String> response = HttpClient
                        .newBuilder()
                        .proxy(ProxySelector.getDefault())
                        .build()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String body = response.body();
                ObjectMapper objectMapper = new ObjectMapper();
                Response response1 = objectMapper.readValue(body, Response.class);
                System.out.println(response1.getAccessToken());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            return "";
        }
    }


}
class Response {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("instance_url")
    private String instanceUrl;

    @JsonProperty("id")
    private String id;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("issued_at")
    private String issuedAt;

    @JsonProperty("signature")
    private String signature;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
