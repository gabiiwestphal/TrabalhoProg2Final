/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.pessoa;

import DAO.AmigoDAO;
import DAO.CaixaDAO;
import DAO.DonoDAO;
import DAO.EmprestimoDAO;
import DAO.RevistaDAO;
import Exception.EmprestimoException;
import Model.Amigo;
import Model.Caixa;
import Model.Dono;
import Model.Emprestimo;
import Model.Revista;
import View.Pessoa.EmprestarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ControllerEmprestar {

    private EmprestarView ev;

    public ControllerEmprestar(EmprestarView ev) {
        this.ev = ev;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        ev.adicionarAcaoBotaoEmprestar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Emprestimo emprestimo = recuperarEmprestimo();
                    EmprestimoDAO.salvarEmprestimo(emprestimo);
                    
                    Revista revista = ev.getRevista();
                    
                    Caixa caixa = CaixaDAO.recuperarCaixaRevista(revista);
                    
                    CaixaDAO.atualizarQtdRevistaCaixa(caixa, "-");
                    
                    RevistaDAO.removerRevistaDaCaixa(revista);
                    
                    
                    ev.exibirMensagem("Empréstimo realizado com sucesso! " + emprestimo.toString());
                    ev.limparTela();
                } catch (EmprestimoException ex) {
                    ev.exibirMensagem(ex.getMessage());
                }
            }
        });
    }

    private Emprestimo recuperarEmprestimo() throws EmprestimoException {
        LocalDate dataEmprestimo = getDataHora();
        Revista revista = ev.getRevista();
        Dono dono = ev.getDono();
        Amigo amigo = ev.getAmigo();

        Emprestimo emprestimo = Emprestimo.emprestar(dataEmprestimo, dono, amigo, revista);

        if (revista == null) {
            throw new EmprestimoException("Nenhuma revista selecionada");
        }

        if (dono == null) {
            throw new EmprestimoException("Nenhum dono selecionado");
        }

        if (amigo == null) {
            throw new EmprestimoException("Nenhum amigo selecionado");
        }

        return emprestimo;
    }

    private LocalDate getDataHora() throws EmprestimoException {
        String diaMesAno = ev.getData();
        String data = diaMesAno;

        try {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataEmprestimo = LocalDate.parse(data, formatoData);
            return dataEmprestimo;
        } catch (DateTimeParseException e) {
            throw new EmprestimoException("Data inválida");
        }
    }

    private void popularComboBox() {

        List<Amigo> amigos = new ArrayList<>();
        List<Dono> donos = new ArrayList<>();
        List<Revista> revistas = new ArrayList<>();

        for (Amigo a : AmigoDAO.recuperarTodosAmigos()) {
            amigos.add(a);
        }

        for (Dono d : DonoDAO.recuperarTodosDonos()) {
            donos.add(d);
        }

        for (Revista r : RevistaDAO.recuperarTodasRevistas()) {
            revistas.add(r);
        }

        ev.popularComboBoxAmigo(amigos);
        ev.popularComboBoxDono(donos);
        ev.popularComboBoxRevista(revistas);
    }

    public void exibirTela() {
        ev.exibir();
    }
}
