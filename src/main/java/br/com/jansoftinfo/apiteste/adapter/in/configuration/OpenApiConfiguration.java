package br.com.jansoftinfo.apiteste.adapter.in.configuration;

import br.com.jansoftinfo.apiteste.adapter.utils.Constants;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(appInfo());
    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", new ApiResponse()
                        .description(Constants.MESSAGE_CODE200)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
                apiResponses.addApiResponse("201", new ApiResponse()
                        .description(Constants.MESSAGE_CODE201)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
                apiResponses.addApiResponse("204", new ApiResponse()
                        .description(Constants.MESSAGE_CODE204)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));

                apiResponses.addApiResponse("400", new ApiResponse()
                        .description(Constants.MESSAGE_CODE400)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
                apiResponses.addApiResponse("401", new ApiResponse()
                        .description(Constants.MESSAGE_CODE401)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
                apiResponses.addApiResponse("403", new ApiResponse()
                        .description(Constants.MESSAGE_CODE403)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
                apiResponses.addApiResponse("404", new ApiResponse()
                        .description(Constants.MESSAGE_CODE404)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));

                apiResponses.addApiResponse("500", new ApiResponse()
                        .description(Constants.MESSAGE_CODE500)
                        .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType())));
            }));
        };
    }

    private Info appInfo() {
        return new Info()
                .title(Constants.TITLE_API)
                .version(Constants.VERSION)
                .description(Constants.DESCRIPTION)
                .termsOfService(Constants.TERMS_OF_SERVICE)
                .contact(appContact())
                .license(appLicence());
    }

    private Contact appContact() {
        return new Contact()
                .name(Constants.AUTHOR)
                .email(Constants.EMAIL_DEV)
                .url(Constants.JANSOFT);
    }

    private License appLicence() {
        return new License()
                .url(Constants.LICENSE_LINK)
                .identifier(Constants.LICENSE);
    }
}