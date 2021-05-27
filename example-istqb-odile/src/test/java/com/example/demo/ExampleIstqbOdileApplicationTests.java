package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExampleIstqbOdileApplicationTests {

	@Test
	void contextLoads(ApplicationContext appCtx) {
		int beanDefinitionCount = appCtx.getBeanDefinitionCount();
		assertNotNull(appCtx);
		assertThat(beanDefinitionCount).isGreaterThan(10);
	}

}
