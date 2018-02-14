
package com.example.demo.controller;

import com.example.demo.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradorControllerTest {
    
    @Autowired
    private AdministradorController adminController;
    
    
    private MockMvc mockMvc;
    
    public AdministradorControllerTest() {
    }
    

   
    
    @Test
    public void testListAdmin() {
        System.out.println("listAdmin");
        List<Administrador> result = adminController.listAdmin();
        assertEquals(1, result.size());
       
    }

    @Test
    public void testListAll() {
        System.out.println("listAll");
        List<Medico> result = adminController.listAll();
        assertEquals(7, result.size());
        
    }
    
    @Test
    public void testGetMedico() throws Exception {
        System.out.println("Buscar Médico");
        final long id = 3;
        ResponseEntity<Medico> result = adminController.getMedico(id);
        assertEquals(1, result);
    
        mockMvc.perform(get("/BuscarId/"+id).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
           .get("/admin/BuscarId/"+id).accept(MediaType.APPLICATION_JSON);
 
        
    }

    @Test
    public void testNuevoMedico() throws Exception {
        
        System.out.println("nuevoMedico");
        Especialidad es = new Especialidad();
        es.setEspecialidad_id(1);
        
       Medico m = new Medico();
       m.setClave("2343");
       m.setEmail("ana@mail.com");
       m.setNombre("Ana Hernandez");
       m.setUsuario("anita");
       m.setEspecialidadId(es);
             
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders
        .post("/nuevoMedico"+m).accept(MediaType.APPLICATION_JSON);

    }

   /* @Test
    public void testActualizarMedico() throws Exception {
        System.out.println("actualizarMedico");
        
       Medico m = new Medico();
       m.setId(12);
       m.setEmail("ana@mail.com");
       m.setNombre("Dr Mariana NuevoMontes");
     
        
       
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders
                .put("/editarMedico"+m).accept(MediaType.APPLICATION_JSON);
       
    }*/

    @Test
    public void testEliminarMedico() throws Exception {
        System.out.println("eliminarMedico");
        int id =7;
        
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders.
                delete("/EliminarMedico"+id).accept(MediaType.APPLICATION_JSON);
    }

   @Test
    public void testListarPacientes() {
        System.out.println("listarPacientes");
        List<Paciente> result = adminController.listarPacientes();
        assertEquals(3, result);
        
        
    }
    
    @Test
    public void testNuevoPaciente() throws Exception {
       
        System.out.println("nuevoMedico");
        ObraSocial os = new ObraSocial();
        os.setObra_social_id(1);
        
       Paciente m = new Paciente();
       m.setClave("2343");
       m.setEmail("ana@mail.com");
       m.setNombre("Ana Hernandez");
       m.setUsuario("anita");
       m.setObraSocialdId(os);
       
             
        MockHttpServletRequestBuilder nuevo = MockMvcRequestBuilders
        .post("registrarPaciente/"+m).accept(MediaType.APPLICATION_JSON);
    }

   /* @Test
    public void testActualizarPaciente() throws Exception {
        System.out.println("actualizarPaciente");
        Paciente paciente = null;
        AdministradorController instance = null;
        ResponseEntity<Paciente> expResult = null;
        ResponseEntity<Paciente> result = instance.actualizarPaciente(paciente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    @Test
    public void testBorrarPaciente() throws Exception {
        System.out.println("BorrarPaciente");
        
        int id =1;
        
        MockHttpServletRequestBuilder eliminar = MockMvcRequestBuilders.
                delete("/EliminarPaciente"+id).accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void testPorObraSoc() {
        System.out.println("porObraSoc");

        List<Paciente> result = adminController.porObraSoc();
        assertEquals(11, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testObraSocialTurno() {
        System.out.println("MaximoObraS");
        Date fecha =  new Date(2018-06-02);
        
        List<Turno> result = adminController.obraSocialTurno(fecha);
        
        
         MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/MaximoObraS/"+fecha).accept(MediaType.APPLICATION_JSON);
        
        
    }
    
}
