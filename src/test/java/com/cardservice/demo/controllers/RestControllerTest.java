package com.cardservice.demo.controllers;

import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.Transaction;
import com.cardservice.demo.repository.CardRepository;
import com.cardservice.demo.repository.TransactionRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;



    @Test
    @Order(1)
    void addUser() throws Exception {
        this.mockMvc.perform(post("/api/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"phoneNumber\":\"09125208576\" }"))
                .andDo(print())
                .andExpect(content().string("true"));

    }

    @Test
    @Order(2)
    void addCart() throws Exception {
        this.mockMvc.perform(post("/api/card/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"card\":\"5133-2911-6543-7325\" , \"phoneNumber\":\"09125208576\" }"))
                .andDo(print())
                .andExpect(content().string("true"));

    }

    @Test
    @Order(3)
    void listCards() throws Exception {
        this.mockMvc.perform(post("/api/card/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"phoneNumber\":\"09125208576\" }"))
                .andDo(print())
                .andExpect(content().string(containsString("5133-2911-6543-7325")));
    }
    @Test
    @Order(4)
    void addTransaction() throws Exception {
        this.mockMvc.perform(post("/api/transaction/execute")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"source\":\"5133-2911-6543-7325\",\n" +
                        "\t\"dest\":\"5133-2911-6543-7325\",\n" +
                        "\t\"cvv2\":\"488\",\n" +
                        "\t\"expDate\":\"/02/02\",\n" +
                        "\t\"pin\":\"4353\",\n" +
                        "\t\"amount\":100 }"))
                .andExpect(content().string(containsString("result")));
        Transaction t = transactionRepository.findByDestination_CardNumber("5133-2911-6543-7325");
        transactionRepository.delete(t);



    }

    @Test
    @Order(5)
    void deleteUser() throws Exception {
        this.mockMvc.perform(post("/api/user/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{  \"phoneNumber\":\"09125208576\" }"))
                .andDo(print())
                .andExpect(content().string("true"));



    }

    @Test
    @Order(6)
    void deleteCart() throws Exception {
        this.mockMvc.perform(post("/api/card/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"card\":\"5133-2911-6543-7325\" , \"phoneNumber\":\"09125208576\" }"))
                .andDo(print())
                .andExpect(content().string("true"));
        this.mockMvc.perform(post("/api/card/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"card\":\"5133-2911-6543-7325\" }"))
                .andDo(print())
                .andExpect(content().string("true"));

    }





}
