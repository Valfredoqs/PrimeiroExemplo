package mobile.senaigo.com.br;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mobile.senaigo.com.br.model.Pedido;
import mobile.senaigo.com.br.model.Produto;

public class TelaActivity extends AppCompatActivity {

    protected EditText txtValor;
    protected EditText txtCliente;
    protected ListView listView;
    protected List<Map<String, Object>> listPedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela);

        txtValor = findViewById(R.id.txtValor);
        txtCliente = findViewById(R.id.txtCliente);
        listView = findViewById(R.id.txtLista);
        listPedidos = new ArrayList<>();
    }
//
//    public void exibir(View view) {
//
//
//        //procura os componetes da view pelo ID
//        txtNome = findViewById(R.id.txtNome);
//        txtTelefone = findViewById(R.id.txtTelefone);
//        txtEmail = findViewById(R.id.txtEmail);
//
//        //Extrai o conteudo (texto) do componente
//        String nome, telefone, email;
//        nome = txtNome.getText().toString();
//        telefone = txtNome.getText().toString();
//        email = txtNome.getText().toString();
//
//        //Formata saida dos dados
//        String dados = String.format("Os dados informados foram: %s %s %s", nome, telefone, email);
//
//        //Exibe os dados para o usuario
//        Toast.makeText(this, dados, Toast.LENGTH_SHORT).show();
//    }

    public void add(View view) {
        try {
            Pedido aux = new Pedido();
            aux.setCliente(txtCliente.getText().toString());
            aux.setValor(new BigDecimal(txtValor.getText().toString()));
            Random x = new Random();
            aux.setId(x.nextLong(Long.valueOf(10000000000)));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd//MM/yyyy");
            aux.setData(simpleDateFormat.format( new Date()));
            aux.setProdutos(new ArrayList<Produto>());
            listPedidos.add(aux.getMap());
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, listPedidos, R.layout.item_layout, new String[]{"id", "cliente", "data", "valor"}, new  int[]{R.id.labelId, R.id.labelCliente, R.id.labelData, R.id.labelValor});
            listView.setAdapter(simpleAdapter);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Informação");
            alertDialog.setMessage("Pedido adicionado com sucesso");
            alertDialog.show();

        }catch (Exception e){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ERRO");
            alertDialog.setMessage(e.getMessage());
            alertDialog.show();
        }
    }
}
