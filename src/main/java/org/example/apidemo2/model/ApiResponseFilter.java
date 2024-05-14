package org.example.apidemo2.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiResponseFilter {
    public static void main(String[] args) throws IOException {
        String jsonResponse = "[{\"response\": {\"docs\": [{\"web_url\": \"https://example.com/page1\"}, {\"web_url\": \"https://example.com/page2\"}, {\"other_field\": \"value\"}]}}]";
        ApiResponseFilter filter = new ApiResponseFilter();
        List<String> filteredWebUrls = filter.filterWebUrls(jsonResponse);
        System.out.println(filteredWebUrls);
    }

    public List<String> filterWebUrls(String jsonResponse) throws IOException {
        List<String> webUrls = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonResponse);

        JsonNode response = root.path("response");
        if (response.isMissingNode()) {
            return webUrls;
        }

        JsonNode docs = response.path("docs");
        if (docs.isArray()) {
            for (JsonNode doc : docs) {
                JsonNode webUrl = doc.path("web_url");
                if (webUrl.isTextual()) {
                    webUrls.add(webUrl.textValue());
                }
            }
        }

        return webUrls;
    }
}
