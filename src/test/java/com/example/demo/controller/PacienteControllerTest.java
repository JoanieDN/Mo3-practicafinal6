
package com.example.demo.controller;

import com.example.demo.domain.ObraSocial;
import com.example.demo.domain.Persona;
import com.example.demo.domain.Turno;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteControllerTest {
    
    public PacienteControllerTest() {
    }
    
  /*  @Test
    public void testLogin() {
        System.out.println("Login");
        String usuario = "jennifer";
        String clave = "1234";
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/Login/"+usuario+"/"+clave).accept(MediaType.APPLICATION_JSON);
    }*/

    @Test
    public void testNuevoTurno() {
        System.out.println("nuevoTurno");
        
        
        ObraSocial os = new ObraSocial();
        os.setObra_social_id(1);

        Date fecha_turno = new Date(2018-12-02);
       
       /* DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
         Calendar fecha_solicitud = GregorianCalendar.getInstance();
        */
       
        Date fecha_solicitud = new Date(2018-06-02);
        
        Turno turno = new Turno();
        turno.setMedico_id(3);
        turno.setPaciente_id(7);
        turno.setObra_social_id(os);
        turno.setFecha_turno(fecha_turno);
        turno.setFecha_solicitud_turno(fecha_solicitud);
        
        
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders
        .post("/nuevoTurno"+turno).accept(MediaType.APPLICATION_JSON);
        
        
    }


    @Test
    public void testRangoFechas() {

         System.out.println("Rango fechas");
         
         Date fechaInicio = new Date(2018-06-02);
         Date fechaFin = new Date(2018-12-02);
        
        
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders
        .post("/rangoFechas"+fechaInicio+"/"+fechaFin).accept(MediaType.APPLICATION_JSON);
        
    }
    
}
