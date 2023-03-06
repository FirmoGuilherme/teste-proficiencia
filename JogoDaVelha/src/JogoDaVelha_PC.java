public class JogoDaVelha_PC {
    private JogoDaVelha_Mapa mapa;
    private char letra = 'O';

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean joga() {
        int linha = 0;
        int coluna = 0;

        do {
            linha = mapa.sortear(0, 3);
            coluna = mapa.sortear(0, 3);
        } while (!mapa.jogar(linha, coluna, letra));

        System.out.printf("PC[%d, %d]\n", linha, coluna);
        boolean venceu = mapa.ganhou(letra);

        if (venceu) {
            System.out.println("... PC GANHOU!");
            return true;
        }
        return false;
    }
}