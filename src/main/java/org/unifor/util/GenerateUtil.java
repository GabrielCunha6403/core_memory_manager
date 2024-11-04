package org.unifor.util;

import org.unifor.dto.PaginaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateUtil {


    public static List<PaginaDTO> gerarListaDeValores() {
        List<PaginaDTO> valores = new ArrayList<>();

        Random random = new Random();
        int numeroAleatorio = random.nextInt(3) + 1;

        int qtdDeValores = random.nextInt(101) + 1;

        if(numeroAleatorio == 1) {
           for(int i = 0; i < qtdDeValores; i++) {
               valores.add(new PaginaDTO(
                       0,
                       "",
                       0,
                        String.valueOf( random.nextInt(100))
               ));
           }

        } else if(numeroAleatorio == 2) {
            for(int i = 0; i < qtdDeValores; i++) {
                char letra = (char) (random.nextInt(26) + 'a');
                valores.add(new PaginaDTO(
                        0,
                        "",
                        0,
                        String.valueOf( letra ).toUpperCase()
                ));
            }
        } else {
            for(int i = 0; i < qtdDeValores; i++) {
                valores.add(new PaginaDTO(
                        0,
                        "",
                        0,
                        random.nextBoolean() ? String.valueOf(random.nextInt(10)) : String.valueOf((char) random.nextInt(26) + 'a').toUpperCase()
                ));
            }
        }

        return  valores;
    }

    public static List<String> gerarListaDeLetras() {
        List<String> alfabeto = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alfabeto.add(String.valueOf(c));
        }
        return alfabeto;
    }

    public static List<String>  gerarListaDeNumeros (int rangeMin, int rangeMax) {
        List<String> numeros = new ArrayList<>();
        for (int i = rangeMin; i <= rangeMax; i++) {
            numeros.add(String.valueOf(i));
        }
        return numeros;
    }

}
