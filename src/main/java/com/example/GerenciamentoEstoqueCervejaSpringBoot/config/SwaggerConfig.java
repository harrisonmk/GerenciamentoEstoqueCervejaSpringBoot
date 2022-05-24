package com.example.GerenciamentoEstoqueCervejaSpringBoot.config;





import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    
    private static final String API_TITLE = "API Estoque de Cerveja";
    private static final String API_DESCRIPTION = "API REST para gerenciamento de estoque de cerveja";
    private static final String CONTACT_NAME = "Harrison Mitchell";
    private static final String CONTACT_GITHUB = "https://github.com/harrisonmk";
    private static final String CONTACT_EMAIL = "harrison.mitchell@hotmail.com";
    
    Contact cont = new Contact();
    

    @Bean
    public OpenAPI customOpenApi() {

        return new OpenAPI()
                .info(new Info()
                        .title(API_TITLE)
                        .version("versao 1.0")
                        .description(API_DESCRIPTION)
                        .termsOfService("http://swagger.io/terms")
                        .contact(cont.name(CONTACT_NAME).url(CONTACT_GITHUB).email(CONTACT_EMAIL))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }

    

}
