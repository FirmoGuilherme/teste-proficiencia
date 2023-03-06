public class JogoDaVelha_Mapa {

    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) {
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpaMapa() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                mapa[linha][coluna] = ' ';
            }
        }

    }

    public void desenha(int jogada) {
        System.out.println("\n------------- .. jogada: " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");

    }

    public boolean jogar(int l, int c, char jogador) {
        if (mapa[l][c] == ' ') {
            mapa[l][c] = jogador;
            return true;
        } else {
            return false;
        }
    }

    public boolean ganhou(char jogador) {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (mapa[0][coluna] == jogador && mapa[1][coluna] == jogador && mapa[2][coluna] == jogador) {
                return true;
            }
        }
        for (int linha = 0; linha < 3; linha++) {
            if (mapa[linha][0] == jogador && mapa[linha][1] == jogador && mapa[linha][2] == jogador) {
                return true;
            }
        }
        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
            return true;
        }
        if (mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador) {
            return true;
        }
        return false;

    }

}