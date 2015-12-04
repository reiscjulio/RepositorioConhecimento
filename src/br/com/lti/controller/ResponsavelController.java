package br.com.lti.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.lti.dao.JPAResponsavelDAO;
import br.com.lti.modelo.Responsavel;

@ManagedBean
@SessionScoped
public class ResponsavelController {

	private Responsavel responsavel;
	private DataModel listaResponsavel;
	 
	public DataModel getListarLivros() {
		List<Responsavel> lista = new JPAResponsavelDAO().lista();
		listaResponsavel = new ListDataModel(lista);
		return listaResponsavel;
	}
	
	public Responsavel getLivro() {
		return responsavel;
	}
	
	public void setLivro(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public String prepararAdicionarResponsavel(){
		responsavel = new Responsavel();
		return "gerenciarLivro";
	}
	
	public String prepararAlterarResponsavel(){
		responsavel = (Responsavel)(listaResponsavel.getRowData());
		return "gerenciarLivro";
	}
	
	public String removerResponsavel(){
		Responsavel responsavelTemp = (Responsavel)(listaResponsavel.getRowData());
		JPAResponsavelDAO dao = new JPAResponsavelDAO();
		dao.remove(responsavelTemp);
		return "index";
	}
	
	public String adicionarResponsavel(){
		JPAResponsavelDAO dao = new JPAResponsavelDAO();
		dao.adiciona(responsavel);
		return "index";
	}
	
	public String alterarResponsavel(){
		JPAResponsavelDAO dao = new JPAResponsavelDAO();
		dao.altera(responsavel);
		return "index";
	}		
	
}
