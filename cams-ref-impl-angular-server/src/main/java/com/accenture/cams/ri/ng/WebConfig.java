package com.accenture.cams.ri.ng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.AppCacheManifestTransformer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private ResourceUrlProvider urlProvider;

	@Value("${resources.projectroot:}")
	private String projectRoot;

	@Value("${resources.clientsourcepath:}")
	private String clientSourcePath;

	@Value("${app.version:}")
	private String appVersion;


	private String getProjectRootRequired() {
		Assert.state(this.projectRoot != null, "Please set \"resources.projectRoot\" in application.yml");
		return this.projectRoot;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		return new ResourceUrlEncodingFilter();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		boolean devMode = this.env.acceptsProfiles("development");

		String location = devMode ? "file:///" + getProjectRootRequired() + clientSourcePath : "classpath:/static/";
		Integer cachePeriod = devMode ? 0 : null;
		boolean useResourceCache = !devMode;
		String version = devMode ? "dev" : this.appVersion;

		AppCacheManifestTransformer appCacheTransformer = new AppCacheManifestTransformer();
		VersionResourceResolver versionResolver = new VersionResourceResolver()
				.addFixedVersionStrategy(version, "/**/*.js", "/**/*.js.map")
				.addContentVersionStrategy("/**");

		registry.addResourceHandler("/**")
				.addResourceLocations(location)
				.setCachePeriod(cachePeriod)
				.resourceChain(useResourceCache)
					.addResolver(versionResolver)
					.addTransformer(appCacheTransformer);
	}

}
