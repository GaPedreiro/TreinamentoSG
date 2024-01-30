package com.Lanchonete.LOG;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log")
public class LogAPI {
    private final LogService logService;

    @Autowired
    public LogAPI(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("")
    public ResponseEntity<Log> cadastrar(@RequestBody Log log) {
        return ResponseEntity.ok(this.logService.cadastrar(log));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.logService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Log> deletarPorId(@PathVariable Integer id) {
        this.logService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }
}
