package com.tagoio.sdk.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.tagoio.sdk.domain.Result;

public class Network extends TagoModel {

    String NORTHMEN_DEVICE_TOKEN = "at9dcdffcf9e13459ab86c0040b36bf2c7";
    String DATANET_TOKEN = "f4f30a8a-a8a2-41fc-a235-e0859610e85c";

    public Network(String token) {
        super(token);
    }

    @SuppressWarnings("unchecked")
    public Result resolveToken(String serialNumber, String authorization) {
        String path = "/integration/network/resolve/" + serialNumber;
        if (authorization != null && authorization.length() > 0) {
            path += "/" + authorization;
        }
        // '/integration/network/resolve/597759/at9dcdffcf9e13459ab86c0040b36bf2c7'
        // Result result = await this.doRequest({
        // path,
        // method: "GET",
        // params: {
        // details: this.params.details,
        // },
        // });
        // return result;
        // }

        String url = api_url + path;

        HttpMethod method = HttpMethod.GET;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        headers.add("Authorization", DATANET_TOKEN);

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity<Result> response = restTemplate
                .exchange(builder.build().toUriString(),
                        method,
                        entity,
                        Result.class);

        return response.getBody();
    }
}
