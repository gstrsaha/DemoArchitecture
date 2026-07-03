package rs.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import rs.demo.model.DemoReq;
import rs.demo.service.DemoService;

@WebMvcTest(MasterController.class)
class MasterControllerTest implements MasterURIConstant {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DemoService demoService;

    @Test
    void testHelloPrint() throws Exception {
        mockMvc.perform(get(MasterURIConstant.GET_WELCOME)).andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    void testNamePrint() throws Exception {

        String json = "{\"name\":\"John\"}";

        mockMvc.perform(post(MasterURIConstant.POST_WELCOME)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("hello welcome John"));
    }

    @Test
    void testDbValFetch() throws Exception {

        when(demoService.getData(any(DemoReq.class)))
                .thenReturn("10001");

        String json = "{\"name\":\"ABC\"}";

        mockMvc.perform(post(MasterURIConstant.POST__DB_DEMO)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

}