package com.email.writer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*") //helping to make request from other places like frontend or extension etc
public class EmailGeneratorController {


    private final EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        // Implementation for generating email
        String generatedEmail = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(generatedEmail);
    }
}
