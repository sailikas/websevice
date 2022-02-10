package com.xbl.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select().paths(regex(".*")).build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);
        return docket;
    }



    public ApiInfo apiInfo(){
        return new ApiInfo(
                "果核网盘api文档",
                "学生项目，果核网盘。",
                "v1.0",
                "3265625613@qq.com", //开发者团队的邮箱
                "邢柏林",
                "许可证",  //许可证
                "http://www.apache.org/licenses/LICENSE-2.0" //许可证链接
        );
    }
}