import java.util.Scanner;

public class JogoDaVelha {
    private static JogoDaVelha_Mapa jogoMapa;
    private static JogoDaVelha_PC jogoPC;
    private static JogoDaVelha_Jogador jogoJogador;

    private static void jogar(Scanner teclado) {
        jogoMapa.limpaMapa();
        jogoMapa.desenha(0);

        int jogadas = 0;
        int quemComeca = jogoMapa.sortear(0, 2);
        boolean JogadorComeca = quemComeca == 0;
        boolean venceu = false;

        while (!venceu && jogadas < 9) {
            venceu = JogadorComeca ? jogoJogador.joga(teclado) : jogoPC.joga();
            jogadas++;
            if (jogadas == 9 && !venceu) {
                System.out.println("EMPATOU!");
            }
            jogoMapa.desenha(jogadas);
            JogadorComeca = !JogadorComeca;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        jogoMapa = new JogoDaVelha_Mapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

        jogar(teclado);

        System.out.println("Deseja jogar novamente (s/n)?");
        char resposta = teclado.next().toLowerCase().charAt(0);
        if (resposta == 's') {
            jogar(teclado);
        }
        teclado.close();
    }
}