
package com.example.demo.controller;

import com.example.demo.domain.Turno;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.*;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicoControllerTest {
    
    private MockMvc mockMvc;
    
    public MedicoControllerTest() {
    }
    
    @Autowired
    MedicoController medicoController;

    @Test
    public void testBuscarFecha() {
        System.out.println("buscarFecha");
       
        Date fecha =  new Date(2018-06-02);
        
        //List<Turno> result = medicoController.buscarFecha(fecha);
        
         MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/medico/buscarFecha/"+fecha).accept(MediaType.APPLICATION_JSON);
    }
    
}
