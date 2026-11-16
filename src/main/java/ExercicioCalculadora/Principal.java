package ExercicioCalculadora;

import javax.swing.JOptionPane;
import java.util.Locale;

public class Principal {
    private static Double numero(String mensagem) {
        String entrada = JOptionPane.showInputDialog(null, mensagem, "Calculadora", JOptionPane.QUESTION_MESSAGE);
        if (entrada == null) return null;
        double valor = Double.parseDouble(entrada.trim().replace(',', '.'));
        if (!Double.isFinite(valor)) throw new IllegalArgumentException("Informe um número finito.");
        return valor;
    }
    public static void main(String[] args) {
        CalculadoraCientifica calculadora = new CalculadoraCientifica();
        while (true) {
            String entrada = JOptionPane.showInputDialog("1 - Somar\n2 - Subtrair\n3 - Dividir\n4 - Multiplicar\n5 - Potência\n6 - Raiz quadrada\n0 - Sair");
            if (entrada == null) return;
            try {
                int opcao = Integer.parseInt(entrada.trim());
                if (opcao == 0) {
                    if (JOptionPane.showConfirmDialog(null, "Deseja encerrar?", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) return;
                    continue;
                }
                if (opcao < 1 || opcao > 6) throw new IllegalArgumentException("Opção inválida.");
                Double primeiro = numero(opcao == 5 ? "Base:" : "Primeiro número:");
                if (primeiro == null) continue;
                Double segundo = opcao == 6 ? Double.valueOf(0) : numero(opcao == 5 ? "Expoente:" : "Segundo número:");
                if (segundo == null) continue;
                calculadora.ler(primeiro, segundo);
                switch (opcao) {
                    case 1: calculadora.somar(); break;
                    case 2: calculadora.subtrair(); break;
                    case 3: calculadora.dividir(); break;
                    case 4: calculadora.multiplicar(); break;
                    case 5: calculadora.potencia(segundo); break;
                    case 6: calculadora.raizQuadrada(); break;
                    default: break;
                }
                JOptionPane.showMessageDialog(null, String.format(new Locale("pt", "BR"), "Resultado: %.6f", calculadora.getResultado()));
            } catch (IllegalArgumentException erro) {
                JOptionPane.showMessageDialog(null, "Entrada ou operação inválida. " + erro.getMessage());
            }
        }
    }
}
