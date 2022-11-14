package com.hau.huylong.graduation_proejct.controller;

import com.hau.huylong.graduation_proejct.model.response.APIResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<APIResponse<String>> home() {
        return ResponseEntity.ok(APIResponse.success("Hello"));
    }
}
