package pong.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.valeurs.RendezVous;
import pong.commun.valeurs.Usager;
import pong.frontal.vues.VueFileAttente;

public class ModeleFileAttente implements Model, Watch, WriteObjectGraph {

	private long prochainIdRendezVous = 1;
	private List<RendezVous> lesRendezVous = new ArrayList<>();

	public ModeleFileAttente() {
		// n�cessaire pour cr�er un objet java d'un fichier .json
	}

	public long getProchainIdRendezVous() {
		return prochainIdRendezVous;
	}

	public void setProchainIdRendezVous(long prochainIdRendezVous) {
		this.prochainIdRendezVous = prochainIdRendezVous;
	}

	public List<RendezVous> getLesRendezVous() {
		return lesRendezVous;
	}

	public void setLesRendezVous(List<RendezVous> lesRendezVous) {
		this.lesRendezVous = lesRendezVous;
	}

	public void afficherSur(VueFileAttente vueFileAttente) {

		vueFileAttente.afficherRendezVousEnTexte(this.toString());
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroRendezVous = 1;

		for (RendezVous rendezVous : lesRendezVous) {

			builder.append(numeroRendezVous);
			builder.append(". ");
			builder.append(rendezVous.toString());
			builder.append("\n");

			numeroRendezVous++;
		}

		return builder.toString();
	}

	public void sInscrire(MsgAjouterRendezVous msg) {

		Usager premierJoueur = msg.getPremierJoueur();
	}

	public void inscrire(Usager premierJoueur) {

		String idRendezVous = genererIdRendezVous();

		RendezVous rendezVous = new RendezVous(idRendezVous, premierJoueur);

		lesRendezVous.add(rendezVous);
	}

	private String genererIdRendezVous() {
		String idRendezVous = String.valueOf(prochainIdRendezVous);
		prochainIdRendezVous++;

		return idRendezVous;
	}

}
