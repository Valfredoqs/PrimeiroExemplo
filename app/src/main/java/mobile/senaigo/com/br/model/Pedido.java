package mobile.senaigo.com.br.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pedido {

    private Long id;
    private String data;
    private String cliente;
    private BigDecimal valor;
    private List<Produto> produtos;

    public Pedido(Long id, String data, String cliente, BigDecimal valor, List<Produto> produtos) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valor = valor;
        this.produtos = produtos;
    }

    public Map<String, Object> getMap(){
        Map<String, Object> map = new HashMap<>();
        map.put ("id", id);
        map.put("data", data);
        map.put("cliente", cliente);
        map.put("valor", valor);
        map.put("produtos", produtos);
        return map;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        if (produtos == null){
            produtos = new ArrayList<>();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
