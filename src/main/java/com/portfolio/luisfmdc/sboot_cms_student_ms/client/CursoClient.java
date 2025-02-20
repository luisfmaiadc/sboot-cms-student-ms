package com.portfolio.luisfmdc.sboot_cms_student_ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sboot-cms-course-ms")
public interface CursoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/curso/validar/{idCurso}")
    ResponseEntity<Void> validarCurso(@PathVariable Integer idCurso);
}
