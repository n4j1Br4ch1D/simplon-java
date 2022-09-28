package com.shosh.shosh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.shos.shos.ShosApplication;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ShosApplication.class)
class ShosApplicationTests {

	  @Test
	  void contextLoads(ApplicationContext context) {
	    assertThat(context).isNotNull();
	  }

}
