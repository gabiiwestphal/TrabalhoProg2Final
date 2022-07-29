/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.caixa;

import DAO.CaixaDAO;
import DAO.RevistaDAO;
import Exception.CampoVazioException;
import Exception.CodigoDeBarraExistenteException;
import Model.Caixa;
import Model.Revista;
import View.caixa.AddRevistaCaixaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ControllerAddRevistaCaixa {
       
     private AddRevistaCaixaView arcv;

    public ControllerAddRevistaCaixa(AddRevistaCaixaView arcv) {
        this.arcv = arcv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        arcv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                    Revista tempRevista = arcv.getRevista();
                    Caixa tempCaixa = arcv.getCaixa();

                    salvarRevistaNaCaixa(tempCaixa, tempRevista);
                    arcv.exibirMensagem("Revista cadastrada na caixa com sucesso!");
              
            }
        });
    }


    private void salvarRevistaNaCaixa(Caixa c, Revista r) {
        //Atualizar chave estrangeira da revista
        RevistaDAO.colocarRevistaCaixa(r, c);
        //Atualizar qtdRevistas da caixa
        CaixaDAO.atualizarQtdRevistaCaixa(c, "+");
        
        limparComboBox();
        popularComboBox();
    }

    private void popularComboBox() {

        List<Revista> revistas = new ArrayList<>();
        List<Caixa> caixas = new ArrayList<>();

        for (Revista r : RevistaDAO.recuperarTodasRevistas()) {
            revistas.add(r);
        }

        for (Caixa c : CaixaDAO.recuperarTodasCaixas()) {
            caixas.add(c);
        }
   
        arcv.popularComboBoxRevista(revistas);
        arcv.popularComboBoxCaixa(caixas);

    }
    
    public void limparComboBox() {
        arcv.limparComboBox();
    }

    public void exibirTela() {
        arcv.exibir();
    }
}
