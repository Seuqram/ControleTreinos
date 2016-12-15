package controle;

import javax.swing.JOptionPane;

import visao.PanelCadastroDeAluno;
import visao.PanelCadastroDeAvaliacao;
import visao.PanelCadastroDeExercicio;
import visao.PanelGenerico;
import visao.PanelMontarTreino;
import visao.PanelPrincipal;
import visao.PanelVisualizacaoDeAvaliacao;
import visao.TelaPrincipal;

public class ControlePrincipal {
	PanelPrincipal panelPrincipal = new PanelPrincipal(
			(int)TelaPrincipal.getWidth(),
			(int)TelaPrincipal.getHeight(), 
			0.5, 
			0.8);
	
	public int getNivelDeAcesso(){
		ControleSessao controleSessao = new ControleSessao();
		return controleSessao.getNivelDeAcesso();
	}
	
	public void setVisibilidade(boolean visibilidade)
	{
		panelPrincipal.setVisible(visibilidade);
	}
	
	public void inicializaTelaPrincipal()
	{
		panelPrincipal.setInterface();
		TelaPrincipal.exibePanel(panelPrincipal, panelPrincipal.getPorcentagemWidth(), panelPrincipal.getPorcentagemHeight());
		TelaPrincipal.setLogoutButton(true);
	}
	
	public void abrePanel(String panel){
		PanelGenerico a = new PanelGenerico();
		int i = (int)TelaPrincipal.getWidth();
		int j = (int)TelaPrincipal.getHeight();
		double d = 0.7;
		double e = 0.8;
		if(panel.equals("cadastroDeAluno")){
			a = new PanelCadastroDeAluno(i, j, d, e);
		}else{
			if (panel.equals("cadastroDeAvaliacao")){
				a = new PanelCadastroDeAvaliacao(i, j, d, e);
			}else{
				if (panel.equals("visualizacaoDeAvaliacao")){
					a = new PanelVisualizacaoDeAvaliacao(i, j, d, e);
				}else{
					if (panel.equals("cadastroDeExercicio")){
						a = new PanelCadastroDeExercicio(i, j, d, e);
					}else{
						if (panel.equals("montarTreino")){
							a = new PanelMontarTreino(i,  j, d, e);
						}
					}
				}
			}
		}
		
		TelaPrincipal.exibePanel(a, a.getPorcentagemWidth(), a.getPorcentagemHeight());
	}
	
	public void carregaBaseDeDados(){
		ControleSessao controleSessao = new ControleSessao();
		controleSessao.carregaBaseDeDados();
	}
	
	public void realizaLogout(){
		ControleLogin controleLogin = new ControleLogin();
		controleLogin.realizaProcedimentosLogout();
	}
}
