import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

/**
 * esta classe cria e exibe a interface grafica do usuario {gui] para o gerador de senhas
 * utiliza a biblioteca javafx para construir a janela e seus componentes
 */
public class ProjetoGeradorDeSenhasGUI extends Application {

    /**
     * o metodo principal para todas as aplicacoes javafx.
     * e chamado apos o metodo init() e e aqui que a cena da gui e construida
     *
     * @param palco o container principal, conhecido como o "stage" ou palco
     */
    @Override
    public void start(Stage palco) {
        palco.setTitle("gerador de senhas");

        Label labelTamanhoSenha = new Label("tamanho da senha:");
        TextField campoTamanhoSenha = new TextField();
        campoTamanhoSenha.setText("12");

        Label labelSenhaGerada = new Label("senha gerada:");
        TextField campoSenhaGerada = new TextField();
        campoSenhaGerada.setEditable(false);
        campoSenhaGerada.getStyleClass().add("campo-senha-gerada");

        Button botaoGerar = new Button("gerar senha");
        botaoGerar.setOnAction(e -> {
            try {
                int tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText());
                String senha = ProjetoGeradorDeSenhas.gerarSenha(tamanhoSenha);
                campoSenhaGerada.setText(senha);
            } catch (NumberFormatException ex) {
                campoSenhaGerada.setText("tamanho invalido!");
            }
        });

        VBox vBox = new VBox(labelTamanhoSenha, campoTamanhoSenha, botaoGerar, labelSenhaGerada, campoSenhaGerada);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(15));

        Scene cena = new Scene(vBox, 320, 220);
        cena.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        palco.setScene(cena);
        palco.show();
    }

    /**
     * o ponto de entrada principal da aplicacao.
     * este metodo lanca a aplicacao javafx.
     *
     * @param args argumentos da linha de comando (passados para o metodo launch).
     */
    public static void main(String[] args) {
        launch(args);
    }
}