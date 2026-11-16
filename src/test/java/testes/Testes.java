package testes;
public class Testes {
    private static int verificacoes;
    private static void conferir(boolean valor) {
        verificacoes++;
        if (!valor) throw new AssertionError("Falha na verificação " + verificacoes);
    }
    private static void perto(double esperado, double valor) {
        conferir(Math.abs(esperado - valor) < 0.000001);
    }
    private static void rejeitar(Runnable acao) {
        verificacoes++;
        try { acao.run(); } catch (IllegalArgumentException erro) { return; }
        throw new AssertionError("Entrada inválida foi aceita.");
    }
    public static void main(String[] args) throws Exception {

        ExercicioCalculadora.CalculadoraCientifica calculadora = new ExercicioCalculadora.CalculadoraCientifica();
        calculadora.ler(12, 3); perto(15, calculadora.somar()); perto(9, calculadora.subtrair());
        perto(36, calculadora.multiplicar()); perto(4, calculadora.dividir());
        calculadora.ler(2, 3); perto(8, calculadora.potencia(3));
        calculadora.ler(81, 0); perto(9, calculadora.raizQuadrada());
        rejeitar(() -> calculadora.dividir());
        calculadora.ler(-4, 0); rejeitar(() -> calculadora.raizQuadrada());
        rejeitar(() -> calculadora.setValor1(Double.NaN));

        System.out.println("OK: " + verificacoes + " verificações.");
    }
}
