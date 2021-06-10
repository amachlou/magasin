package ma.dwm.magasin.views.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.dwm.magasin.entities.Client;
import ma.dwm.magasin.repositories.IClientRepository;
import ma.dwm.magasin.repositories.IProduitRepository;
import ma.dwm.magasin.views.application.ListeClients;

public class ClientHandler {
	
	ListeClients listClient=null;
	@Autowired
	IClientRepository cdao;
	@Autowired
	IProduitRepository pdao;

	public ClientHandler(ListeClients listClient) {
		this.listClient=listClient;
	}
	
	public void updateListClients() {
		
		
		List<Client> list=cdao.findAll();
		listClient.clientObservableList.addAll(list);

	}
	
	
	public void addClick() {
		
		String nom=listClient.NomInput.getText();
		String prenom=listClient.PrenomInput.getText();
		String tel=listClient.TelInput.getText();
		String email=listClient.EmailInput.getText();
		Client c=new Client(null, nom, prenom, tel, email, null);
		cdao.save(c);
		
	}
	
	public void remove() {
	
	Client p = listClient.clientList.getSelectionModel().getSelectedItem();
	long id=p.getId_client();
	cdao.deleteById(id);
	}

	public void selectItem() {
		Client c = listClient.clientList.getSelectionModel().getSelectedItem();
		long id=c.getId_client();
		String nom=c.getNom();
		String prenom=c.getPrenom();
		String tel=c.getTelephone();
		String email=c.getEmail();
		
		listClient.lblIdClient.setText(id+"");
		listClient.NomInput.setText(nom);
		listClient.PrenomInput.setText(prenom);
		listClient.TelInput.setText(tel);
		listClient.EmailInput.setText(email);
		
	}
	public void modify() {
		
		String id=listClient.lblIdClient.getText();
		String nom=listClient.NomInput.getText();
		String prenom=listClient.PrenomInput.getText();
		String tel=listClient.TelInput.getText();
		String email=listClient.EmailInput.getText();
		Client c=new Client(null, nom, prenom, tel, email, null);
//		cdao.save(cdao.findById(new Long(id))); TODO ToCompleyte
		
	}
	
	public void search() {
		
		String nomOrPresnom=listClient.rechercheInput.getText();
		List<Client> list=cdao.findByNomContains(nomOrPresnom); // TODO Changed from designation to nomOrPresnom, from c
		listClient.clientObservableList.addAll(list);
		
	}
	

}
