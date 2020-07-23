package com.br.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.drools.model.CarroModel;
import com.br.drools.model.PessoaModel;

@Service
public class Services {

	@Autowired
	private KieContainer kieContainer;
	
	public PessoaModel ruleDroolsPessoa(PessoaModel pessoaModel) {
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(pessoaModel);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return pessoaModel;
	}
	
	public CarroModel ruleDroolsCarro(CarroModel carroModel) {
		
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(carroModel);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return carroModel;
	}
}
