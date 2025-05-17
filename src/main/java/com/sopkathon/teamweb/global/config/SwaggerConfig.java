package com.sopkathon.teamweb.global.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("솝커톤 웹2팀 API")
				.version("v1.0.0")
				.description("SOPT 36기 솝커톤 - 웹2팀을 위한 API입니다"));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
			.group("public-api")
			.pathsToMatch("/**")  // 모든 경로 매칭
			.packagesToScan("com.sopkathon.teamweb")
			.packagesToExclude("com.sopkathon.teamweb.global.common.exception")
			.build();
	}
}
