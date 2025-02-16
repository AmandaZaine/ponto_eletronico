package com.amandazaine.pontoeletronico.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    public PasswordUtils() {
    }

    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }

        //Gerando hash com o BCrypt
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }
}
