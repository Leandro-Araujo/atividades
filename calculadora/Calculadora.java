package io.github.leandro.calendario;

import java.util.Calendar;
import java.util.Scanner;

/*
    Exercicio Calendario
    Data 16/05/2024
    Autor Leandro
    Descricao: Calendario Anual
 */
public class Calendario {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String[] nomeMes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int ano = anoSelecionado();
        int mes = 0;

        while(mes < 12){
            c.set(ano, mes, 1);
            System.out.println(nomeMes[mes]);
            System.out.println("  D  S  T  Q  Q  S  S");
            int diaMes = 1;
            int linha = 0;
            int diaSemanaMesComeca = c.getTime().getDay();

            while (diaMes <= c.getActualMaximum(Calendar.DAY_OF_MONTH)){
                if (linha == 0 && diaMes == 1){
                    for (int i = 0; i < diaSemanaMesComeca; i++) {
                        System.out.print("   ");
                    }
                    if (diaMes >= 10) System.out.print(" " + diaMes);
                    else System.out.print("  " + diaMes);
                    diaSemanaMesComeca++;
                }
                else if (diaSemanaMesComeca > 6){
                    System.out.println();
                    linha++;
                    diaSemanaMesComeca = 0;
                    if (diaMes >= 10) System.out.print(" " + diaMes);
                    else System.out.print("  " + diaMes);
                    diaSemanaMesComeca++;
                }
                else {
                    if (diaMes >= 10) System.out.print(" " + diaMes);
                    else System.out.print("  "+ diaMes);
                    diaSemanaMesComeca++;
                }
                diaMes++;
            }
            mes++;
            System.out.println();
        }
    }

    private static int anoSelecionado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor digite um ano: ");
        int anoCalendario = sc.nextInt();
        sc.close();
        return anoCalendario;
    }
}
