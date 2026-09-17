package br.com.mercado.controller;

import br.com.mercado.model.Usuario;

public class LoginController {
    public Usuario autenticar(String login, String senha){
        if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            return null;
        }
        if (login.equals("admin") && senha.equals("admin123")){
            Usuario usuario = new Usuario();
            usuario.setId(1L);
            usuario.setNome("Gerente");
            usuario.setLogin("admin");
            usuario.setSenha("admin123");
            usuario.setCargo("Gerente");
            return usuario;
        }
        if (login.equals("caixa") && senha.equals("caixa123")){
            Usuario usuario = new Usuario();
            usuario.setId(2L);
            usuario.setNome("Operador caixa");
            usuario.setLogin("caixa1");
            usuario.setSenha("caixa123");
            usuario.setCargo("Operador caixa");
            return usuario;
        }

        return null;
    }
}
