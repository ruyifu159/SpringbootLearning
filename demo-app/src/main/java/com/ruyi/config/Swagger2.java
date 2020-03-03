package com.ruyi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.service.Tag;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.*;
import static springfox.documentation.schema.AlternateTypeRules.*;

@Configuration
@EnableSwagger2
public class Swagger2 {
	/**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi() {
    	return new Docket(DocumentationType.SWAGGER_2)   // 初始化swagger2 api配置
    	        .select()   // 返回一个ApiSelectorBuilder 实例
    	        .apis(RequestHandlerSelectors.basePackage("com.ruyi"))    // api筛选模式，可选值有any / none / withClassAnnotation / withMethodAnnotation / basePackage
    	        .paths(PathSelectors.any())  // 可选值：正则表达式  / ant  / any / none 
    	        .build()
    	        .pathMapping("/")
    	        //.directModelSubstitute(LocalDate.class, String.class)
    	        
    	        .genericModelSubstitutes(ResponseEntity.class)
    	        .alternateTypeRules(
    	            newRule(typeResolver.resolve(DeferredResult.class,
    	                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
    	                typeResolver.resolve(WildcardType.class)))
    	        
    	        .useDefaultResponseMessages(false)   // 是否显示response code
    	        .globalResponseMessage(RequestMethod.GET,    // 重写response message
    	            newArrayList(new ResponseMessageBuilder()
    	                .code(500)
    	                .message("500 message")
    	                .responseModel(new ModelRef("Error"))   // ???
    	                .build()))
    	      
    	        //.securitySchemes(newArrayList(apiKey()))    // 提供的securtiy schemas有 ApiKey, BasicAuth, OAuth
    	        //.securityContexts(newArrayList(securityContext()))  //  ???
    	       
    	        .enableUrlTemplating(true)
    	        .globalOperationParameters(
    	            newArrayList(new ParameterBuilder()
    	                .name("someGlobalParameter")
    	                .description("Description of someGlobalParameter")
    	                .modelRef(new ModelRef("string"))
    	                .parameterType("query")
    	                .required(true)
    	                .build()))
    	        .tags(new Tag("Hello World接口", "所有与Hello World相关的接口说明"))   // 接口的标题信息
    	        //.additionalModels(typeResolver.resolve(AdditionalModel.class))  // ???
    	        ;

    }
    @Autowired
    private TypeResolver typeResolver;

    private ApiKey apiKey() {
      return new ApiKey("mykey", "api_key", "header");
    }

    private SecurityContext securityContext() {
      return SecurityContext.builder()
          .securityReferences(defaultAuth())
          .forPaths(PathSelectors.regex("/anyPath.*"))
          .build();
    }

    List<SecurityReference> defaultAuth() {
      AuthorizationScope authorizationScope
          = new AuthorizationScope("global", "accessEverything");
      AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
      authorizationScopes[0] = authorizationScope;
      return newArrayList(
          new SecurityReference("mykey", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
      return SecurityConfigurationBuilder.builder()
          .clientId("test-app-client-id")
          .clientSecret("test-app-client-secret")
          .realm("test-app-realm")
          .appName("test-app")
          .scopeSeparator(",")
          .additionalQueryStringParams(null)
          .useBasicAuthenticationWithAccessCodeGrant(false)
          .build();
    }

    @Bean
    UiConfiguration uiConfig() {
      return UiConfigurationBuilder.builder()
          .deepLinking(true)
          .displayOperationId(false)
          .defaultModelsExpandDepth(1)
          .defaultModelExpandDepth(1)
          .defaultModelRendering(ModelRendering.EXAMPLE)
          .displayRequestDuration(false)
          .docExpansion(DocExpansion.NONE)
          .filter(false)
          .maxDisplayedTags(null)
          .operationsSorter(OperationsSorter.ALPHA)
          .showExtensions(false)
          .tagsSorter(TagsSorter.ALPHA)
          .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
          .validatorUrl(null)
          .build();
    }
}
