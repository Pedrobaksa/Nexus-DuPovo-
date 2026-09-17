package br.com.nexus.dupovo.erp.repository;

import br.com.nexus.dupovo.erp.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();
    private static Long contadorId = 1L;

    public void salvar(Funcionario f) {
        if (f.getId() == null) {
            f.setId(contadorId++);
            listaFuncionarios.add(f);
        } else {
            for (int i = 0; i < listaFuncionarios.size(); i++) {
                if (listaFuncionarios.get(i).getId().equals(f.getId())) {
                    listaFuncionarios.set(i, f);
                    break;
                }
            }
        }
    }

    public List<Funcionario> listarTodos() {
        return listaFuncionarios;
    }

    public void deletar(Long id) {
        listaFuncionarios.removeIf(f -> f.getId().equals(id));
    }
}