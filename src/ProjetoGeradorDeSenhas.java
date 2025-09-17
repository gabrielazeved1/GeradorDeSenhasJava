import java.security.SecureRandom;
import java.util.Scanner;

/**
 * esta classe contem a logica para gerar senhas aleatorias.
 * inclui tambem um metodo main para execucao via linha de comando.
 */
public class ProjetoGeradorDeSenhas {

    /**
     * uma string constante com todos os caracteres permitidos na senha.
     * inclui letras minusculas, maiusculas, numeros e simbolos.
     */
    private static final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()_+-=[]|,./?><";

    /**
     * gera uma senha aleatoria com base no comprimento especificado.
     *
     * @param comprimento o numero de caracteres que a senha deve ter.
     * @return uma string contendo a senha gerada aleatoriamente.
     */
    public static String gerarSenha(int comprimento) {
        SecureRandom geradorDeNumeroAleatorio = new SecureRandom();
        StringBuilder senha = new StringBuilder(comprimento);

        for (int i = 0; i < comprimento; i++) {
            int indice = geradorDeNumeroAleatorio.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(indice));
        }

        return senha.toString();
    }

    /**
     * ponto de entrada para a versao de linha de comando do gerador de senhas.
     * solicita ao usuario o comprimento da senha e a exibe no console.
     *
     * @param args argumentos da linha de comando (nao utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("digite o comprimento da senha que deseja: ");
        int comprimentoSenha = scanner.nextInt();
        
        String senha = gerarSenha(comprimentoSenha);
        System.out.println("senha gerada: " + senha);
    }
}