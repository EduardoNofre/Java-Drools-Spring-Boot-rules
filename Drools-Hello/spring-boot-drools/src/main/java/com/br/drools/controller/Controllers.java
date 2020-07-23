/**
 * 
 */
package com.br.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.drools.model.CarroModel;
import com.br.drools.model.PessoaModel;
import com.br.drools.service.Services;

import io.swagger.annotations.ApiOperation;

/**
 * @author eduardo.sa
 *
 */

@Controller
@RequestMapping("/drools")
public class Controllers {

	@Autowired
	private Services services;

	@ApiOperation(value = "Drools rule PessoaModel")
	@PostMapping(path = "/consulta-pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaModel> drools(@RequestBody PessoaModel pessoa) {
		
		PessoaModel pessoaModel = new PessoaModel();
		pessoaModel.setNome(pessoa.getNome());
		pessoaModel.setIdade(pessoa.getIdade());
		pessoaModel.setDocCpf(pessoa.getDocCpf());

		return new ResponseEntity<>(services.ruleDroolsPessoa(pessoaModel), HttpStatus.OK);

	}

	@ApiOperation(value = "Drools rule CarroModel")
	@PostMapping(path = "/consulta-carro/{modelo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarroModel> drools(@PathVariable String modelo) {
		
		CarroModel carroModel = new CarroModel();
		carroModel.setModelo(modelo);

		return new ResponseEntity<>(services.ruleDroolsCarro(carroModel), HttpStatus.OK);

	}
}
