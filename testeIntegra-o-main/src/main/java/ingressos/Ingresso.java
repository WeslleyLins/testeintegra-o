package ingressos;

import cliente.Consumidor;

public class Ingresso {

    private boolean ingresso;

    private String pegarIngresso;
    private String maiorIdade;
    private String areaConsumidor;

    public Ingresso() {
    }

    public boolean getIngresso() {
        return ingresso;
    }
    public String getMaiorIdade() {
        return maiorIdade;
    }
    public String getCorPulseira() {return pegarIngresso;
    }
    public String getAreaConsumidor() { return areaConsumidor;
    }


    public boolean verificarCompra(Consumidor compra){
        if (compra.comprar() == true){
            this.ingresso = true;
            return true;
        }else{
            this.ingresso = false;
            return false;
        }

    }


    public String verIdade(Consumidor idade){
        if (idade.getIdade() >= 16){
            this.maiorIdade = "É de maior";
            return "É de maior";
        }else {
            this.maiorIdade = "É de menor";
            return "É de menor";
        }
    }

    public String pegarPulseira(Consumidor consumidor){
        if (verificarCompra(consumidor) == true && verIdade(consumidor) =="É de maior"){
            this.pegarIngresso = "Pegar ingresso";
            return "Pegar ingresso";
        }else{
            return "Sem ingresso";
        }
    }

    public String verificarArea(Consumidor consumidor, LugarDisponivel lugar){
        if (lugar.getLugarLivre() >= 1  && consumidor.comprar() == true){
            this.areaConsumidor = "Area correta";
            return "Area correta";
        }else {
            return "Area incorreta";
        }
    }


}
