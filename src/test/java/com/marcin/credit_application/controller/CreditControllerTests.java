package com.marcin.credit_application.controller;

import com.google.gson.Gson;
import com.marcin.credit_application.domain.CreateObjectDto;
import com.marcin.credit_application.domain.GetObjectsDto;
import com.marcin.credit_application.service.Services;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CreditController.class)
public class CreditControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Services service;

    @Test
    public void testGetEmptyCredits() throws Exception {
        //Given
        List<GetObjectsDto> creditList = new ArrayList<>();

        when(service.getAllCredits()).thenReturn(creditList);

        //When & Then
        mockMvc.perform(get("/api/get").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGetCredits() throws Exception {
        //Given
        List<GetObjectsDto> creditList = new ArrayList<>();
        creditList.add(new GetObjectsDto(1, "test", "test",
                100, "test", "test", "test"));

        when(service.getAllCredits()).thenReturn(creditList);

        //When & Then
        mockMvc.perform(get("/api/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].creditId", is(1)))
                .andExpect(jsonPath("$[0].creditName", is("test")))
                .andExpect(jsonPath("$[0].productName", is("test")))
                .andExpect(jsonPath("$[0].value", is(100)))
                .andExpect(jsonPath("$[0].firstName", is("test")))
                .andExpect(jsonPath("$[0].surname", is("test")))
                .andExpect(jsonPath("$[0].pesel", is("test")));
    }

    @Test
    public void testCreateCredit() throws Exception {
        //Given
        CreateObjectDto createObjectDto = new CreateObjectDto("test", "test",
                100, "test", "test", "test");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(createObjectDto);

        //When & Then
        mockMvc.perform(post("/api/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
