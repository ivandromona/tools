/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Conversor;
import com.example.demo.Model.DocTemplate;
import com.example.demo.Repository.DocTemplateRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200",
methods = { RequestMethod.DELETE,
RequestMethod.POST,
RequestMethod.PUT,
RequestMethod.GET
},
allowedHeaders = "*")
public class HomeController {

    @Autowired
    private DocTemplateRepository docTemplateRepository;

    @PostMapping
    public ResponseEntity<?> save() throws Exception {
        DocTemplate docTemplate = new DocTemplate();
        Conversor c = new Conversor();
        docTemplate.setName("adn_contract");
        docTemplate.setDescription("Nossos contratos são validados com este modelo");
        docTemplate.setTemplate(c.fromDocxToHtmlAndBack());
        return new ResponseEntity<>(this.docTemplateRepository.save(docTemplate), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DocTemplate>> getAllDocTemplate() {
return new ResponseEntity<>(this.docTemplateRepository.findAll(),HttpStatus.OK);
    }
}
