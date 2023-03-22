/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pix4;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato Trindade
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i < 2;i++) {
            System.out.println(PIX4.AbreConexaoDisplay("COM3"));
            System.out.println(PIX4.ObtemVersaoFirmware());
            //  System.out.println(PIX4.ObtemConexao());
            System.out.println(PIX4.InicializaDisplay());
            // System.out.println(PIX4.ApresentaTextoColorido("SENÃO NÃO \n ME CHAMO \n THIAGO", 1, 49, 10, 10, "#080808"));

            PIX4.ApresentaListaCompras("Álcool Gel 70º Asseptgel 420 gr", "10.40");
            PIX4.ApresentaListaCompras("Coca Zero 200ml", "1.99");
            PIX4.ApresentaListaCompras("Café Torrado 3 Corações", "16.98");
            String texto_pix = "00020101021226990014br.gov.bcb.pix2577pix.bpp.com.br/23114447/qrs1/v2/01ZRnKp1BbtS3xsonp1OB9U1PKIecSqWEgBMGECd85jdx52040000530398654041.005802BR5923ESPERANCA M DA S SANTOS6009SAO PAULO62070503***63047620";
            //   String texto_pix="https://www.tagplus.com.br";

            Charset charset = Charset.forName("UTF-8");
            CharsetEncoder encoder = charset.newEncoder();
            byte[] b = null;
            // Convert a string to ISO-8859-1 bytes in a ByteBuffer
            ByteBuffer bbuf;
            try {
                bbuf = encoder.encode(CharBuffer.wrap(texto_pix));
                b = bbuf.array();
            } catch (CharacterCodingException ex) {
                Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }

            String data = "";
            try {
                data = new String(b, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(PIX4.InicializaDisplay());
            PIX4.InicializaLayoutPagamento("29.37", "0", "29.37");
            System.out.println(PIX4.AdicionaFormaPagamento(4, "29.37"));
            System.out.println(PIX4.InicializaDisplay());

            System.out.println(PIX4.ApresentaTextoColorido("Tagplus\n10.753.249\\0001-21\n\nVALOR A PAGAR: R$ 29,37", 1, 20, 290, 10, "#080808"));
            System.out.println(PIX4.ApresentaQrCode(texto_pix, 255, 10, 30));
            //  System.out.println(PIX4.CarregaImagemDisplay("logo.jpg", new File("C:\\rtrindade\\NetBeansProjects\\PIX4\\dist\\tagbank_pix_azul.jpg").getAbsolutePath(), 320, 480));
            System.out.println(PIX4.ApresentaImagemDisplay("logo.jpg", 0, 0, 1));
            System.out.println(PIX4.ReinicializaDisplay());
        }
        //  System.out.println(PIX4.ReinicializaDisplay());
        //  System.out.println(PIX4.AbreConexaoDisplay("COM3"));
        // System.out.println(PIX4.ApresentaImagemDisplay("logo.jpg", 10,10, 0));
        //  System.out.println(PIX4.DesconectarDisplay());
    }

}
