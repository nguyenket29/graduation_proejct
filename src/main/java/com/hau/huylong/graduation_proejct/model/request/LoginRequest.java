package com.hau.huylong.graduation_proejct.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginRequest {
    @JsonProperty("username") private String username;
    @JsonProperty("password") private String password;
}
