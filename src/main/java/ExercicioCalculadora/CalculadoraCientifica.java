package ExercicioCalculadora;

public class CalculadoraCientifica extends Calculadora {
    public CalculadoraCientifica() { super(); }
    public CalculadoraCientifica(double primeiro, double segundo, double resultado) {
        super(primeiro, segundo, resultado);
    }
    @Override
    public double potencia(double expoente) {
        validar(expoente);
        setResultado(Math.pow(getValor1(), expoente));
        return getResultado();
    }
    @Override
    public double raizQuadrada() {
        if (getValor1() < 0) throw new IllegalArgumentException("A raiz real exige um número não negativo.");
        setResultado(Math.sqrt(getValor1()));
        return getResultado();
    }
}
