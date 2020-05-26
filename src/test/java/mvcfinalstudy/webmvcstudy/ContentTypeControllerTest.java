package mvcfinalstudy.webmvcstudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ContentTypeControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void helloTest() throws Exception {


        mockMvc.perform(get("/content")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.FROM, "localhost"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hellos"));
    }

    @Test
    public void getEvents() throws Exception {
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getEventsWithId() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postEventsWithId() throws Exception {
        mockMvc.perform(post("/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}