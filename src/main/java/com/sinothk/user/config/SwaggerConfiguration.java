package com.sinothk.user.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {

    private ApiInfo apiInfo = new ApiInfoBuilder()
            .title("系统级别接口")
            .description("接口包括：用户管理等！")
            .termsOfServiceUrl("http://www.sinothk.com/")
            .contact(new Contact("LiangYT", "http://www.sinothk.com/", "381518188@qq.com"))
            .version("1.0")
            .build();

    @Bean(value = "systemGroupRestApi")
    public Docket systemGroupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("用户系统接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sinothk.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
