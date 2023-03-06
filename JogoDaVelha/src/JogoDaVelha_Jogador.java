import java.util.Scanner;

public class JogoDaVelha_Jogador {
    private JogoDaVelha_Mapa mapa;
    private char letra = 'X';

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean joga(Scanner teclado) {
        System.out.println("Jogador ..");

        boolean posicaoValida = false;

        while (!posicaoValida) {
            System.out.println("linha: ");
            int linha = teclado.nextInt();
            System.out.println("coluna: ");
            int coluna = teclado.nextInt();

            if (linha > 2 || linha < 0 || coluna > 2 || coluna < 0) {
                System.out.println("\nEntrada fora dos limites do mapa!\n");
            } else {
                posicaoValida = mapa.jogar(linha, coluna, letra);
                if (!posicaoValida) {
                    System.out.println("A posição já está ocupada!");
                }
            }
        }
        boolean venceu = mapa.ganhou(letra);
        if (venceu) {
            System.out.println("Jogador GANHOU!");
            return true;
        }
        return false;
    }
}