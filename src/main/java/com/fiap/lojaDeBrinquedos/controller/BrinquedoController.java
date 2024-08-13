package com.fiap.lojaDeBrinquedos.controller;

import com.fiap.lojaDeBrinquedos.model.Brinquedo;
import com.fiap.lojaDeBrinquedos.repository.BrinquedoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Brinquedo")
@Controller
@RequestMapping("/brinquedo")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;


    @Operation(summary = "Cadastra um brinquedo na base de dados", responses = {
            @ApiResponse(responseCode = "201", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = Brinquedo.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar brinquedo")})

    @PostMapping
    public ResponseEntity<Brinquedo> cadastrar(@RequestBody Brinquedo brinquedo){
        brinquedoRepository.save(brinquedo);
        return ResponseEntity.status(201).body(brinquedo);
    }

    @Operation(summary = "Lista os brinquedos da base de dados", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Brinquedo.class))))})
    @GetMapping
    public ResponseEntity<List<Brinquedo>> listar(){
        List<Brinquedo> all = brinquedoRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @Operation(summary = "Altera um brinquedo na base de dados com base no id", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = Brinquedo.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao alterar brinquedo")})

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> alterar(@PathVariable Long id, @RequestBody Brinquedo brinquedo){
        Brinquedo referenceById = brinquedoRepository.getReferenceById(id);
        referenceById.alterar(brinquedo);
        brinquedoRepository.save(referenceById);
        return ResponseEntity.ok(brinquedo);
    }


    @Operation(summary = "Deleta um brinquedo na base de dados com base no id", responses = {
            @ApiResponse(responseCode = "204", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = Brinquedo.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao deletar brinquedo")})
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        brinquedoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
