package com.server.rest.java.server.rest;

import com.server.rest.java.server.rest.controllers.HttpStatusController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/*@AutoConfigureMockMvc
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = HttpStatusController.class
)*/
//@ContextConfiguration("classpath:rest-context-test.xml")
//@WebMvcTest(HttpStatusController.class)
//@ActiveProfiles("test")

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)

class ApplicationTests {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @InjectMocks
  private HttpStatusController httpStatusController;

  @Before
  public void setUp() {
   // this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    this.mockMvc = MockMvcBuilders.standaloneSetup(httpStatusController=new HttpStatusController()).build();
  }

	@Test
	void testRest() throws Exception {
    final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/3")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isFound())
            .andExpect(jsonPath("$.title", is(notNullValue())))
            ;

	}

}
