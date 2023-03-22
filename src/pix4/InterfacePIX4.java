/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*  https://elgindevelopercommunity.github.io/group__g130.html#ga438acbaa12c823456a108e6cae01ff84
 */
package pix4;

import com.sun.jna.Library;

/**
 *
 * @author Renato Trindade
 */
public interface InterfacePIX4 extends Library {

    
    public int AbreConexaoDisplay(String  porta);

  
    public int ObtemVersaoFirmware();

    
    public boolean ObtemConexao();

    public int DesconectarDisplay();

   
    public int InicializaDisplay();

   
    public int ReinicializaDisplay();

    
    public int CarregaImagemDisplay(String fileName, String filePath, int largura, int altura);

    
    public int ApresentaImagemDisplay(String fileName, int posY, int posX, int tipo);

   
    public int ApresentaQrCode(String qrCode, int tamanho, int posY, int posX);

   
    public int ApresentaTextoColorido(String texto, int idTexto, int tamanho, int posY, int posX, String hexadecimal);

   
    public void ApresentaListaCompras(String descricao, String valor);

    
    public void InicializaLayoutPagamento(String subTotal, String desconto, String totalPagar);

    
    public int AdicionaFormaPagamento(int tipoPagamento, String valor);

}
