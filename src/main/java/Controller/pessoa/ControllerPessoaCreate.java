/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.pessoa;

import DAO.AmigoDAO;
import DAO.DonoDAO;
import Exception.CampoVazioException;
import Exception.CpfExistenteException;
import Model.Amigo;
import Model.Dono;
import Model.Pessoa;
import View.Pessoa.PessoaCreateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPessoaCreate {
    
    private Pessoa pessoa;
    private PessoaCreateView pcv;
    
    public ControllerPessoaCreate(PessoaCreateView pcv){
        this.pcv = pcv;
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        pcv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = pcv.getNome();
                String cpf = pcv.getCPF();
                String endereco = pcv.getEndereco();
                String telefone = pcv.getTelefone();
                
                 if (!pcv.getRbDono() && !pcv.getRbAmigo()) {
                    pcv.exibirMensagem("Por favor, selecione dono ou amigo.");
                    return;
                }

                try {
                    if (pcv.getRbDono()) {
                        pessoa = new Dono();
                    } else if (pcv.getRbAmigo()) {
                        pessoa = new Amigo();
                    } else {
                        pessoa = null;
                    }
                    
                    pessoa.setNome(nome);
                    pessoa.setCpf(cpf);
                    pessoa.setEndereco(endereco);
                    pessoa.setTelefone(telefone);
                    
                    adicionarPessoa(pessoa);
                    pcv.exibirMensagem("Pessoa cadastrada com sucesso!");
                    pcv.limparTela();
                    
                    } catch (CampoVazioException ex) {
                    pcv.exibirMensagem("Campo em branco.");
                } catch (CpfExistenteException ex) {
                    pcv.exibirMensagem("Já existe uma pessoa com esse cpf");
          }
            }
        });
    }

      
      private void adicionarPessoa(Pessoa p) {
        if(p instanceof Amigo a) {
            AmigoDAO.salvarAmigo(a);
        } else if(p instanceof Dono don) {
            DonoDAO.salvarDono(don);
        }
    }

    public void exibirTela() {
        pcv.exibir();
    }
}
