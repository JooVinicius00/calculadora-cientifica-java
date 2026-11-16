package ExercicioCalculadora;

public abstract class Calculadora {
    private double valor1;
    private double valor2;
    private double resultado;

    public Calculadora() { this(0, 0, 0); }
    public Calculadora(double valor1, double valor2, double resultado) {
        ler(valor1, valor2);
        setResultado(resultado);
    }
    public double getValor1() { return valor1; }
    public double getValor2() { return valor2; }
    public double getResultado() { return resultado; }
    public void setValor1(double valor) { validar(valor); valor1 = valor; }
    public void setValor2(double valor) { validar(valor); valor2 = valor; }
    public void setResultado(double valor) { validar(valor); resultado = valor; }
    protected void validar(double valor) {
        if (!Double.isFinite(valor)) throw new IllegalArgumentException("Valor ou resultado inválido.");
    }
    public void ler(double primeiro, double segundo) {
        setValor1(primeiro);
        setValor2(segundo);
    }
    public double somar() { setResultado(valor1 + valor2); return resultado; }
    public double subtrair() { setResultado(valor1 - valor2); return resultado; }
    public double multiplicar() { setResultado(valor1 * valor2); return resultado; }
    public double dividir() {
        if (valor2 == 0) throw new IllegalArgumentException("Não é possível dividir por zero.");
        setResultado(valor1 / valor2);
        return resultado;
    }
    public abstract double potencia(double expoente);
    public abstract double raizQuadrada();
}
