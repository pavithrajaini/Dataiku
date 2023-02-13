package com.mb.dataiku.application.config;

import io.micronaut.context.annotation.Value;
import io.micronaut.security.token.jwt.validator.JwtAuthenticationFactory;
import jakarta.inject.Inject;

public class WebConfig{
	@Value("${drd.certificate-file}")
	private String certificateFile;

	@Value("${drd.certificate-pass}")
	private String certificatePass;

	@Value("${allowedCorsOriginPatternUrl}")
	private String corsOriginUrl;
	
	@Inject
	private JwtAuthenticationFactory filter;

}