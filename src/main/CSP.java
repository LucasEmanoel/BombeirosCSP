package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSP {
	private List<Alocacao> variaveis;
	private Map<Alocacao, List<Pessoa>> dominio;
	private Map<Alocacao, List<Pessoa>> restricao;
	
	public HashMap<Alocacao, Pessoa> search() {
		HashMap<Alocacao, Pessoa> atribuicao = new HashMap<>();
		return this.recursiveBacktracking(atribuicao);
	}
	
	public HashMap<Alocacao, Pessoa> recursiveBacktracking(HashMap<Alocacao, Pessoa> atribuicao) {
		if(checkCompleteAtribuition(this, atribuicao)) {
			return atribuicao;
		}
		
		Alocacao variavel = selecionarVariavelNaoAtribuida(this, atribuicao);
		
		for (Pessoa valor : this.valoresOrdemDominio(variavel, this)) {
			if(isValidAssignment(valor, atribuicao)) {
				atribuicao.put(variavel, valor);
				valor.incrementAssignedCount();
				//remover do dominio se valor >= limite
				
				if(valor.getAssignedCount() >= valor.getServicesQtd()) {
					this.removePessoadoDominio(valor);
				}
				
				if(valorEhConsistenteAtribuicao(this, atribuicao)) {
					HashMap<Alocacao, Pessoa> res = recursiveBacktracking(atribuicao);
					
					if(res!=null) {
						return res;
					}
				}
				
				atribuicao.remove(variavel);
				valor.decrementAssignedCount();
				this.addPessoadoDominio(valor);

			}
		}
		
		return null;
	}
	
	private void removePessoadoDominio(Pessoa valor) {
		for (Map.Entry<Alocacao, List<Pessoa>> entry : dominio.entrySet()) {
		    List<Pessoa> pessoasList = entry.getValue();
		    
		    pessoasList.remove(valor);
		}
	}
	
	private void addPessoadoDominio(Pessoa valor) {
		for (Map.Entry<Alocacao, List<Pessoa>> entry : dominio.entrySet()) {
		    List<Pessoa> pessoasList = entry.getValue();
		    
		    pessoasList.add(valor);
		}
	}
	
	private boolean isValidAssignment(Pessoa p, HashMap<Alocacao, Pessoa> atribuicao) {
        if (p.getAssignedCount() >= p.getServicesQtd()) {
            return false; 
        }
        
        return true;
    }
	
	//verificar se a pessoa que to tentando inserir no local esta disponivel, basicamente verificar o assingn
	private boolean valorEhConsistenteAtribuicao(CSP psr, HashMap<Alocacao, Pessoa> atribuicao) {
		
		for (Map.Entry<Alocacao, List<Pessoa>> entry : restricao.entrySet()) {
			Alocacao alocacao = entry.getKey();
	        List<Pessoa> pessoasRestritas = entry.getValue();
	        
	        if (atribuicao.containsKey(alocacao)) {
	            Pessoa pessoaAtribuida = atribuicao.get(alocacao);

	            // Verifica se a pessoa atribuída está na lista de restrições
	            if (pessoasRestritas.contains(pessoaAtribuida)) {
	                return false;
	            }
	        }
		}
		return true;
		
	}
	
	private List<Pessoa> valoresOrdemDominio(Alocacao variavel, CSP psr) {
		// trazer a lista de pessoas para a alocacao
		if(psr.dominio.containsKey(variavel)) {
			return psr.dominio.get(variavel);
		}
		//List<Pessoa> pessoas = psr.dominio.get(variavel);
		
		return null;
	}
	
	//retorna a variavel que ainda nao foi atribuida
	private Alocacao selecionarVariavelNaoAtribuida(CSP psr, HashMap<Alocacao, Pessoa> atribuicao) {
		for (Alocacao a: psr.variaveis) {
			Pessoa temp = atribuicao.get(a);
			
			if(temp == null) return a;
		}
		
		return null;
	}
	
	//verifica se para cada variavel existe uma atribuição feita
	private boolean checkCompleteAtribuition(CSP psr, HashMap<Alocacao, Pessoa> atribuicao) {
		
		for (Alocacao a: psr.variaveis) {
			Pessoa temp = atribuicao.get(a);
			
			if(temp == null) return false;
		}
		
		return true;
	}
	
	////

	CSP(){
		this.variaveis = new ArrayList<>();
		this.dominio = new HashMap<>();
		this.restricao = new HashMap<>();
	}
	
	public List<Alocacao> getVariaveis() {
		return variaveis;
	}


	public void setVariaveis(List<Alocacao> variaveis) {
		this.variaveis = variaveis;
	}

	public Map<Alocacao, List<Pessoa>> getDominio() {
		return dominio;
	}

	public void setDominio(Map<Alocacao, List<Pessoa>> dominio) {
		this.dominio = dominio;
	}

	public Map<Alocacao, List<Pessoa>> getRestricao() {
		return restricao;
	}

	public void setRestricao(Map<Alocacao, List<Pessoa>> restricao) {
		this.restricao = restricao;
	}

	public void addVar(Alocacao a) {
		variaveis.add(a);
	}
	
	public void addDom(Alocacao a, List<Pessoa> lp) {
		dominio.put(a, lp);
	}
	
	public void addRes(Alocacao a, List<Pessoa> rest) {
		restricao.put(a, rest);
	}
}
