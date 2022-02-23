package com.example.demo.Repository;

import com.example.demo.Model.DocTemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocTemplateRepository extends JpaRepository<DocTemplate,Long>{
    
}
