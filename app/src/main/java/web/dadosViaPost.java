package web;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import objetos.BebidaPedido;
import objetos.Pedido;
import objetos.PratoPedido;
import objetos.Pratos;


/**
 * Created by aluno on 29/10/18.
 */

public class dadosViaPost {
    private String idBanco="pi.rbeninca.com.br/piMari/";

    public void mandarPedido(Pedido pedido) throws IOException {


        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dataBanco = dateFormat.format(date);
            pedido.setDtPedido(dataBanco);
            String bebidaBanco = "{\"pedido\":[\"" + pedido.getDtPedido() + "\",\"" + pedido.getFormaDePagamento() + "\",\"" + pedido.getValorTotal() + "\",\"" + pedido.getDispositivo().getIdDispositivo() + "\",\"" + pedido.getPedidoPrato().getIdPedidoPrato() + "\",\"" + pedido.getPedidoBebida().getIdPedidoBebida() + "\"]}";

            Log.i("435345", bebidaBanco);
            JSONObject jsonRootObject = new JSONObject();

            try {

                jsonRootObject = new JSONObject(bebidaBanco);
                Log.i("AAAAAAAAAAAAAAAAAAAA", jsonRootObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            URL urlFonte = new URL(idBanco+"pedido.php");
            HttpURLConnection urlConnectionFonte = (HttpURLConnection) urlFonte.openConnection();
            urlConnectionFonte.setDoOutput(true);
            urlConnectionFonte.setDoInput(true);
            urlConnectionFonte.setRequestMethod("POST");
            String charset = "UTF-8";
            urlConnectionFonte.setRequestProperty("Accept-Charset", charset);
            urlConnectionFonte.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            PrintStream printStreamFonte = new PrintStream(urlConnectionFonte.getOutputStream());
            printStreamFonte.println(jsonRootObject);
            urlConnectionFonte.connect();
            InputStream inputStreamFonte = urlConnectionFonte.getInputStream();
            BufferedReader readerFonte = new BufferedReader(new InputStreamReader(inputStreamFonte));
            String linhaFonte;
            StringBuilder bufferFonte = new StringBuilder();
            urlConnectionFonte.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void mandarPedidoBebida(BebidaPedido pedido) throws IOException {


        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dataBanco = dateFormat.format(date);

            String bebidaBanco = "{\"pedidoBebida\":[\"" + pedido.getQtBebidaPedido() + "\",\"" + pedido.getSubTotal() + "\",\"" + pedido.getbebida().getId() + "\",\"" + pedido.getObservacao() + "\"]}";

            Log.i("435345", bebidaBanco);
            JSONObject jsonRootObject = new JSONObject();

            try {

                jsonRootObject = new JSONObject(bebidaBanco);
                Log.i("AAAAAAAAAAAAAAAAAAAA", jsonRootObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            URL urlFonte = new URL(idBanco+"pedidobebida.php");
            HttpURLConnection urlConnectionFonte = (HttpURLConnection) urlFonte.openConnection();
            urlConnectionFonte.setDoOutput(true);
            urlConnectionFonte.setDoInput(true);
            urlConnectionFonte.setRequestMethod("POST");
            String charset = "UTF-8";
            urlConnectionFonte.setRequestProperty("Accept-Charset", charset);
            urlConnectionFonte.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            PrintStream printStreamFonte = new PrintStream(urlConnectionFonte.getOutputStream());
            printStreamFonte.println(jsonRootObject);
            urlConnectionFonte.connect();
            InputStream inputStreamFonte = urlConnectionFonte.getInputStream();
            BufferedReader readerFonte = new BufferedReader(new InputStreamReader(inputStreamFonte));
            String linhaFonte;
            StringBuilder bufferFonte = new StringBuilder();
            urlConnectionFonte.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void mandarPedidoPrato(PratoPedido pedido) throws IOException {


        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dataBanco = dateFormat.format(date);

            String bebidaBanco = "{\"pedidoPrato\":[\"" + pedido.getQtPratoPedido() + "\",\"" + pedido.getSubTotal() + "\",\"" + pedido.getPrato().getIdPrato() + "\",\"" + pedido.getObservacao() + "\"]}";

            Log.i("435345", bebidaBanco);
            JSONObject jsonRootObject = new JSONObject();

            try {

                jsonRootObject = new JSONObject(bebidaBanco);
                Log.i("AAAAAAAAAAAAAAAAAAAA", jsonRootObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            URL urlFonte = new URL(idBanco+"pratoPedido.php");
            HttpURLConnection urlConnectionFonte = (HttpURLConnection) urlFonte.openConnection();
            urlConnectionFonte.setDoOutput(true);
            urlConnectionFonte.setDoInput(true);
            urlConnectionFonte.setRequestMethod("POST");
            String charset = "UTF-8";
            urlConnectionFonte.setRequestProperty("Accept-Charset", charset);
            urlConnectionFonte.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            PrintStream printStreamFonte = new PrintStream(urlConnectionFonte.getOutputStream());
            printStreamFonte.println(jsonRootObject);
            urlConnectionFonte.connect();
            InputStream inputStreamFonte = urlConnectionFonte.getInputStream();
            BufferedReader readerFonte = new BufferedReader(new InputStreamReader(inputStreamFonte));
            String linhaFonte;
            StringBuilder bufferFonte = new StringBuilder();
            urlConnectionFonte.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getDadosPrato(Pratos prato) throws IOException {



    }

}





