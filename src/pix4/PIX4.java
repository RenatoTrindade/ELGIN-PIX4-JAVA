/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pix4;

import com.sun.jna.Native;

/**
 *
 * @author Renato Trindade
 */
public class PIX4 {

    private static InterfacePIX4 pix4;

    static {
        System.loadLibrary("E1_PIX401");
        pix4 = (InterfacePIX4) Native.loadLibrary("E1_PIX401", InterfacePIX4.class);
    }

    /**
     * Método utilizado para estabelecer conexão usb com PIX4.
     *
     * @param porta Parâmetro do tipo cadeia de caracteres que recebe a porta
     * COM em que o PIX4 está conectado, por exemplo: "COM4"
     * @return int - O retorno da função é do tipo inteiro.<br>
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1. <br><br>
     * <b>Código Erro</b> -  <b>Descrição</b><br> 
     * -12&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dispositivo não existe<br>
     * -13&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Permissão Negada<br>
     * -14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Desconhecido<br>
     * -19&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dispositivo Removido Inesperadamente
     */
    public static int AbreConexaoDisplay(String porta) {
        return pix4.AbreConexaoDisplay(porta);
    }

    /**
     * Método utilizado para obter a versão atual do firmware.
     *
     * @return int - O retorno da função é do tipo numérico. A função bem sucedida
     * deve retornar a versao atual do firmware (ex: 13).<br><br> 
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita<br>
     * A função mal sucedida deve retornar -1.
     */
    public static int ObtemVersaoFirmware() {
        return pix4.ObtemVersaoFirmware();
    }

    /**
     * Método utilizado para obter o estado atual da conexão do equipamento.
     *
     * @return boolean - O retorno da função é do tipo boolean.<br>
     * A função bem sucedida deve retornar TRUE.<br>
     * A função mal sucedida deve retornar FALSE.
     */
    public static boolean ObtemConexao() {
        return pix4.ObtemConexao();
    }

    /**
     * Método usado para desconectar o PIX4.
     *
     * @return int - O retorno da função é do tipo numérico.<br> 
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1.
     */
    public static int DesconectarDisplay() {
        return pix4.DesconectarDisplay();
    }

    /**
     * Método utilizado na inicialização e limpeza da tela para novas
     * apresentações.
     *
     * @return int - O retorno da função é do tipo numérico.<br>
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1.<br><br>
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita
     */
    public static int InicializaDisplay() {
        return pix4.InicializaDisplay();
    }

    /**
     * Método usado na reinicialização do Display PIX4, após reinicialização
     * necessário realizar uma nova abertura de conexão.
     *
     * @return int - O retorno da função é do tipo numérico.<br>
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1.<br><br>
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada
     */
    public static int ReinicializaDisplay() {
        return pix4.ReinicializaDisplay();
    }

    /**
     * A resolução máxima do hardware é 320x480, então qualquer imagem acima
     * desta resolução não será visualizado como deveria.
     *
     * @param fileName Define o nome identificador da imagem a ser salva. Ex:<br><br>
     * <b>fileName</b>&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp;<b>filePath</b><br>
     *Imagem Inicial&nbsp;&nbsp;&nbsp;&nbsp;logo.jpg<br> 
     * Imagem 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;p1.jpg<br> 
     * Imagem 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;p3.jpg<br>
     * @param filePath Define o caminho onde se encontra a imagem a ser salva.
     * @param largura Define a largura imagem. (ex. 300)
     * @param altura Define a altura imagem. (ex. 480)
     * @return int - O retorno da função é do tipo numérico.<br> 
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1.<br><br>
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita
     */
    public static int CarregaImagemDisplay(String fileName, String filePath, int largura, int altura) {
        return pix4.CarregaImagemDisplay(fileName, filePath, largura, altura);
    }

    /**
     * Método utilizado para apresentar uma imagem gravada anteriormente usando
     * método CarregaImagemDisplay().
     *
     * @param fileName Define o nome dado ao arquivo quando carregado.
     * @param posY Define a coordenada posição vertical.<br>
     * 0  &gt;= posV &lt;= 480.
     * @param posX Define a coordenada posição horizontal.<br>
     * 0 &gt;= posH &lt;= 300.
     * @param tipo Define o tipo de apresentação.<br><br>
     * <b>Valor</b> - <b>Descrição</b><br>
     * 0&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Apenas mostrar<br>
     * 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mostrar após limpar a tela 
     * @return int - O retorno da função é do tipo numérico.<br> 
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida d eve retornar -1.<br><br> 
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita
     */
    public static int ApresentaImagemDisplay(String fileName, int posY, int posX, int tipo) {
        return pix4.ApresentaImagemDisplay(fileName, posY, posX, tipo);
    }

    /**
     * Método utilizado para apresentar o qrCode na coordenada especificada.
     *
     * @param qrCode Define o valor do QRCode a ser apresentado.
     * @param tamanho Parâmetro do tipo inteiro que define o tamanho do qrCode.15 &gt;= tamanho &lt;= 255. 
     * @param posY Parâmetro do tipo inteiro que define a coordenada posição vertical.<br> 0 &gt;= posH &lt;= 480. 
     * @param posX Parâmetro do tipo inteiro que define a coordenada posição horizontal.<br> 0 &gt;= posV &lt;= 300.    
     * @return int - O retorno da função é do tipo numérico.<br>
     * A função bem sucedida deve retornar 0.<br> 
     * A função mal sucedida deve retornar -1.<br><br> 
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita
     */
    public static int ApresentaQrCode(String qrCode, int tamanho, int posY, int posX) {
        return pix4.ApresentaQrCode(qrCode, tamanho, posY, posX);
    }

    /**
     * Método utilizado para apresentar um texto colorido na coordenada especificada.
     *
     * @param texto Parâmetro do tipo caractere que define o texto a ser apresentado.
     * @param idTexto Parâmetro do tipo numérico que define o id do texto a ser apresentado. 1 &gt;= idTexto &lt;= 19.
     * @param tamanho Parâmetro do tipo numérico que define o tamanho da fonte. 10 &gt;= tamanho &lt;= 50.
     * @param posY Parâmetro do tipo numérico que define a coordenada posição vertical. 0 &gt;= posY &lt;= 480. 
     * @param posX Parâmetro do tipo numérico que define a coordenada posição horizontal. 0 &gt;= posX &lt;= 300.
     * @param hexadecimal Parâmetro do tipo cadeia de caracteres que define a cor da fonte em hexadecimal.
     * @return int - O retorno da função é do tipo numérico.<br>
     * A função bem sucedida deve retornar 0.<br>
     * A função mal suc edida deve retornar -1.<br><br> 
     * <b>Código Erro</b> - <b>Descrição</b><br>
     * -4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porta Fechada<br>
     * -44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Erro Escrita
     */
    public static int ApresentaTextoColorido(String texto, int idTexto, int tamanho, int posY, int posX, String hexadecimal) {
        return pix4.ApresentaTextoColorido(texto, idTexto, tamanho, posY, posX, hexadecimal);
    }

    /**
     * Método utilizado para apresentar uma lista dinâmica de compras.
     *
     * @param descricao Parâmetro do tipo caractere que define a descrição do produto.
     * @param valor Parâmetro do tipo cadeia de caracteres que define o valor do Produto.
     */
    public static void ApresentaListaCompras(String descricao, String valor) {
        pix4.ApresentaListaCompras(descricao, valor);
    }

    /**
     * Método utilizado para inicializar a tela de finalização de venda.
     *
     * @param subTotal Parâmetro do tipo cadeia de caracteres que define o valor do sub total da venda.
     * @param desconto Parâmetro do tipo cadeia de caracteres que define o valor desconto da venda.
     * @param totalPagar Parâmetro do tipo cadeia de caracteres que define o valor total a pagar da venda.
     *
     */
    public static void InicializaLayoutPagamento(String subTotal, String desconto, String totalPagar) {
        pix4.InicializaLayoutPagamento(subTotal, desconto, totalPagar);
    }

    /**
     * Método utilizado para adicionar uma forma de pagamento ao layout de finalização da venda.
     *
     * @param tipoPagamento int - Parâmetro do tipo inteiro que define qual tipo de pagamento sera adicionado. (1 &gt;= tipoPagamento &lt;= 4)<br><br>
     * <b>Valor</b> - <b>Descrição</b><br>
     * 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dinheiro<br> 
     * 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Crédito<br>
     * 3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Débito<br>
     * 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PIX<br>     
     * @param valor Parâmetro do tipo const char* que define o valor da forma dev pagamento.
     * @return int - O retorno da função é do tipo numérico.<br>
     * A função bem sucedida deve retornar 0.<br>
     * A função mal sucedida deve retornar -1.<br>
     */
    public static int AdicionaFormaPagamento(int tipoPagamento, String valor) {
        return pix4.AdicionaFormaPagamento(tipoPagamento, valor);
    }

    /**
     * Metodo para trata retorno da DLL recebendo código e retornando erro se tiver.
     *
     * @param retorno int - recebe o código de retorno do metodos. 
     * @return Stirng - Retorna o erro se tiver, senão vazio sucesso.  
     */
    public static String getTrataRetorno(int retorno) {
        switch (retorno) {
            case 0:
                return "";
            case -1:
                return "Falha";
            case -4:
                return "Porta Fechada";
            case -12:
                return "Dispositivo não existe";
            case -13:
                return "Permissão Negada";
            case -14:
                return "Erro Desconhecido";
            case -19:
                return "Dispositivo Removido Inesperadamente";
            case -44:
                return "Erro Escrita";
            default:
                return "Erro genérico";
        }
    }
}
