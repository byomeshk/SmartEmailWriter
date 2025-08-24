package com.email.writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder.build();
    }


    @Value("${gemini.api.url}")
    private  String Gemini_API_URL;

    @Value("${gemini.api.key}")
    private String API_KEY;


    public String generateEmailReply(EmailRequest emailRequest) {
        ///Build a prompt
        String prompt=buildPrompt(emailRequest);
        //Craft request to LLM

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );
        //Do request get request

        String response = webClient.post()
                .uri(Gemini_API_URL + "?key=" +API_KEY )
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        //return response

        return extractEmailFromResponse(response);
    }

    private String extractEmailFromResponse(String response) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.readTree(response);

            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error parsing response" + e.getMessage();
        }
    }


    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt=new StringBuilder();
        prompt.append("You are a professional email assistant. ")
                .append("Read the email below and generate a natural reply. ")
                .append("Do NOT include a subject line. ")
                .append("Reply directly as if you are the recipient of the email.\n\n");

        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("The reply should have a ")
                    .append(emailRequest.getTone())
                    .append(" tone.\n\n");
        }

        prompt.append("Original Email:\n")
                .append(emailRequest.getEmailContent())
                .append("\n\nReply:\n");

        System.out.println("Final prompt:\n" + prompt);

        return  prompt.toString();
    }

}
